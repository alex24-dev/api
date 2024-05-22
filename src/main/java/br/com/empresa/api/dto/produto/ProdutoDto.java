package br.com.empresa.api.dto.produto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("preço")
    private Integer valor;
}
