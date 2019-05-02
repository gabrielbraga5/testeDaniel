package org.daniel.javaTeste.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pessoa")
public class Pessoa {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@Column(name="cpf")
	Long cpf;
	
	@Column(name="nome")
	String nome;
	
	@Column(name="email")
	String email; 
	
	@Column(name="dtNascimento")
	Timestamp dtNascimento; 
	 
	@Column(name="sexo")
	String sexo;
	
	@Column(name="estadoCivil")
	String estadoCivil;
	
	@Column(name="ativo")
	Boolean ativo;
	
	public Pessoa() {
		super();		
	}
	
	public Pessoa(Long id, Long cpf, String nome, String email, Timestamp dtNascimento, String sexo, String estadoCivil,
			Boolean ativo) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.dtNascimento = dtNascimento;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.ativo = ativo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Timestamp dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", dtNascimento="
				+ dtNascimento + ", sexo=" + sexo + ", estadoCivil=" + estadoCivil + ", ativo=" + ativo + "]";
	}	

	


}
