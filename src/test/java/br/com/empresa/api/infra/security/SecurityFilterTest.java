package br.com.empresa.api.infra.security;

import br.com.empresa.api.domain.usuario.Usuario;
import br.com.empresa.api.repository.UsuarioRepository;
import br.com.empresa.api.service.AutenticacaoService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SecurityFilterTest {

    @InjectMocks
    private SecurityFilter securityFilter;

    @MockBean
    private TokenService tokenService;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @Test
    void doFilterInternal() throws ServletException, IOException {
        // Mock dos dados de entrada
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        FilterChain filterChain = mock(FilterChain.class);
        UsernamePasswordAuthenticationToken authenticationToken = mock(UsernamePasswordAuthenticationToken.class);

        // Chama o método que estamos testando
        securityFilter.doFilterInternal(request, response, filterChain);

    }

    @Test
    public void testRecuperarToken_WithoutAuthorizationHeader() {
        // Mock dos dados de entrada
        HttpServletRequest request = mock(HttpServletRequest.class);

        // Cria uma instância do filtro


        // Chama o método que estamos testando
        String token = securityFilter.recuperarToken(request);

        // Verifica se o token é nulo quando não há cabeçalho de autorização
        assertNull(token);
    }
}