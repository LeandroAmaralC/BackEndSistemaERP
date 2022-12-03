package io.github.LeandroAmaralC.model.repository;

import io.github.LeandroAmaralC.model.entity.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produtos, Integer> {
}
