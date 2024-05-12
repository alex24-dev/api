package br.com.empresa.api.service;

import br.com.empresa.api.domain.produto.ProdutoDto;
import br.com.empresa.api.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;

class ProdutoServiceTest {


    @InjectMocks
    private ProdutoService produtoService;

    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    private ModelMapper modelMapper;

    @Test
    void criarProduto() {

        ProdutoDto produtoDto = new ProdutoDto();


    }

    @Test
    void consultar() {


    }
}