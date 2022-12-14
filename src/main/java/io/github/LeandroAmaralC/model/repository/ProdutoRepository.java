package io.github.LeandroAmaralC.model.repository;

import io.github.LeandroAmaralC.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
