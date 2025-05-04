package br.com.xet_da_furia.model.dto;

import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.xet_da_furia.model.Chat;
import br.com.xet_da_furia.utils.IdToken;
import lombok.Data;

@Data
public class ChatResponseDTO {
	private String id;
	
	private String nome;
	
	private String descricao;
	
	private String jogo;
	
	private String tema;
	
	private String criadaEm;
	
	private boolean isParticipando;
	
	@JsonIgnore
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

	public ChatResponseDTO(Chat chat) {
		this.id = chat.getId();
		this.nome = chat.getNome();
		this.descricao = chat.getDescricao();
		this.jogo = chat.getJogo().toString();
		this.tema = chat.getTema().toString();
		this.criadaEm = dtf.format(chat.getCriadaEm());
		
		String id = IdToken.get();
		
		this.isParticipando = chat.getParticipantes().stream()
				.anyMatch(p -> p.getId().equals(id));
	}
	
	
}
