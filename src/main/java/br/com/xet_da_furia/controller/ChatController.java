package br.com.xet_da_furia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.xet_da_furia.model.Chat;
import br.com.xet_da_furia.service.ChatService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/chats")
public class ChatController {
	
	private ChatService chatService;
	
	@GetMapping
	public List<Chat> buscarTodos() {		
		return chatService.findAll();
	}
	
	@GetMapping("/{id}")
	public Chat buscarChat(@PathVariable String id) {
		return chatService.findById(id);
	}
	
	@PostMapping
	public Chat criarChat(@RequestBody Chat chat) {
		return chatService.save(chat);
	}
}





