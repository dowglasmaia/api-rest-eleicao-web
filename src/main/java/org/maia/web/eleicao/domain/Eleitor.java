package org.maia.web.eleicao.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.maia.web.eleicao.domain.abstrac.GenericDomain;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Eleitor extends GenericDomain {
	private static final long serialVersionUID = 1L;

	@Column(length = 100, nullable = true)
	private String nome;

	@DateTimeFormat(iso = ISO.DATE, pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	@Column(length = 13, unique = true, nullable = true)
	private String cpf;

	@Column(length = 20)
	private String tefeloneCelular;

	@Column(length = 100, unique = true)
	private String email;

	@Column(nullable = true)
	private Boolean isAptoVotar;

	@Column(unique = true, nullable = false)
	private String pathFoto;

	public Eleitor() {

	}

	public Eleitor(String nome, LocalDate dataNascimento, String cpf, String tefeloneCelular, String email,
			Boolean isAptoVotar, String pathFoto) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.tefeloneCelular = tefeloneCelular;
		this.email = email;
		this.isAptoVotar = isAptoVotar;
		this.pathFoto = pathFoto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTefeloneCelular() {
		return tefeloneCelular;
	}

	public void setTefeloneCelular(String tefeloneCelular) {
		this.tefeloneCelular = tefeloneCelular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsAptoVotar() {
		return isAptoVotar;
	}

	public void setIsAptoVotar(Boolean isAptoVotar) {
		this.isAptoVotar = isAptoVotar;
	}

	public String getPathFoto() {
		return pathFoto;
	}

	public void setPathFoto(String pathFoto) {
		this.pathFoto = pathFoto;
	}

}
