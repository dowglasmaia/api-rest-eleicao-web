package org.maia.web.eleicao.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.Valid;

import org.maia.web.eleicao.domain.abstrac.GenericDomain;
import org.maia.web.eleicao.domain.enums.TipoVoto;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Voto extends GenericDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDateTime dataHora;

	@Column(length = 100, nullable = true)
	private String cargo;

	@Enumerated(EnumType.STRING)
	private TipoVoto tipo;

	@Valid
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "voto_candidatos", 
	   joinColumns = @JoinColumn(name = "voto_id"),  			
	   inverseJoinColumns = @JoinColumn(name = "candidato_id")) 	
	private Set<Candidato> candidatos = new HashSet<>();

	public Voto() {

	}

	public Voto(TipoVoto tipo, String cargo) {
		this.tipo = tipo;
		this.cargo = cargo;

	}

	public TipoVoto getTipo() {
		return tipo;
	}

	public void setTipo(TipoVoto tipo) {
		this.tipo = tipo;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Set<Candidato> getCandidatos() {
		return candidatos;
	}

	@Override
	public String toString() {
		return "VotoDTOBuilder [candidatos=" + candidatos + ", tipo=" + tipo + ", dataHora=" + dataHora + ", cargo="
				+ cargo + "]";
	}

}
