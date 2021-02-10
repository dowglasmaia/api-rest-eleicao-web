package org.maia.web.eleicao.domain.abstrac;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class Pessoa extends GenericDomain  {

	@Column(length = 100, nullable = true)
	private String nome;

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
