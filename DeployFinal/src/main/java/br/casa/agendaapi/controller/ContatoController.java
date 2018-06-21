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

import br.casa.agendaapi.model.Contato;
import br.casa.agendaapi.repository.ContatoRepository;

@RestController
@RequestMapping("/api")
public class ContatoController {

	@Autowired
	ContatoRepository contatoRepository;

	@GetMapping("/agenda")
	public List<Contato> getAllContatos() {
		return contatoRepository.findAll();

	}

	@GetMapping("/agenda/{id}")
	public ResponseEntity<Contato> getContatoById(@PathVariable(value = "id") Long contatoId) {
		Contato contato = contatoRepository.findOne(contatoId);

		if (contato == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(contato);

	}

	@PostMapping("/agenda")
	public Contato createContato(@Valid @RequestBody Contato contato) {
		return contatoRepository.save(contato);
	}

	@DeleteMapping("/agenda/{id}")
	public void deleteContato(@PathVariable(value = "id") Long contatoId) {
		contatoRepository.delete(contatoId);
	}

	// @DeleteMapping("/agenda/{id}")
	// public ResponseEntity<Contato> deleteContato(@PathVariable(value = "id")
	// Long contatoId) {
	// contatoRepository.delete(contatoId);
	// return ResponseEntity.ok().body(new Contato());
	// }

	@PutMapping("/agenda/{id}")
	public Contato putContato(@PathVariable(value = "id") Long contatoId, @Valid @RequestBody Contato contato) {

		System.out.println(contato.getNomeFantasia());

		Contato contatoAtualizado = new Contato();

		System.out.println(contato + "contato");
		contatoAtualizado.setId_contato(contatoId);
		contatoAtualizado.setNomeFantasia(contato.getNomeFantasia());
		contatoAtualizado.setRazaoSocial(contato.getRazaoSocial());
		contatoAtualizado.setCnpj(contato.getCnpj());
		contatoAtualizado.setTelefone1(contato.getTelefone1());
		contatoAtualizado.setTelefone2(contato.getTelefone2());
		contatoAtualizado.setEmail(contato.getEmail());
		contatoAtualizado.setLogradouro(contato.getLogradouro());
		contatoAtualizado.setNumero(contato.getNumero());
		contatoAtualizado.setBairro(contato.getBairro());
		contatoAtualizado.setCep(contato.getCep());
		contatoAtualizado.setLocalidade(contato.getLocalidade());
		contatoAtualizado.setUf(contato.getUf());
		contatoAtualizado.setComplemento(contato.getComplemento());
		contatoAtualizado.setObservacao(contato.getObservacao());

		return contatoRepository.save(contatoAtualizado);
	}

}
