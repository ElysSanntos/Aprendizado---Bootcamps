package com.brq.ms01.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


/*
 * @ControllerAdvice permite manipular exceções de forma global.
 * Para cada tipo de exceção, podemos manipular desde o status
 * até a mensagem de retorno
 * */
@Slf4j
@ControllerAdvice
public class ResourceExceptionHandler {

	/* gostaria que o método abaixo trate exceções
	   do tipo de validação de dados*/
	/*ResponseEntity permite retornar o status, headers e o body da requisição para o cliente*/
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> methodValidationHandler(MethodArgumentNotValidException exception,
	                                                             HttpServletRequest request) {
		/*Esse padrão é o mesmo que instanciar uma classe com getters e setters
		*
		* StandardError standardError = new StandardError();
//        standardError.setStatus(400);
//        standardError.setPath("");
*
* */
		//@Builder
		StandardError standardError = StandardError
				                              .builder()
				                              .timestamp(new Date(System.currentTimeMillis() ))
				                              .status(HttpStatus.BAD_REQUEST.value())
				                              .error("Validation Error")
				                              .message(exception.getMessage())
				                              .path(request.getRequestURI())
				                              .build();

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);

	}
}
