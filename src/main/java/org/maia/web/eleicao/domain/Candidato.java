package org.maia.web.eleicao.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.maia.web.eleicao.domain.abstrac.GenericDomain;

@Entity
public class Candidato extends GenericDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 100, nullable = true)
	private String nome;

	@Column(length = 12, nullable = true)
	private String cpf;

	@Column(length = 100, nullable = true)
	private String email;


	public Candidato() {

	}

	public Candidato(String nome, String cpf, String email) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



}
