package br.com.xet_da_furia.model.dto;

import java.time.format.DateTimeFormatter;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.xet_da_furia.model.Chat;
import br.com.xet_da_furia.utils.ConversorDTO;
import lombok.Data;

@Data
public class ChatDetailsDTO {
	private String id;
	
	private String nome;
	
	private String descricao;
	
	private String jogo;
	
	private String tema;
	
	private String criadaEm;
	
	private UsuarioResponseDTO administrador;
	
	@JsonIgnore
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	public ChatDetailsDTO(Chat chat) {
		this.id = chat.getId();
		this.nome = chat.getNome();
		this.descricao = chat.getDescricao();
		this.jogo = chat.getJogo().toString();
		this.tema = chat.getTema().toString();
		this.criadaEm = dtf.format(chat.getCriadaEm());
		
		this.administrador = ConversorDTO.usuario(chat.getAdministrador());
	}
}
