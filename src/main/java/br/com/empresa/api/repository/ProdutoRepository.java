package br.com.empresa.api.repository;

import br.com.empresa.api.domain.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository  extends JpaRepository<Produto,Long> {
}
