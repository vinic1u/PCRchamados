package com.pedrochagas.pcrchamados.dtos.operadorDTO;

import com.pedrochagas.pcrchamados.dtos.setorDTO.SetorResponseDTO;
import com.pedrochagas.pcrchamados.entities.Operador;
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

    public SetorResponseDTO setor;

    public OperadorResponseDTO(Operador entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.email = entity.getEmail();
        this.telefone = entity.getTelefone();
        this.setor = new SetorResponseDTO(entity.getSetor());
    }
}
