package br.com.banco.controller.exception;

import br.com.banco.service.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError>resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error="Conta não encontrada";
        HttpStatus status= HttpStatus.NOT_FOUND;
        StandardError err=new StandardError(Instant.now(), status.value(), error,e.getMessage(), request.getRequestURI() );
        return ResponseEntity.status(status).body(err);
    }
}
