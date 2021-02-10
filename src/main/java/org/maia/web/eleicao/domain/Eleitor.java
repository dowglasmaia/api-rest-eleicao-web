package org.maia.web.eleicao.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.maia.web.eleicao.domain.abstrac.GenericDomain;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Eleitor extends GenericDomain{
	private static final long serialVersionUID = 1L;


	@Column(length = 100, nullable = true)
	private String nome;


	@DateTimeFormat(iso = ISO.DATE, pattern ="dd/MM/yyyy" )
	private LocalDate dataNascimento;

	@Column(length = 20, unique = true, nullable = true)
	private String cpf;

	@Column(length = 20)
	private String tefeloneFixo;

	@Column(length = 20)
	private String tefeloneCelular;

	@Column(unique = true, nullable = true)
	private String login;

	@Column(nullable = true)
	private String senha;

	@Column(length = 100, unique = true)
	private String email;

	@Column(length = 5, nullable = true)
	private String aptoVotar;

	@Column(unique = true, nullable = false)
	private String urlFoto;

}
