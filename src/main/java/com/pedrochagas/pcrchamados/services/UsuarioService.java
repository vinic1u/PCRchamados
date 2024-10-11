package com.pedrochagas.pcrchamados.services;

import com.pedrochagas.pcrchamados.dtos.usuarioDTO.UsuarioRequestDTO;
import com.pedrochagas.pcrchamados.dtos.usuarioDTO.UsuarioResponseDTO;
import com.pedrochagas.pcrchamados.entities.Setor;
import com.pedrochagas.pcrchamados.entities.Usuario;
import com.pedrochagas.pcrchamados.repositories.SetorRepository;
import com.pedrochagas.pcrchamados.repositories.UsuarioRepository;
import com.pedrochagas.pcrchamados.services.exceptions.RecursoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SetorRepository setorRepository;

    @Transactional
    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO dto){
        Usuario entity = new Usuario();
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());

        Long setorId = dto.getIdSetor();
        Setor setor = setorRepository.findById(setorId)
                .orElseThrow(()->new RecursoNaoEncontradoException("Setor com ID: " + setorId + " não encontrado!" ));
        entity.setSetor(setor);
        usuarioRepository.save(entity);
        return new UsuarioResponseDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<UsuarioResponseDTO> listarUsuarios(Pageable pageable){
        Page<Usuario> usuarios = usuarioRepository.findAll(pageable);
        return usuarios.map(UsuarioResponseDTO::new);
    }

    @Transactional(readOnly = true)
    public UsuarioResponseDTO buscarUsuarioPorId(Long id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()-> new RecursoNaoEncontradoException("Usuario com ID: " + id + " não foi encontrado!"));
        return new UsuarioResponseDTO(usuario);
    }

}
