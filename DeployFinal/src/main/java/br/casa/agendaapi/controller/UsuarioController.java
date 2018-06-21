package br.casa.agendaapi.controller;

import java.util.ArrayList;
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

import br.casa.agendaapi.model.Usuario;
import br.casa.agendaapi.repository.UsuarioRepository;
import br.casa.dto.UsuarioDTO;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/usuario")
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
        
    }
    
    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> getUsuarioById
    			(@PathVariable(value = "id") Long usuarioId) {
        Usuario usuario = usuarioRepository.findOne(usuarioId);
        
        if(usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(usuario);
        
    }
    
    @PostMapping("/usuario")
    public Usuario createUsuario(@Valid @RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
    
    @PostMapping("/usuario/login")
    public Usuario login(@Valid @RequestBody Usuario usuario) {
    	List<Usuario> todos = new ArrayList<>();
    	todos = usuarioRepository.findAll();
    	
    	for (Usuario user : todos) {
			if(user.getUsuario().equals(usuario.getUsuario()) && user.getSenha().equals(usuario.getSenha())) {
				return user;
			}
		}
    	usuario.setUsuario(null);	
    	return usuario;
    }
    
    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable(value = "id") Long UsuarioId) {
    	usuarioRepository.delete(UsuarioId);
    	return null;
    }
    
    @PutMapping("/usuario/{id}")   
    public Usuario putUsuario(@PathVariable(value = "id") Long UsuarioId,@Valid @RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/usuario/setadmintrue/{id}")
    public void setAdminTrue(@PathVariable(value = "id") Long id_usuario) {
    	usuarioRepository.setAdminTrue(id_usuario);
    }
    
    @GetMapping("/usuario/setadminfalse/{id}")
    public void setAdminFalse(@PathVariable(value="id") Long id_usuario) {
    	usuarioRepository.setAdminFalse(id_usuario);
    }
    
    @GetMapping("usuario/setativo/{id}")
    public void setAtivo(@PathVariable(value="id") Long id_usuario) {
    	usuarioRepository.setAtivo(id_usuario);
    }
    
    @GetMapping("usuario/setinativo/{id}")
    public void setInativo(@PathVariable(value="id") Long id_usuario) {
    	usuarioRepository.setInativo(id_usuario);
    }
	
}
