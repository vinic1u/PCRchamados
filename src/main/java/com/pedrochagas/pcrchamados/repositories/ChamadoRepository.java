package com.pedrochagas.pcrchamados.repositories;

import com.pedrochagas.pcrchamados.entities.Chamado;
import com.pedrochagas.pcrchamados.enums.ChamadoStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChamadoRepository extends JpaRepository<Chamado,Long> {

    @Modifying
    @Query(nativeQuery = true,
    value = "UPDATE tb_chamado " +
            "SET status = :status " +
            "WHERE id = :id "
    )
    void atualizarStatus(@Param(value = "id") Long id,
                         @Param(value = "status") String status);

    @Query(nativeQuery = true,
    value = "SELECT c.* " +
            "FROM tb_chamado c " +
            "INNER JOIN tb_usuario u ON c.id_usuario = u.id " +
            "WHERE UPPER(u.nome) LIKE UPPER(CONCAT('%',:usuarioNome,'%'))"
    )
    Page<Chamado> buscarChamadosPorUsuario(@Param(value="usuarioNome") String usuarioNome,Pageable pageable);
}
