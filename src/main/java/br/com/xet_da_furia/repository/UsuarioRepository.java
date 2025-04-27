package br.com.xet_da_furia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.com.xet_da_furia.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{

	UserDetails findByEmail(String email);

	@Query("SELECT u FROM Usuario u WHERE u.email = :email")
	Optional<Usuario> buscarPorEmail(String email);

}
