package br.com.xet_da_furia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import br.com.xet_da_furia.model.Chat;
import br.com.xet_da_furia.model.Mensagem;
import br.com.xet_da_furia.model.Usuario;
import br.com.xet_da_furia.model.dto.MensagemDTO;
import br.com.xet_da_furia.repository.MensagemRepository;
import br.com.xet_da_furia.utils.ChatUtils;
import br.com.xet_da_furia.utils.ConversorDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MensagemService {

	private MensagemRepository mensagemRepository;
	
	private ChatService chatService;
	
	private UsuarioService usuarioService;
	
	private final SimpMessagingTemplate messagingTemplate;
	
	public List<MensagemDTO> findAll() {
		return ConversorDTO.mensagens(mensagemRepository.findAll());
	}
	
	public Mensagem findById(String id) {
		Optional<Mensagem> buscarMensagem = mensagemRepository.findById(id);
		
		if (buscarMensagem.isEmpty()) {
			throw new RuntimeException("Mensagem não encontrada.");
		}
		
		return buscarMensagem.get();
	}
	
	public MensagemDTO buscarMensagem(String id) {
		Mensagem mensagem = findById(id);
		
		return ConversorDTO.mensagem(mensagem);
	}

	public MensagemDTO novaMensagem(String chatId, String usuarioId, String conteudo) {
		Chat chat = chatService.findById(chatId);
		
		ChatUtils.garantirParticipacao(chat, usuarioId);

		Usuario usuario = usuarioService.findById(usuarioId);
		
		Mensagem mensagem = new Mensagem(chat, usuario, conteudo);
		
		MensagemDTO mensagemDTO = ConversorDTO.mensagem(mensagemRepository.save(mensagem));
		
	    messagingTemplate.convertAndSend("/topic/chat/" + chatId, mensagemDTO);

		return mensagemDTO;
	}

	public List<MensagemDTO> buscarMensagensChat(String chatId) {
		List<Mensagem> mensagens = mensagemRepository.findAllByChatIdOrderByDataEnvio(chatId);
		
		return ConversorDTO.mensagens(mensagens);
	}
}





