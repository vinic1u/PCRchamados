package com.pedrochagas.pcrchamados.dtos.usuarioDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequestDTO {


    private String nome;

    private String email;

    private String telefone;

    private Long idSetor;
}
