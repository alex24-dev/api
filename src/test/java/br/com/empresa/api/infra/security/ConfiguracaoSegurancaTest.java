package br.com.empresa.api.infra.security;

import br.com.empresa.api.service.AutenticacaoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConfiguracaoSegurancaTest {

    @MockBean
    private AutenticacaoService autenticacaoService;

    @MockBean
    private SecurityFilter securityFilter;

    @Test
    void securityFilterChain() throws Exception {

    }

    @Test
    void authenticationManager() {


    }

    @Test
    void passwordEncoder() {

        ConfiguracaoSeguranca configuracaoSeguranca = new ConfiguracaoSeguranca();

        PasswordEncoder passwordEncoder = configuracaoSeguranca.passwordEncoder();

        assertNotNull(passwordEncoder);
    }
}