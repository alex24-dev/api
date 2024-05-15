package br.com.empresa.api.service;

import br.com.empresa.api.domain.usuario.RegistrarDto;
import br.com.empresa.api.domain.usuario.Role;
import br.com.empresa.api.domain.usuario.Usuario;
import br.com.empresa.api.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AutenticacaoServiceTest {
    @InjectMocks
    private AutenticacaoService autenticacaoService;

    @Mock
    private UsuarioRepository repository;

    @Mock
    private Usuario usuario;
    @Mock
    private RegistrarDto dto;

    @Mock
    private Role role;

    @Test
    void loadUserByUsername() {

        autenticacaoService.loadUserByUsername(usuario.getUsername());

    }

    @Test
    void register() {

        //autenticacaoService.register(dto);

        RegistrarDto dto = new RegistrarDto("newUser", "senha",role );
        when(repository.findByLogin(dto.login())).thenReturn(null);

        // Chama o método da classe de serviço
        ResponseEntity<String> response = autenticacaoService.register(dto);

        // Verifica se a resposta é um ResponseEntity.ok()
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(repository, times(1)).save(any());

    }

}