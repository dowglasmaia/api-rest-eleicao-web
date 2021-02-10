package org.maia.web.eleicao.domain;

import javax.persistence.Entity;

import org.maia.web.eleicao.domain.abstrac.Pessoa;

import lombok.Data;


@Data
@Entity
public class Eleitor extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	

}
