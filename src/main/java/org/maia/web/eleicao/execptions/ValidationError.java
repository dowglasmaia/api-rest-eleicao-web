package org.maia.web.eleicao.execptions;

import java.util.ArrayList;
import java.util.List;


public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> erros = new ArrayList<>();

	public ValidationError(Long timestamp, Integer status, String error, String message,  String path) {
		super(timestamp, status, error, message, null, path);
	}

	public List<FieldMessage> getErros() {
		return erros;
	}

	public void addError(String fieldName, String msg) {
		erros.add(new FieldMessage(fieldName, msg));
	}

}
