package com.pedrochagas.pcrchamados.repositories;

import com.pedrochagas.pcrchamados.entities.Observacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObservacaoRepository  extends JpaRepository<Observacao,Long> {
}
