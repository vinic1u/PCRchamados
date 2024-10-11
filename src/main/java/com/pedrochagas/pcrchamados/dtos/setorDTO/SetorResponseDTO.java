package com.pedrochagas.pcrchamados.dtos.setorDTO;

import com.pedrochagas.pcrchamados.entities.Setor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetorResponseDTO {

    private Long id;
    private String nome;

    public SetorResponseDTO(Setor entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
    }
}
