package io.github.LeandroAmaralC.model.repository;

import io.github.LeandroAmaralC.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer > {
}
