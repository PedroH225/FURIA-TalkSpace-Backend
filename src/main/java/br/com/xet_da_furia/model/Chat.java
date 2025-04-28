package br.com.xet_da_furia.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "usuario_chat",
	joinColumns = @JoinColumn(name = "chat_id"),
	inverseJoinColumns = @JoinColumn(name = "usuario_id"))
	private List<Usuario> participantes = new ArrayList<Usuario>();
	
	@OneToMany(mappedBy = "chat")
	private List<Mensagem> mensagens = new ArrayList<Mensagem>();

	public Chat(String nome, String descricao, Jogo jogo, Tema tema, Usuario usuario) {
		this.id = null;
		this.nome = nome;
		this.descricao = descricao;
		this.jogo = jogo;
		this.tema = tema;
		this.criadaEm = LocalDateTime.now();
		this.administrador = usuario;
	}	
	
	public void adicionarParticipante(Usuario usuario) {
		this.participantes.add(usuario);
		usuario.getChatsParticipados().add(this);
	}

	public void removerParticipante(Usuario usuario) {
		this.participantes.remove(usuario);
		usuario.getChatsParticipados().remove(this);		
	}
}


