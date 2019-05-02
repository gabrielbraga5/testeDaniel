package org.daniel.javaTeste.service;

import java.util.List;

import javax.transaction.Transactional;

import org.daniel.javaTeste.model.Pessoa;
import org.daniel.javaTeste.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pessoaService")
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Transactional
	public List<Pessoa> buscarTodasPessoas(){		
		return pessoaRepository.buscarTodasPessoas();		
	}
	
	@Transactional
	public Pessoa salvarPessoa(Pessoa pessoa) {
		pessoaRepository.salvarPessoa(pessoa);
		return pessoa;
	}

	@Transactional
	public Pessoa atualizarPessoa(Pessoa pessoa) {
		pessoaRepository.alterarPessoa(pessoa);
		return pessoa;
	}

	@Transactional
	public void deletarPessoa(Long id) {
		pessoaRepository.excluirPessoa(id);
	}	
	
	@Transactional
	public Pessoa findById(Long id) {
		return pessoaRepository.findById(id);
	}
	
	@Transactional
	public List<Pessoa> buscarPorCpf(Long cpf){
		return pessoaRepository.buscarPorCpf(cpf);
	}
	
	@Transactional
	public List<Pessoa> buscarPorNome(String nome){
		return pessoaRepository.buscarPorNome(nome);
	}
	
}
