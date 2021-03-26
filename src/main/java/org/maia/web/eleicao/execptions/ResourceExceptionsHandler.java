package org.maia.web.eleicao.execptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionsHandler {

	@ExceptionHandler(OperationException.class)
	public ResponseEntity<StandardError> runtimeExceptionError(	OperationException e,	HttpServletRequest request) {
				
			StandardError error = StandardError.builder()
					.timestamp(System.currentTimeMillis())
					.status(HttpStatus.BAD_REQUEST.value())
					.error("Error Interno")
					.message(e.getMessage())
					.cause(e.getCause())
					.path(request.getRequestURI())
					.build();
			
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(error);
	}

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> notFoundExceptionError(ObjectNotFoundException e, HttpServletRequest request) {
		
			StandardError error = StandardError.builder()
					.timestamp(System.currentTimeMillis())
					.status(HttpStatus.NOT_FOUND.value())
					.error("Recurso não encotrado")
					.message(e.getMessage())
					.path(request.getRequestURI())
					.build();
		
	return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
		ValidationError err = new ValidationError(
				System.currentTimeMillis(), 
				HttpStatus.UNPROCESSABLE_ENTITY.value(),
				"Error de Validação de dados", 
				"Reveja o(s) Campo(s) com erro(s).",
				request.getRequestURI());
				
		
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			err.addError(x.getField(), x.getDefaultMessage());
		}

		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
	}

}
