package edu.ifrn.tsi.sgpt.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratarExceptions {

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<Object> tratarErro404ParaEntidadesInexistentes(EntityNotFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource not found.");
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Object> tratarErro400(MethodArgumentNotValidException ex) {
    var erros = ex.getFieldErrors();
    return ResponseEntity.badRequest().body(erros.stream().map(ErroAtributo::new));
  }

  public record ErroAtributo(String campo, String mensagem) {
    public ErroAtributo(FieldError erro) {
      this(erro.getField(), erro.getDefaultMessage());
    }
  }

}
