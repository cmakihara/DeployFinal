package br.casa.agendaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.casa.agendaapi.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{
	
}
