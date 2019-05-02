package org.daniel.javaTeste.repository;

import java.util.List;

import org.daniel.javaTeste.model.Pessoa;

public interface PessoaRepository {
	
	public Pessoa salvarPessoa(Pessoa pessoa);
	
	public void alterarPessoa(Pessoa pessoa);
	
	public void excluirPessoa(Long id);
	
	public List<Pessoa> buscarTodasPessoas();
	
	public Pessoa findById(Long id);
	
	public List<Pessoa> buscarPorCpf(Long cpf);
	
	public List<Pessoa> buscarPorNome(String nome);
	

}
