package br.com.xet_da_furia.model.dto;

import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.xet_da_furia.model.Mensagem;
import br.com.xet_da_furia.utils.ConversorDTO;
import lombok.Data;

@Data
public class MensagemDTO {

	private String id;
	
	private String conteudo;
	
	private String dataEnvio;
	
	private UsuarioResponseDTO usuario;
	
	@JsonIgnore
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	public MensagemDTO(Mensagem mensagem) {
		this.id = mensagem.getId();
		this.usuario = ConversorDTO.usuario(mensagem.getUsuario());
		this.conteudo = mensagem.getConteudo();
		this.dataEnvio = mensagem.getDataEnvio().format(dtf);
	}
}



