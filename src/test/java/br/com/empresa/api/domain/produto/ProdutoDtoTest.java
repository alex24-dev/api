package br.com.empresa.api.domain.produto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoDtoTest {

    @Test
    @DisplayName("Testando os valores da classe ProdutoDto")
    void teste() {
        ProdutoDto dto = new ProdutoDto();
        dto.setNome("teste");
        dto.setValor(10);
        dto.setDescricao("teste");

        dto.getNome();
        dto.getValor();
        dto.getDescricao();

    }


}