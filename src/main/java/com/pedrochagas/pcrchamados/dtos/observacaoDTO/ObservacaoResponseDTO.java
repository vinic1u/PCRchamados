package com.pedrochagas.pcrchamados.dtos.observacaoDTO;

import com.pedrochagas.pcrchamados.entities.Observacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObservacaoResponseDTO {

    private Long id;
    private String mensagem;

    public ObservacaoResponseDTO(Observacao entity){
        this.id = entity.getId();
        this.mensagem = entity.getMensagem();
    }
}
