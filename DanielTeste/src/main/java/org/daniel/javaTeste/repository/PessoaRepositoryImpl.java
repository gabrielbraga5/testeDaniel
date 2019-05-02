package org.daniel.javaTeste.repository;

import java.util.List;

import org.daniel.javaTeste.model.Pessoa;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PessoaRepositoryImpl implements PessoaRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public Pessoa salvarPessoa(Pessoa pessoa) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(pessoa);
		return pessoa;		
		
	}

	@Override
	public void alterarPessoa(Pessoa pessoa) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(pessoa);	
	}

	@Override
	public void excluirPessoa(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Pessoa p = (Pessoa) session.load(Pessoa.class, new Long(id));
		if (null != p) {
			session.delete(p);
		}
		
	}

	@Override
	public List<Pessoa> buscarTodasPessoas() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Pessoa>  pessoaList = session.createQuery("from Pessoa").list();		
		return pessoaList;
		
	}

	@Override
	public Pessoa findById(Long id) {	
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Pessoa.class, id);
	}

	@Override
	public List<Pessoa> buscarPorCpf(Long cpf) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Pessoa p where p.cpf= :cpf");
		query.setParameter("cpf", cpf);
		List result = query.list();
		return result;
	}

	@Override
	public List<Pessoa> buscarPorNome(String nome) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Pessoa p where p.nome like :nome");
		query.setParameter("nome", "%"+nome+"%");
		List result = query.list();
		return result;
	}

}
