package br.com.empresa.api.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {

    @NotBlank
    private String login;
    @NotBlank
    private String senha;
}
