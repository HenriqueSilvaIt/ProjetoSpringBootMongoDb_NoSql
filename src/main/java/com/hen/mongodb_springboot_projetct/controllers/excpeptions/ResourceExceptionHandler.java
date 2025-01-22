package com.hen.mongodb_springboot_projetct.controllers.excpeptions;

import com.hen.mongodb_springboot_projetct.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // signnifica que essa classe trata possíveis erros nas requisições
// http
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class) // identifica que quando ocorrer a exceção personalizada not found exception ele faz esse
    // método abaixo
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND; // Exceção não encontrada
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());

        return  ResponseEntity.status(status).body(err); // retorna status e
        // mensagem de err
    }

}
