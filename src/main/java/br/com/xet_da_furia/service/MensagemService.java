package br.com.xet_da_furia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.xet_da_furia.model.Mensagem;
import br.com.xet_da_furia.model.dto.MensagemDTO;
import br.com.xet_da_furia.repository.MensagemRepository;
import br.com.xet_da_furia.utils.ConversorDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MensagemService {

	private MensagemRepository mensagemRepository;
	
	private ChatService chatService;
	
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
}
