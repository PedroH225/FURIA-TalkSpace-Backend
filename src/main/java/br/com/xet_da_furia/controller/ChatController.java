package br.com.xet_da_furia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.xet_da_furia.model.Chat;
import br.com.xet_da_furia.model.dto.ChatDetailsDTO;
import br.com.xet_da_furia.model.dto.ChatResponseDTO;
import br.com.xet_da_furia.service.ChatService;
import br.com.xet_da_furia.utils.IdToken;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/chats")
public class ChatController {
	
	private ChatService chatService;
	
	@GetMapping
	public List<ChatResponseDTO> buscarTodos() {		
		return chatService.findAll();
	}
	
	@GetMapping("/{id}")
	public ChatDetailsDTO buscarChat(@PathVariable String id) {
		return chatService.buscarChat(id);
	}
	
	@PostMapping
	public ChatDetailsDTO criarChat(@RequestBody Chat chat) {
		return chatService.save(chat, IdToken.get());
	}
	
	@PutMapping("/addUser/{chatId}")
	public ChatDetailsDTO adicionarParticipante(@PathVariable String chatId) {
		return chatService.addParticipante(chatId, IdToken.get());
	}
	
	@DeleteMapping("/removerUser/{chatId}")
	public ChatDetailsDTO removerParticipante(@PathVariable String chatId) {
		return chatService.removerParticipante(chatId, IdToken.get());
	}
}





