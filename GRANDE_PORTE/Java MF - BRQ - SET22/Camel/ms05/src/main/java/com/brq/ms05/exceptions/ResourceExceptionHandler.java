package com.brq.ms05.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;
import java.util.Date;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<StandardError> validationErrorHandler(
            ValidationException exception,
            HttpServletRequest request){

        StandardError standardError = new StandardError();

        standardError.setTimestamp(new Date());
        standardError.setError("Erro de validação");
        standardError.setMessage("Erro ao validadar a entidade");
        standardError.setPath(request.getRequestURI());
        standardError.setStatus(HttpStatus.CONFLICT.value());

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(standardError);
    }

    @ExceptionHandler(NaoAcheiException.class)
    public ResponseEntity<StandardError> naoAcheiExceptionHandler(
            NaoAcheiException exception,
            HttpServletRequest request
    ){
        StandardError standardError = new StandardError();
        standardError.setTimestamp(new Date());
        standardError.setError("Dado não encontrado");
        standardError.setMessage(exception.getMessage());
        standardError.setPath(request.getRequestURI());
        standardError.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(standardError);
    }
}