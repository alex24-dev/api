package br.com.empresa.api.domain.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProdutoDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotNull
    @Positive
    private Integer valor;
}
