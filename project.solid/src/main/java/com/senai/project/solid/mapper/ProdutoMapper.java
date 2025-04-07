package com.senai.project.solid.mapper;

import com.senai.project.solid.dto.ProdutoDTO;
import com.senai.project.solid.entity.Produto;

/**
 * classe utilitária responsável por converter entre Produto e ProdutoDTO
 */

/**
 * construtor privado para impedir a criação de instâncias desta classe.
 *
 * como esta é uma classe utilitária que contém apenas métodos estáticos
 * para conversão entre entidades e DTOs, não faz sentido instanciá-la.
 *
 * declarar o construtor como private garante que nenhum outro código
 * (interno ou externo ao projeto) poderá criar objetos do tipo ProdutoMapper.
 */

public class ProdutoMapper {

    private ProdutoMapper() {

    }

    public static ProdutoDTO toDTO(Produto produto) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setPreco(produto.getPreco());
        return dto;
    }

    public static Produto toEntity(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setId(dto.getId());
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        return produto;
    }
}
