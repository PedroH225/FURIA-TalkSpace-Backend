package br.com.xet_da_furia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.xet_da_furia.model.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, String>{

}
