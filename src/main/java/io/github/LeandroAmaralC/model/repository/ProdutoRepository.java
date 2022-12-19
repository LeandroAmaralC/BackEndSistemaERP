package io.github.LeandroAmaralC.model.repository;

import io.github.LeandroAmaralC.model.entity.Cliente;
import io.github.LeandroAmaralC.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

//    Optional<Produto> findbyProduto(String produto);
}
