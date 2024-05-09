package br.com.empresa.api.controller;

import br.com.empresa.api.domain.ProdutoDto;
import br.com.empresa.api.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    @Transactional
    public ResponseEntity<ProdutoDto> cadastrar(@RequestBody @Valid ProdutoDto dto, UriComponentsBuilder uri){

        ProdutoDto produtoDto = service.criarProduto(dto);
        URI endereco = uri.path("/produtos").buildAndExpand().toUri();
        return ResponseEntity.created(endereco).body(produtoDto);
    }

    @GetMapping
    public Page<ProdutoDto> listar(@PageableDefault(size = 10 )Pageable paginacao){


        return service.consultar(paginacao);
    }

}
