package com.pedrochagas.pcrchamados.dtos.usuarioDTO;

import com.pedrochagas.pcrchamados.dtos.setorDTO.SetorResponseDTO;
import com.pedrochagas.pcrchamados.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponseDTO {

    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private SetorResponseDTO setor;

    public UsuarioResponseDTO(Usuario entity){
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.email = entity.getEmail();
        this.telefone = entity.getTelefone();
        this.setor = new SetorResponseDTO(entity.getSetor());
    }
}
