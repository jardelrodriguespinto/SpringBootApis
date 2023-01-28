package com.GerenciadorDeCotatoa.demo.gerenciadordecontatos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GerenciadorDeCotatoa.demo.gerenciadordecontatos.repository.ContatoRepository;
import com.GerenciadorDeCotatoa.demo.gerenciadordecontatos.entity.Contato;
import java.util.List;

@Service
public class ContatoService {
	@Autowired
	private ContatoRepository repository;

	public ContatoService(ContatoRepository repository) {
		this.repository = repository;
	}
	
	public List<Contato> obterTodosContatos(){
		return repository.findAll();
	}
	
	public Contato obterContatoPeloId(Long contato_id) {
		return repository.findById(contato_id).orElse(null);
	}
	
	public Contato adicionarContato(Contato novoContato) {
		
		return repository.save(novoContato);
	}
	
	//alterar contato
	public Contato modificarContato(Long contato_id,Contato contatoAtualizado){
		//checando se o contato existe 
		Contato contato = repository.findById(contato_id).orElse(null);
		// caso o contato não seja nulo atribuir novos dados a este contato
		if(contato != null) {
			contato.setNome(contatoAtualizado.getNome());
			contato.setNumeroDeCelular(contatoAtualizado.getNumeroDeCelular());
			contato.setEmail(contatoAtualizado.getEmail());
			contato.setEndereco(contatoAtualizado.getEndereco());
			return repository.save(contato);
		} else {
			return null;
		}
	}
	//remover contato
	public void deletarContato(Long contato_id) {
		repository.deleteById(contato_id);
	}
}
