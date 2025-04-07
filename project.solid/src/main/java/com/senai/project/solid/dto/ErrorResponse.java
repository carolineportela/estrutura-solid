package com.senai.project.solid.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * classe de resposta padrão para erros da API.
 * Usada pelo GlobalExceptionHandler para retornar mensagens claras e formatadas.
 */

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private String mensagem;
    private List<String> erros;
}
