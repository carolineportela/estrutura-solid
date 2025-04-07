package com.senai.project.solid.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * classe de resposta padrão para as APIs.
 */

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "mensagem", "quantidade", "data" })
public class ApiResponse<Dado> {

    private String mensagem;
    private Integer quantidade;
    private Dado data;
}

