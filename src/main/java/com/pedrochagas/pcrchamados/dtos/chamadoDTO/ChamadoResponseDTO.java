package com.pedrochagas.pcrchamados.dtos.chamadoDTO;

import com.pedrochagas.pcrchamados.dtos.observacaoDTO.ObservacaoResponseDTO;
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
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChamadoResponseDTO {

    private Long id;
    private String titulo;
    private List<ObservacaoResponseDTO> observacoes;
    private LocalDateTime abertoEm;
    private ChamadoStatus status;
    private OperadorResponseDTO operador;
    private UsuarioResponseDTO usuario;

    public ChamadoResponseDTO(Chamado entity){
        this.id = entity.getId();
        this.titulo = entity.getTitulo();
        this.abertoEm = entity.getAbertoEm();
        this.status = entity.getStatus();
        this.usuario = new UsuarioResponseDTO(entity.getUsuario());
        this.observacoes = entity.getObservacoes().stream().map(ObservacaoResponseDTO::new).toList();
    }
}
