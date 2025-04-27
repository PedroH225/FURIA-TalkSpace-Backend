package br.com.xet_da_furia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.xet_da_furia.model.Usuario;
import br.com.xet_da_furia.model.dto.UsuarioDetailsDTO;
import br.com.xet_da_furia.repository.UsuarioRepository;
import br.com.xet_da_furia.utils.ConversorDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UsuarioService {

	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	public Usuario findById(String id) {
		Optional<Usuario> buscarUsuario = usuarioRepository.findById(id);
		
		if (buscarUsuario.isEmpty()) {
			throw new RuntimeException("Usuário não encontrado.");
		}
		
		return buscarUsuario.get();
	}
	
	public UsuarioDetailsDTO buscarUsuario(String id) {
		Usuario usuario = findById(id);
		
		return ConversorDTO.usuarioDetails(usuario);
	}
	
	public UsuarioDetailsDTO save(Usuario usuario) {
		Usuario novoUsuario = new Usuario(usuario.getNome(), usuario.getEmail(), usuario.getSenha());
		
		return ConversorDTO.usuarioDetails(usuarioRepository.save(novoUsuario));
	}
}
