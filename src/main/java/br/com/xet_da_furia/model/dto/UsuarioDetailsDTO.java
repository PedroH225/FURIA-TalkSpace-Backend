package br.com.xet_da_furia.model.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.xet_da_furia.model.Chat;
import br.com.xet_da_furia.model.Usuario;
import br.com.xet_da_furia.utils.ConversorDTO;
import lombok.Data;

@Data
public class UsuarioDetailsDTO {
	private String id;
	
	private String nome;
	
	private String email;
	
	private List<ChatResponseDTO> chatsCriados = new ArrayList<ChatResponseDTO>();
	
	public UsuarioDetailsDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		
		this.chatsCriados = ConversorDTO.chats(usuario.getChatsCriados());
	}
	
}
