package br.com.empresa.api.domain.usuario;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record RegistrarDto(

        @NotNull
       // @Pattern(regexp = "^[a-zA-Z]+$")
        @Pattern(regexp = "^[a-zA-Z ]+$", message = "Deve conter apenas letras e espaços")
        String login,
        @NotNull String senha,
        @NotNull Role role) {

}
