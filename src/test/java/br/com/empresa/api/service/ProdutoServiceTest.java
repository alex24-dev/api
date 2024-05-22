package br.com.empresa.api.service;

import br.com.empresa.api.domain.produto.Produto;
import br.com.empresa.api.dto.produto.ProdutoDto;
import br.com.empresa.api.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {


    @InjectMocks
    private ProdutoService produtoService;

    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    private ModelMapper modelMapper;

    @Test
    void criarProduto() {

        // Mock dos dados de entrada
        ProdutoDto produtoDto = new ProdutoDto();
        Produto produto = new Produto();
        when(modelMapper.map(produtoDto, Produto.class)).thenReturn(produto);
        when(modelMapper.map(produto, ProdutoDto.class)).thenReturn(produtoDto);
        when(produtoRepository.save(produto)).thenReturn(produto);

        // Chama o método da classe de serviço
        ProdutoDto resultado = produtoService.criarProduto(produtoDto);

        // Verifica se o método save foi chamado no repositório
        verify(produtoRepository, times(1)).save(produto);

        // Verifica se o resultado retornado é o esperado
        assertEquals(produtoDto, resultado);

    }

    @Test
    void consultar() {

        Pageable paginacao = PageRequest.of(0, 10);
        Page<Produto> produtos = new PageImpl<>(Arrays.asList(new Produto(), new Produto()));
        when(produtoRepository.findAll(paginacao)).thenReturn(produtos);

        // Chama o método da classe de serviço
        Page<ProdutoDto> resultado = produtoService.consultar(paginacao);

        // Verifica se o método findAll foi chamado no repositório
        verify(produtoRepository, times(1)).findAll(paginacao);

        // Verifica se o resultado retornado não é nulo e tem o mesmo tamanho que a lista de produtos
        assertNotNull(resultado);
        assertEquals(produtos.getSize(), resultado.getSize());
    }

    }
