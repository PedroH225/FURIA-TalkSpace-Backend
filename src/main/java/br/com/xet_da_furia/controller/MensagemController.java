package br.com.xet_da_furia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.xet_da_furia.model.dto.MensagemDTO;
import br.com.xet_da_furia.service.MensagemService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/mensagens")
public class MensagemController {

	private MensagemService mensagemService;
		
	@GetMapping
	public List<MensagemDTO> buscarTodos() {		
		return mensagemService.findAll();
	}
	
	@GetMapping("/{id}")
	public MensagemDTO buscarMensagem(@PathVariable String id) {
		return mensagemService.buscarMensagem(id);
	}
	
}
