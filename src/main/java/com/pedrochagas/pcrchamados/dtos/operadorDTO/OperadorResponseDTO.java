package com.pedrochagas.pcrchamados.dtos.operadorDTO;

import com.pedrochagas.pcrchamados.entities.Setor;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperadorResponseDTO {

    private Long id;

    private String nome;

    private String email;

    private String telefone;

    public Setor setor;
}
