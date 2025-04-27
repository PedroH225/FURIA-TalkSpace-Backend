package br.com.xet_da_furia.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	private String nome;
	
	private String email;
	
	private String senha;
	
	private LocalDateTime criadoEm;
	
	@OneToMany(mappedBy = "administrador")
	private List<Chat> chatsCriados;

	public Usuario(String nome, String email, String senha) {
		this.id = null;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.criadoEm = LocalDateTime.now();
	}
	

}
