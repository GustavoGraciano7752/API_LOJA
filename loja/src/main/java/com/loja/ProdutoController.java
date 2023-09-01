package com.loja;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loja/produtos")
public class ProdutoController {
    private TabelaProdutos tabelaProdutos;

    public ProdutoController() {
        this.tabelaProdutos = new TabelaProdutos();
    }

    @GetMapping
    public List<Produto> buscarTodosProdutos() {
        return this.tabelaProdutos.buscarTodosProdutos();
    }

    @GetMapping("/{produtoId}")
    public Produto buscarProdutoIdLoja(@PathVariable int produtoId) {
        Produto produtoProcurado = this.tabelaProdutos.buscarProdutoId(produtoId);
        return produtoProcurado;
    }

    @PostMapping
    public Produto cadastrarNovoProduto(@RequestBody Produto dadosNovoProduto) {
        return this.tabelaProdutos.cadastrarNovoProduto(dadosNovoProduto);
    }

    @PutMapping("/{produtoId}")
    public void atualizarProdutoLoja(@PathVariable int produtoId, @RequestBody Produto dadosAtualizarProduto) {
        this.tabelaProdutos.atualizarProduto(produtoId,dadosAtualizarProduto);
    }

    @DeleteMapping("/{produtoId}")
    public void removerProdutoLoja(@PathVariable int  produtoId) {
        this.tabelaProdutos.removerProdutos(produtoId);
    }
}

