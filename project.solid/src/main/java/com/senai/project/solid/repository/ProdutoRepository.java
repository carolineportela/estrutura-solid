package com.senai.project.solid.repository;

import com.senai.project.solid.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * interface responsável por acessar a base de dados da entidade Produto.
 * estende JpaRepository para obter métodos prontos de CRUD.
 */

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // List<Produto> findByNomeContaining(String nome);
}
