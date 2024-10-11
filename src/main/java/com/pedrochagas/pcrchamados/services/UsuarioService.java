package com.pedrochagas.pcrchamados.services;

import com.pedrochagas.pcrchamados.dtos.usuarioDTO.UsuarioRequestDTO;
import com.pedrochagas.pcrchamados.dtos.usuarioDTO.UsuarioResponseDTO;
import com.pedrochagas.pcrchamados.entities.Setor;
import com.pedrochagas.pcrchamados.entities.Usuario;
import com.pedrochagas.pcrchamados.repositories.SetorRepository;
import com.pedrochagas.pcrchamados.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SetorRepository setorRepository;

    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO dto){
        Usuario entity = new Usuario();
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());

        Setor setor = setorRepository.findById(dto.getIdSetor()).orElseThrow(()->new RuntimeException("Recurso não encontrado"));
        entity.setSetor(setor);
        usuarioRepository.save(entity);
        return new UsuarioResponseDTO(entity);
    }

}
