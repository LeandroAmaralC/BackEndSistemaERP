package io.github.LeandroAmaralC.clientes.model.repository;

import io.github.LeandroAmaralC.clientes.model.enity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario , Integer> {
}
