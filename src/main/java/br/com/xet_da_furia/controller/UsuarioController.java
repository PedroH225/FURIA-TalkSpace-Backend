package br.com.xet_da_furia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.xet_da_furia.model.Usuario;
import br.com.xet_da_furia.service.UsuarioService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	private UsuarioService usuarioService;
	
	@GetMapping
	public List<Usuario> buscarTodos() {		
		return usuarioService.findAll();
	}
	
	@GetMapping("/{id}")
	public Usuario buscarUsuario(@PathVariable String id) {
		return usuarioService.findById(id);
	}
	
	@PostMapping
	public Usuario criarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}
}





