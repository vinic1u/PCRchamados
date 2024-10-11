package com.pedrochagas.pcrchamados.repositories;

import com.pedrochagas.pcrchamados.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
