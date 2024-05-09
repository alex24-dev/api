package br.com.empresa.api.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProdutoDto {

    private String nome;
    private String descricao;

    private Integer valor;
}
