package io.github.LeandroAmaralC.model.repository;

import io.github.LeandroAmaralC.model.entity.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Integer> {
}
