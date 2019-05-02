package org.daniel.javaTeste.controller;

import java.util.List;

import org.daniel.javaTeste.model.Pessoa;
import org.daniel.javaTeste.service.PessoaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class PessoaController {
	
	public static final Logger logger = LoggerFactory.getLogger(PessoaController.class);
	
	@Autowired
	PessoaService pessoaService;
	
	@RequestMapping(value = "/pessoa/", method = RequestMethod.GET)
	public ResponseEntity<List<Pessoa>> buscarTodasPeassoas() {
		List<Pessoa> listaPessoa = pessoaService.buscarTodasPessoas();	
		if(listaPessoa.isEmpty()) {
		return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Pessoa>>(listaPessoa,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/pessoa/", method = RequestMethod.POST)
	public ResponseEntity<?> salvarPessoa(@RequestBody Pessoa pessoa, UriComponentsBuilder ucBuilder) {
		logger.info("Criando pessoa : {}", pessoa);	
		pessoaService.salvarPessoa(pessoa);
		return new ResponseEntity<Pessoa>(HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/pessoa/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> autualizarPessoa(@PathVariable("id") long id, @RequestBody Pessoa pessoa) {
		logger.info("Atualizando pessoa {}", id);
		Pessoa pessoaAtual = pessoaService.findById(id);
		if (pessoa == null) {
			logger.error("Não foi possivel atualizar. pessoa {} não encontrada.", id);
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		pessoaAtual.setNome(pessoa.getNome());
		pessoaAtual.setCpf(pessoa.getCpf());
		pessoaAtual.setDtNascimento(pessoa.getDtNascimento());
		pessoaAtual.setEmail(pessoa.getEmail());
		pessoaAtual.setSexo(pessoa.getSexo());
		pessoaAtual.setAtivo(pessoa.getAtivo());
		pessoaAtual.setEstadoCivil(pessoa.getEstadoCivil());
		
		pessoaService.atualizarPessoa(pessoaAtual);
		return new ResponseEntity<Pessoa>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/pessoa/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletarPessoa(@PathVariable("id") Long id) {
		logger.info("Deletando pessoa id {}", id);
		
		Pessoa pessoaAtual = pessoaService.findById(id);
		if (pessoaAtual == null) {
			logger.error("Não foi possivel deletar. pessoa {} não encontrada.", id);
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
		pessoaService.deletarPessoa(id);
		return new ResponseEntity<Pessoa>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/pessoa/cpf/{cpf}", method = RequestMethod.GET)
	public ResponseEntity<List<Pessoa>> buscarPorCpf(@PathVariable("cpf") Long cpf) {
		List<Pessoa> listaPessoa = pessoaService.buscarPorCpf(cpf);	
		if(listaPessoa.isEmpty()) {
		return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Pessoa>>(listaPessoa,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/pessoa/nome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<List<Pessoa>> buscarPorNome(@PathVariable("nome") String nome) {
		List<Pessoa> listaPessoa = pessoaService.buscarPorNome(nome);	
		if(listaPessoa.isEmpty()) {
		return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Pessoa>>(listaPessoa,HttpStatus.OK);
	}
	
}
	
	


