package org.maia.web.eleicao.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.maia.web.eleicao.domain.abstrac.Pessoa;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
public class PessoaFisica extends Pessoa{
	

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	@Column(length = 20, unique = true, nullable = true)
	private String cpf;

}
