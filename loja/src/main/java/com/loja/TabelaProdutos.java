package com.loja;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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


    /**
     * Método wue cadastra um novo produto
     * Primeiro busca o ultimo item
     * Depois incrementa o Id
     * Atribui novo Id
     * @param novoProduto
     * @return
     */
    public Produto cadastrarNovoProduto(Produto novoProduto) {
        //Lista com 6 itens vai de 0 a 5, vai pegar o número de itens -1 = 5
        int ultimoIndex = this.produtos.size() - 1;
        Produto ultimoProduto = this.produtos.get(ultimoIndex);
        int proximoId = ultimoProduto.getId() + 1;
        novoProduto.setId(proximoId);
        this.produtos.add(novoProduto);
        return novoProduto;
    }

    /**
     * Método que atualiz um produto
     * Primeiro busca o produto a atualizar pelo Id
     * Depois atribui as novas infos
     * E salva o produto atualizado
     * @param produtoId
     * @param produtoAtualizar
     */
    public void atualizarProduto(int produtoId, Produto produtoAtualizar) {
        Produto produtoProcurado = this.buscarProdutoId(produtoId);
        if (produtoProcurado != null){
            produtoProcurado.setNome(produtoAtualizar.getNome());
            produtoProcurado.setDescricao(produtoAtualizar.getDescricao());
            produtoProcurado.setValorUnitario(produtoAtualizar.getValorUnitario());
        }
    }

    public void removerProdutos(int produtoId) {
        Produto produtoRemover = this.buscarProdutoId(produtoId);
        this.produtos.remove(produtoRemover);
    }


}
