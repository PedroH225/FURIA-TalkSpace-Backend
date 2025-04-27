package br.com.xet_da_furia.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.xet_da_furia.model.Usuario;
import br.com.xet_da_furia.model.dto.LoginDto;
import br.com.xet_da_furia.model.dto.RegisterDTO;
import br.com.xet_da_furia.model.dto.UsuarioDetailsDTO;
import br.com.xet_da_furia.model.dto.UsuarioResponseDTO;
import br.com.xet_da_furia.service.AuthorizationService;
import br.com.xet_da_furia.service.UsuarioService;
import br.com.xet_da_furia.utils.ConversorDTO;
import br.com.xet_da_furia.utils.IdToken;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	private UsuarioService usuarioService;
	
	private AuthorizationService authorizationService;
	
	@GetMapping
	public List<UsuarioResponseDTO> buscarTodos() {		
		return ConversorDTO.usuarios(usuarioService.findAll());
	}
	
	@GetMapping("/find")
	public UsuarioDetailsDTO buscarUsuario() {
		return usuarioService.buscarUsuario(IdToken.get());
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<Object> criarUsuario(@RequestBody RegisterDTO registerDTO) {
		return authorizationService.register(registerDTO);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody LoginDto loginDto) {
		return authorizationService.login(loginDto);
	}
}





