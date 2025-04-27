package br.com.xet_da_furia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.xet_da_furia.model.Chat;
import br.com.xet_da_furia.repository.ChatRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ChatService {

	private ChatRepository chatRepository;
	
	public List<Chat> findAll() {
		return chatRepository.findAll();
	}
	
	public Chat findById(String id) {
		Optional<Chat> buscarChat = chatRepository.findById(id);
		
		if (buscarChat.isEmpty()) {
			throw new RuntimeException("Chat não encontrado.");
		}
		
		return buscarChat.get();
	}
	
	public Chat save(Chat chat) {
		Chat novoChat = new Chat(chat.getNome(), chat.getDescricao(), chat.getJogo(), chat.getTema());
		
		return chatRepository.save(novoChat);
	}
}
