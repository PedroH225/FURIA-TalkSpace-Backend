package br.com.xet_da_furia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.xet_da_furia.model.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, String>{

}
