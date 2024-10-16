package com.pedrochagas.pcrchamados.dtos.operadorDTO;

import com.pedrochagas.pcrchamados.entities.Setor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperadorRequestDTO {

    private String nome;

    private String email;

    private String telefone;

    public Long setorId;

}
