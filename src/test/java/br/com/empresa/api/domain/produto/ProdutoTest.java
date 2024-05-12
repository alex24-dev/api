package br.com.empresa.api.domain.produto;

import org.junit.jupiter.api.Test;



class ProdutoTest {


    @Test
    void criarProduto() {
        Produto produto = new Produto();


        produto.setNome("");
        produto.setValor(1);
        produto.setDescricao("teste");

        produto.getId();
        produto.getNome();
        produto.getValor();
        produto.getDescricao();
    }

}