package com.pedrochagas.pcrchamados.dtos.chamadoDTO;

import com.pedrochagas.pcrchamados.dtos.usuarioDTO.UsuarioResponseDTO;
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
}
