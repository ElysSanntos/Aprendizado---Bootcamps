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
@Slf4j /*Vai ser explicado na proxima aula*/
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
//		StandardError standardError = StandardError
//				                              .builder()
//				                              .timestamp(new Date(System.currentTimeMillis() ))
//				                              .status(HttpStatus.BAD_REQUEST.value())
//				                              .error("Validation Error")
//				                              .message(exception.getMessage())
//				                              .path(request.getRequestURI())
//				                              .build();

		ValidationError validationError = new ValidationError();

		validationError.setTimestamp(new Date(System.currentTimeMillis()));
		validationError.setStatus(HttpStatus.BAD_REQUEST.value());
		validationError.setError("Validation Error");
		//validationError.setMessage(exception.getMessage());
		validationError.setMessage("Erro ao validar os campos!");
		validationError.setPath(request.getRequestURI());

		/* Uma lista de todos os erros vindos da exceção*/
		List<FieldError> listErrors = exception.getBindingResult().getFieldErrors();

		/*para cada erro da exceção*/
		for (FieldError baldeError : listErrors) {

			/*crio m obj FieldMessage com o nome do campo e o erro retornado do mesmo*/
			FieldMessage fieldMessage = new FieldMessage();
			fieldMessage.setField(baldeError.getField());
			fieldMessage.setMessage(baldeError.getDefaultMessage());

			/*adiciono o campo e seu respectivo erro no atributo ERRORS do retorno*/
			validationError.getErrors().add(fieldMessage);
		}

		log.info(exception.getMessage());
		log.info("Fabrizio é legal");
		log.error("");

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationError);

	}
}
