package org.maia.web.eleicao.execptions;

public class OperationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public OperationException() {
		super();

	}

	public OperationException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
