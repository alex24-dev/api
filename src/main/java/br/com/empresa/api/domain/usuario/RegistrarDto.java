package br.com.empresa.api.domain.usuario;

import jakarta.validation.constraints.NotNull;

public record RegistrarDto(

        @NotNull String login,
        @NotNull String senha,
        @NotNull String role) {

}
