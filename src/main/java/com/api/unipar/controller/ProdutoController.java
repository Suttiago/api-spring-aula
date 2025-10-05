package com.api.unipar.controller;

import com.api.unipar.entidades.Produto;
import com.api.unipar.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/listar")
    public List<Produto> listarTodosProdutos() {
        return produtoService.listarTodosProdutos();
    }

    @PostMapping("/salvar")
    public Produto salvarProduto(@RequestBody Produto produto){
        return produtoService.salvarProduto((produto));
    }

    @GetMapping("/buscar-Produto/{id}")
    public Produto buscarProdutoPorId( @PathVariable Long id){
        return produtoService.buscarProdutoPorID(id);
    }

    @DeleteMapping("/deletar-Produto/{id}")
    public void deletarProdutoPorid(@PathVariable Long id){
        produtoService.deletarProdutoPorId(id);
    }

    @PutMapping("/atualizar-Produto/{id}")
    public Produto atualizarProdutoId(@PathVariable Long id, @RequestBody Produto produto){
        return produtoService.updateProduto(id,produto);
    }
}
