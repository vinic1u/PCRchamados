package com.pedrochagas.pcrchamados.repositories;

import com.pedrochagas.pcrchamados.entities.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado,Long> {
}
