package br.casa.agendaapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.casa.agendaapi.model.Produto;
import br.casa.agendaapi.repository.ProdutoRepository;

@RestController
@RequestMapping("/api")
public class ProdutoController {

	@Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produto")
    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }
    
    
    @GetMapping("/produto/{id}")
    public ResponseEntity<Produto> getProdutoById
    			(@PathVariable(value = "id") Long produtoId) {
    	Produto produto = produtoRepository.findOne(produtoId);
        if(produto == null) {
            return ResponseEntity.notFound().build();
        }
       
        return ResponseEntity.ok().body(produto);
    }
    
    @PostMapping("/produto")
    public Produto createProduto(@Valid @RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }
    
    
    @DeleteMapping("/produto/{id}")
    public ResponseEntity<Produto> deleteProduto(@PathVariable(value = "id") Long produtoId) {
    	produtoRepository.delete(produtoId);
    	return null;
    }
    @PutMapping("/produto/{id}")
    public Produto putProduto(@PathVariable(value = "id") Long produtoId,@Valid @RequestBody Produto produto) {
    	
    	Produto produtoAtualizado = new Produto();
        
    	produtoAtualizado.setId_produto(produtoId);
    	produtoAtualizado.setCodigoBarra(produto.getCodigoBarra());
    	produtoAtualizado.setDescricao(produto.getDescricao());
    	produtoAtualizado.setMedida(produto.getMedida());
    	produtoAtualizado.setNomeproduto(produto.getNomeproduto());
    	produtoAtualizado.setQtdMinima(produto.getQtdMinima());
    	produtoAtualizado.setCategoria(produto.getCategoria());
    	produtoAtualizado.setValor(produto.getValor());
    	
    	
    	return produtoRepository.save(produtoAtualizado);
    }




	
	
	
}
