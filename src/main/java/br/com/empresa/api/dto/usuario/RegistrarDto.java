package br.com.empresa.api.dto.usuario;

import br.com.empresa.api.domain.usuario.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record RegistrarDto(

        @NotNull
        // @Pattern(regexp = "^[a-zA-Z]+$")
        @Pattern(regexp = "^[a-zA-Z ]+$", message = "Deve conter apenas letras e espaços")
        @JsonProperty("Name")
        String login,

        @NotNull
        @JsonProperty("Seed")
        String senha,
        @NotNull
        @JsonProperty("Role")
        Role role) {

}
