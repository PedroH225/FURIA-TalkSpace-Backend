package br.com.xet_da_furia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.xet_da_furia.model.Chat;
import br.com.xet_da_furia.model.dto.ChatDetailsDTO;
import br.com.xet_da_furia.model.dto.ChatResponseDTO;
import br.com.xet_da_furia.service.ChatService;
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
	
	@PostMapping("/{usuarioId}")
	public ChatDetailsDTO criarChat(@RequestBody Chat chat, @PathVariable String usuarioId) {
		return chatService.save(chat, usuarioId);
	}
}





