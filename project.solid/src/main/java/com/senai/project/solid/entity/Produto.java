package com.senai.project.solid.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidade responsavel pra mapear a tabela do Banco de Dados
  **/

@Entity
@Getter
@Setter
@Table(name = "tbl_produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private Double preco;

}
