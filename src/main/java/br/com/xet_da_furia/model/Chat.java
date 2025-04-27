package br.com.xet_da_furia.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "chats")
public class Chat {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	private String nome;
	
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private Jogo jogo;
	
	@Enumerated(EnumType.STRING)
	private Tema tema;
	
	@Column(name = "criado_em")
	private LocalDateTime criadaEm;
	
	@ManyToOne()
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario administrador;

	public Chat(String nome, String descricao, Jogo jogo, Tema tema) {
		this.id = null;
		this.nome = nome;
		this.descricao = descricao;
		this.jogo = jogo;
		this.tema = tema;
		this.criadaEm = LocalDateTime.now();
	}	
}


