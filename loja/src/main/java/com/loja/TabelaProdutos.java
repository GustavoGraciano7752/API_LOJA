package com.loja;

import java.util.ArrayList;
import java.util.List;

public class TabelaProdutos {
    List<Produto> produtos = new ArrayList<>();

    //No construtor a lista de produtos será preenchida
    public TabelaProdutos() {
        Produto caneta = new Produto(1, "Caneta BIC", "Caneta azul", 1.99);
        Produto borracha = new Produto(2, "Borracha", "Borracha branca", 3.99);
        Produto lapis = new Produto(3, "Lápis", "Faber Castel", 2.99);
        Produto apontador = new Produto(4, "Apontador", "Faber Castel", 7.99);
        Produto caderno = new Produto(5, "Caderno", "Caderno 10 matérias", 15.99);
        Produto controle = new Produto(6, "Controle", "Controle universal", 69.99);
        Produto pasta = new Produto(7, "Pasta", "Pasta rosa", 9.99);
        Produto papel = new Produto(8, "Papel", "Papel sulfite 500 folhas", 29.99);
        Produto lapizeira = new Produto(9, "Lapizeira", "Lapizeira com grafite 0.7", 7.99);
        Produto corretivo = new Produto(10, "Corretivo", "Corretivo", 4.99);

        this.produtos.add(caneta);
        this.produtos.add(borracha);
        this.produtos.add(lapis);
        this.produtos.add(apontador);
        this.produtos.add(caderno);
        this.produtos.add(controle);
        this.produtos.add(pasta);
        this.produtos.add(papel);
        this.produtos.add(lapizeira);
        this.produtos.add(corretivo);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    //Método que retorna todos os produtos da lista

    public List<Produto> buscarTodosProdutos() {
        return this.getProdutos();
    }

    //Método de busca d eum produto pelo seu Id, retorna null se não encontrar o produto
    public Produto buscarProdutoId(int produtoId) {
        Produto produtoProcurado = null;
        for (Produto p : this.produtos) {
            if (p.getId() == produtoId) {
                produtoProcurado = p;
                break;
            }
        }
        return produtoProcurado;
    }
}
