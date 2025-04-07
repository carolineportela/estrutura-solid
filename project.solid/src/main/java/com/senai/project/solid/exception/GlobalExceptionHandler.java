package com.senai.project.solid.exception;

import com.senai.project.solid.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // erros de validação (@Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidacao(MethodArgumentNotValidException ex) {
        List<String> erros = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .collect(Collectors.toList());

        ErrorResponse resposta = new ErrorResponse(
                "Erro de validação nos campos",
                erros
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
    }

    // erros de formato no JSON (ex: preco: "abc")
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleFormatoInvalido(HttpMessageNotReadableException ex) {
        ErrorResponse resposta = new ErrorResponse(
                "Formato inválido na requisição. Verifique os tipos dos campos (ex: número, data).",
                null
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
    }

    // erro genérico (fallback)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleErroGeral(Exception ex) {
        ErrorResponse resposta = new ErrorResponse(
                "Erro interno inesperado",
                List.of(ex.getMessage())
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resposta);
    }
}
