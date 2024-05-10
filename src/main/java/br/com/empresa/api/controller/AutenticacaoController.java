package br.com.empresa.api.controller;

import br.com.empresa.api.domain.usuario.Usuario;
import br.com.empresa.api.domain.usuario.UsuarioDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

//    @PostMapping
//    public ResponseEntity efetuarLogin(@RequestBody @Valid UsuarioDto dto){
//
//        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(dto.getLogin(),dto.getSenha());
//        var authentication = manager.authenticate(token);
//
//        return ResponseEntity.ok().build();
//    }

    @PostMapping
    public ResponseEntity<String> efetuarLogin(@RequestBody @Valid UsuarioDto dto){


            var authenticationToken = new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getSenha());
            var authentication = manager.authenticate(authenticationToken);

        return ResponseEntity.status(HttpStatus.OK).build();
}

}
