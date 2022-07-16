package io.github.LeandroAmaralC.clientes.model.repository;

import io.github.LeandroAmaralC.clientes.model.enity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer > {
}
