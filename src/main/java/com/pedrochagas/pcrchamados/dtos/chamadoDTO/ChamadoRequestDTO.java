package com.pedrochagas.pcrchamados.dtos.chamadoDTO;

import com.pedrochagas.pcrchamados.dtos.observacaoDTO.ObservacaoRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChamadoRequestDTO {

    private String titulo;
    private List<ObservacaoRequestDTO> observacoes;
    private Long usuarioId;


}
