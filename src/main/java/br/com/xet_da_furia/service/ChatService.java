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
		
		novoChat.adicionarParticipante(usuario);
		
		return ConversorDTO.chatDetails(chatRepository.save(novoChat));
	}
	
	public ChatDetailsDTO addParticipante(String chatId, String usuarioId) {
		Chat buscarChat = findById(chatId);
		Usuario buscarUsuario = usuarioService.findById(usuarioId);
		
		Optional<Usuario> buscarParticipante = buscarChat.getParticipantes().stream()
				.filter(p -> p.getId().equals(usuarioId))
				.findFirst();
		
		if (buscarParticipante.isPresent()) {
			throw new RuntimeException("Você já está participando.");
		}
		
		buscarChat.adicionarParticipante(buscarUsuario);
	
		return ConversorDTO.chatDetails(chatRepository.save(buscarChat));
	}
	
	public ChatDetailsDTO removerParticipante(String chatId, String usuarioId) {
		Chat buscarChat = findById(chatId);
		Usuario buscarUsuario = usuarioService.findById(usuarioId);
		
		Optional<Usuario> buscarParticipante = buscarChat.getParticipantes().stream()
				.filter(p -> p.getId().equals(usuarioId))
				.findFirst();
		
		if (buscarParticipante.isEmpty()) {
			throw new RuntimeException("Você não está participando.");
			
		} 
		
		if (buscarChat.getAdministrador().getId().equals(usuarioId)) {
			throw new RuntimeException("Administradores não podem retirar a participação!");
		}
		
		buscarChat.removerParticipante(buscarUsuario);
	
		return ConversorDTO.chatDetails(chatRepository.save(buscarChat));
	}
	
}
