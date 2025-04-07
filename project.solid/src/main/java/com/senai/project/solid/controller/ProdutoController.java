package com.senai.project.solid.controller;

import com.senai.project.solid.dto.ApiResponse;
import com.senai.project.solid.dto.ProdutoDTO;
import com.senai.project.solid.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * cntroller responsável por expor os endpoints REST relacionados a Produto.
 * Atua como ponte entre o cliente e a camada de serviço.
 */
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    // injeção de dependência via construtor
    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProdutoDTO>> salvar(@RequestBody @Valid ProdutoDTO dto) {
        ProdutoDTO produtoSalvo = service.salvar(dto);
        ApiResponse<ProdutoDTO> resposta = new ApiResponse<>(
                "Produto cadastrado com sucesso",
                null,
                produtoSalvo
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProdutoDTO>> atualizar(@PathVariable Long id, @RequestBody @Valid ProdutoDTO dto) {
        dto.setId(id);
        ProdutoDTO atualizado = service.salvar(dto);
        ApiResponse<ProdutoDTO> resposta = new ApiResponse<>(
                "Produto atualizado com sucesso",
                null,
                atualizado
        );
        return ResponseEntity.ok(resposta);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProdutoDTO>>> listarTodos() {
        List<ProdutoDTO> produtos = service.listarTodos();
        ApiResponse<List<ProdutoDTO>> resposta = new ApiResponse<>(
                "Produtos encontrados",
                produtos.size(),
                produtos
        );
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProdutoDTO>> buscarPorId(@PathVariable Long id) {
        ProdutoDTO produto = service.buscarPorId(id);
        ApiResponse<ProdutoDTO> resposta = new ApiResponse<>(
                "Produto encontrado",
                null,
                produto
        );
        return ResponseEntity.ok(resposta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletar(@PathVariable Long id) {
        service.deletar(id);
        ApiResponse<Void> resposta = new ApiResponse<>(
                "Produto deletado com sucesso",
                null,
                null
        );
        return ResponseEntity.ok(resposta);
    }
}
