package org.maia.web.eleicao.domain.dto;

import org.maia.web.eleicao.domain.enums.TipoVoto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


public class VotoDTOBuilder  implements Serializable {

	private Set<CandidatoDTO> candidatos = new HashSet<>();
	private TipoVoto tipo;
	private LocalDateTime dataHora;
	private String cargo;

	public VotoDTOBuilder() {
		this.dataHora = LocalDateTime.now();
	}

	public VotoDTOBuilder(TipoVoto tipo, String cargo) {
		this.tipo = tipo;
		this.cargo = cargo;
		this.dataHora = LocalDateTime.now();
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

	public Set<CandidatoDTO> getCandidatos() {
		return candidatos;
	}

	@Override
	public String toString() {
		return "VotoDTOBuilder [candidatoDTOS=" + candidatos + ", tipo=" + tipo + ", dataHora=" + dataHora + ", cargo="
				+ cargo + "]";
	}
	

}
