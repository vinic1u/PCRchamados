package com.pedrochagas.pcrchamados.dtos.chamadoDTO;

import com.pedrochagas.pcrchamados.dtos.operadorDTO.OperadorResponseDTO;
import com.pedrochagas.pcrchamados.dtos.usuarioDTO.UsuarioResponseDTO;
import com.pedrochagas.pcrchamados.entities.Chamado;
import com.pedrochagas.pcrchamados.entities.Operador;
import com.pedrochagas.pcrchamados.entities.Usuario;
import com.pedrochagas.pcrchamados.enums.ChamadoStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChamadoResponseDTO {

    private Long id;
    private String titulo;
    private String observacoes;
    private LocalDateTime abertoEm;
    private ChamadoStatus status;
    private OperadorResponseDTO operador;
    private UsuarioResponseDTO usuario;

    public ChamadoResponseDTO(Chamado entity){
        this.id = entity.getId();
        this.titulo = entity.getTitulo();
        this.observacoes = entity.getObservacoes();
        this.abertoEm = entity.getAbertoEm();
        this.status = entity.getStatus();
        this.operador = new OperadorResponseDTO(entity.getOperador());
        this.usuario = new UsuarioResponseDTO(entity.getUsuario());
    }
}
