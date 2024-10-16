package com.pedrochagas.pcrchamados.dtos.chamadoDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChamadoRequestDTO {

    private String titulo;
    private String observacoes;
    private Long usuarioId;

}
