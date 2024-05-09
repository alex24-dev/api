package br.com.empresa.api.service;

import br.com.empresa.api.domain.Produto;
import br.com.empresa.api.domain.ProdutoDto;
import br.com.empresa.api.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public ProdutoDto criarProduto(ProdutoDto dto){

        Produto produto = modelMapper.map(dto,Produto.class);
        repository.save(produto);
        return modelMapper.map(produto,ProdutoDto.class);
    }
}
