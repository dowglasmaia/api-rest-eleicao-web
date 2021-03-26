package org.maia.web.eleicao.domain.dto;

import java.time.LocalDate;

import org.maia.web.eleicao.domain.abstrac.GenericDomain;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class EleitorDTO extends GenericDomain {
	private static final long serialVersionUID = 1L;

	private String nome;

	@DateTimeFormat(iso = ISO.DATE, pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	private String cpf;

	private String tefeloneCelular;
	
	private String email;

	private Boolean isAptoVotar;

	private String pathFoto;

}
