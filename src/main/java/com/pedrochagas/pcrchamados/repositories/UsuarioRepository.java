package com.pedrochagas.pcrchamados.repositories;

import com.pedrochagas.pcrchamados.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
