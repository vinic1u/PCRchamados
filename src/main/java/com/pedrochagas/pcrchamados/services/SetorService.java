package com.pedrochagas.pcrchamados.services;

import com.pedrochagas.pcrchamados.dtos.setorDTO.SetorRequestDTO;
import com.pedrochagas.pcrchamados.dtos.setorDTO.SetorResponseDTO;
import com.pedrochagas.pcrchamados.entities.Setor;
import com.pedrochagas.pcrchamados.repositories.SetorRepository;
import com.pedrochagas.pcrchamados.services.exceptions.RecursoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SetorService {

    @Autowired
    private SetorRepository setorRepository;

    @Transactional
    public SetorResponseDTO criarSetor(SetorRequestDTO dto){
        Setor entity = new Setor();
        entity.setNome(dto.getNome());

        setorRepository.save(entity);
        return new SetorResponseDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<SetorResponseDTO> listarSetores(Pageable pageable){
        Page<Setor> setores = setorRepository.findAll(pageable);
        return setores.map(SetorResponseDTO::new);
    }

    @Transactional(readOnly = true)
    public SetorResponseDTO buscarSetorPorId(Long id){
        Setor entity = setorRepository.findById(id)
                .orElseThrow(()->new RecursoNaoEncontradoException("Setor com ID: "+ id + " não encontrado!"));
        return new SetorResponseDTO(entity);
    }

    @Transactional
    public void deletarSetor(Long id){
        Setor entity = setorRepository.findById(id)
                .orElseThrow(()->new RecursoNaoEncontradoException("Setor com ID: "+ id + " não encontrado!"));
        setorRepository.delete(entity);
    }

    @Transactional
    public SetorResponseDTO atualizarSetor(Long id,SetorRequestDTO dto){
        Setor entity = setorRepository.findById(id)
                .orElseThrow(()->new RecursoNaoEncontradoException("Setor com ID: "+ id + " não encontrado!"));
        entity.setNome(dto.getNome());

        setorRepository.save(entity);
        return new SetorResponseDTO(entity);
    }

}
