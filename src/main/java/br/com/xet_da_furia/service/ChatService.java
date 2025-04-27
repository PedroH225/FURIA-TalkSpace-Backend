package br.com.xet_da_furia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.xet_da_furia.model.Chat;
import br.com.xet_da_furia.model.Usuario;
import br.com.xet_da_furia.model.dto.ChatDetailsDTO;
import br.com.xet_da_furia.model.dto.ChatResponseDTO;
import br.com.xet_da_furia.repository.ChatRepository;
import br.com.xet_da_furia.utils.ConversorDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ChatService {

	private ChatRepository chatRepository;
	
	private UsuarioService usuarioService;
	
	public List<ChatResponseDTO> findAll() {
		return ConversorDTO.chats(chatRepository.findAll());
	}
	
	public Chat findById(String id) {
		Optional<Chat> buscarChat = chatRepository.findById(id);
		
		if (buscarChat.isEmpty()) {
			throw new RuntimeException("Chat não encontrado.");
		}
		
		return buscarChat.get();
	}
	
	public ChatDetailsDTO buscarChat(String id) {
		Chat chat = findById(id);
		
		return ConversorDTO.chatDetails(chat);
	}
	
	public ChatDetailsDTO save(Chat chat, String usuarioId) {
		Usuario usuario = usuarioService.findById(usuarioId);
		
		Chat novoChat = new Chat(chat.getNome(), chat.getDescricao(), chat.getJogo(), chat.getTema(), usuario);
		
		return ConversorDTO.chatDetails(chatRepository.save(novoChat));
	}
}
