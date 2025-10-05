package com.api.unipar.service;

import com.api.unipar.entidades.Cliente;
import com.api.unipar.entidades.Produto;
import com.api.unipar.repository.ProdutoRepository;
import com.api.unipar.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarTodosProdutos() {
        return produtoRepository.findAll();
    }

    public Produto salvarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto buscarProdutoPorID(Long id){
        return produtoRepository.findById(id).orElseThrow(()->new RuntimeException("Produto de id" + id + "não emcontrado"));
    }

    public void deletarProdutoPorId(Long id){
        produtoRepository.deleteById(id);
    }

    public Produto updateProduto(Long id, Produto Produto){
        Produto ProdutoSalvo = buscarProdutoPorID(id);

        BeanUtils.copyProperties(Produto, ProdutoSalvo,"id");
        return produtoRepository.save(ProdutoSalvo);

    }


}
