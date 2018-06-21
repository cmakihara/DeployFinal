package br.casa.agendaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.casa.agendaapi.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
