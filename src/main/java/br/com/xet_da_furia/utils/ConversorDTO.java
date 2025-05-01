package br.com.xet_da_furia.utils;

import java.util.List;
import java.util.stream.Collectors;

import br.com.xet_da_furia.model.Chat;
import br.com.xet_da_furia.model.Mensagem;
import br.com.xet_da_furia.model.Usuario;
import br.com.xet_da_furia.model.dto.ChatDetailsDTO;
import br.com.xet_da_furia.model.dto.ChatResponseDTO;
import br.com.xet_da_furia.model.dto.MensagemDTO;
import br.com.xet_da_furia.model.dto.UsuarioDetailsDTO;
import br.com.xet_da_furia.model.dto.UsuarioResponseDTO;

public class ConversorDTO {
	public static ChatResponseDTO chat(Chat chat) {
		return new ChatResponseDTO(chat);
	}
	
	public static ChatDetailsDTO chatDetails(Chat chat) {
		return new ChatDetailsDTO(chat, IdToken.get());
	}
	
	public static List<ChatResponseDTO> chats(List<Chat> chats) {
		return chats.stream()
				.map(c -> new ChatResponseDTO(c))
				.collect(Collectors.toList());
	}
	
	public static UsuarioResponseDTO usuario(Usuario usuario) {
		return new UsuarioResponseDTO(usuario);
	}
	
	public static UsuarioDetailsDTO usuarioDetails(Usuario usuario) {
		return new UsuarioDetailsDTO(usuario);
	}
	
	public static List<UsuarioResponseDTO> usuarios(List<Usuario> usuarios) {
		return usuarios.stream()
				.map(u -> new UsuarioResponseDTO(u))
				.collect(Collectors.toList());
	}
	
	public static List<MensagemDTO> mensagens(List<Mensagem> mensagens) {
		return mensagens.stream()
				.map(m -> new MensagemDTO(m))
				.collect(Collectors.toList());
	}
	
	public static MensagemDTO mensagem(Mensagem mensagem) {
		return new MensagemDTO(mensagem);
	}

}
