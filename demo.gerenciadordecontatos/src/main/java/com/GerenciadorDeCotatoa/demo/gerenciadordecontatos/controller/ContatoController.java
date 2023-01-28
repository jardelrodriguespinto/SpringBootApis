package com.GerenciadorDeCotatoa.demo.gerenciadordecontatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.GerenciadorDeCotatoa.demo.gerenciadordecontatos.entity.Contato;
import com.GerenciadorDeCotatoa.demo.gerenciadordecontatos.service.ContatoService;

@RestController
public class ContatoController {

	@Autowired
	private ContatoService contato;
	
	//obter todos contatos 
	@GetMapping("/contatos")
	public ResponseEntity<List<Contato>> obterTodosContatos(){
		try {
			List<Contato> contatos = contato.obterTodosContatos();
			return new ResponseEntity<List<Contato>>(contatos, HttpStatus.OK);
		} catch (Exception erro) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	//obter contato pelo id
	@GetMapping("/contatos/{contato_id}")
	public ResponseEntity<Contato> obterContatoPeloId(@PathVariable Long contato_id) {
		Contato buscarContato = contato.obterContatoPeloId(contato_id);
		if(buscarContato != null) {
			return new ResponseEntity<Contato>(buscarContato, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	// adicionar novo contato
	@PostMapping("/contatos")
	public ResponseEntity<Contato> adicionarContato(@RequestBody Contato novoContato) {
		Contato adicionarNovoContato = contato.adicionarContato(novoContato);
		if(novoContato != null) {
			return new ResponseEntity<Contato>(adicionarNovoContato, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	//alterar contato
	@PutMapping("/contatos/{contato_id}")
	public ResponseEntity<Contato> modificarContato(@PathVariable Long contato_id,@RequestBody Contato contatoAtualizado) {
		Contato alterarContato = contato.modificarContato(contato_id, contatoAtualizado);
		if(alterarContato != null) {
			return new ResponseEntity<Contato>(alterarContato, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	// deletar contato
	@DeleteMapping("/contatos/{contato_id}")
	 public ResponseEntity<String> deletarContato(@PathVariable Long contato_id){	
		Contato deletarContato = contato.obterContatoPeloId(contato_id);
		if(deletarContato != null) {
			contato.deletarContato(contato_id);
			return new ResponseEntity<>("Contato deletado com sucesso", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Contato não encontrado",HttpStatus.BAD_REQUEST);
		}
	}
	
}
