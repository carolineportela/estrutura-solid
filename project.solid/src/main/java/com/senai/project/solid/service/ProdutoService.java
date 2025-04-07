package com.senai.project.solid.service;

import com.senai.project.solid.entity.Produto;
import com.senai.project.solid.dto.ProdutoDTO;
import com.senai.project.solid.mapper.ProdutoMapper;
import com.senai.project.solid.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * classe responsável por conter a lógica de negócio relacionada à entidade Produto.
 * aplica as regras de negócio e faz a ponte entre controller e repository.
 */

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    // injeção de dependência via construtor
    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<ProdutoDTO> listarTodos() {
        return repository.findAll().stream()
                .map(ProdutoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProdutoDTO salvar(ProdutoDTO dto) {
        Produto produto = ProdutoMapper.toEntity(dto);
        Produto salvo = repository.save(produto);
        return ProdutoMapper.toDTO(salvo);
    }

    public ProdutoDTO buscarPorId(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return ProdutoMapper.toDTO(produto);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado");
        }
        repository.deleteById(id);
    }
}
