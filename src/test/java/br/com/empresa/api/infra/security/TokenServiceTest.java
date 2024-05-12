package br.com.empresa.api.infra.security;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TokenServiceTest {

    @Value("${api.token.secret}")
    private String secret;

    @InjectMocks
    private TokenService tokenService;

    @Test
    void gerarToken() {
    }

    @Test
    public void testDataExpiracao() {
        // Cria uma instância da classe de serviço
        TokenService tokenService = new TokenService();

        // Chama o método que estamos testando
        Instant expiracao = tokenService.dataExpiracao();

        // Verifica se a expiração foi calculada corretamente
        Instant expectedExpiracao = LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
        assertEquals(expectedExpiracao, expiracao);
    }

    @Test
    void getSubject() {
    }


}