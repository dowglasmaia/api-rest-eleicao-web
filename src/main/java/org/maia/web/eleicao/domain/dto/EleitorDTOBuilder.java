package org.maia.web.eleicao.domain.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EleitorDTOBuilder implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "O campo Nome é requerido")
	private String nome;

	@NotNull(message = "O campo Data de Nascimento é requerido")
	@DateTimeFormat(iso = ISO.DATE, pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	@NotEmpty(message = "O campo CPF é requerido")
	private String cpf;

	private String tefeloneFixo;

	@NotEmpty(message = "Informe o número do Celular do Eleitor")
	private String tefeloneCelular;

	@NotEmpty(message = "O campo login é requerido")
	private String login;

	@NotEmpty(message = "O campo senha é requerido")
	private String senha;

	@NotEmpty(message = "O campo e-mail é requerido")
	private String email;

	private String aptoVotar;

	private String urlFoto;
}
