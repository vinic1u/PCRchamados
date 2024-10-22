package com.pedrochagas.pcrchamados.services;

import com.pedrochagas.pcrchamados.dtos.chamadoDTO.ChamadoRequestDTO;
import com.pedrochagas.pcrchamados.dtos.chamadoDTO.ChamadoResponseDTO;
import com.pedrochagas.pcrchamados.dtos.observacaoDTO.ObservacaoRequestDTO;
import com.pedrochagas.pcrchamados.entities.Chamado;
import com.pedrochagas.pcrchamados.entities.Observacao;
import com.pedrochagas.pcrchamados.entities.Operador;
import com.pedrochagas.pcrchamados.entities.Usuario;
import com.pedrochagas.pcrchamados.enums.ChamadoStatus;
import com.pedrochagas.pcrchamados.repositories.ChamadoRepository;
import com.pedrochagas.pcrchamados.repositories.ObservacaoRepository;
import com.pedrochagas.pcrchamados.repositories.UsuarioRepository;
import com.pedrochagas.pcrchamados.services.exceptions.RecursoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Transactional
    public ChamadoResponseDTO abrirChamado(ChamadoRequestDTO dto){
        Chamado entity = new Chamado();
        entity.setTitulo(dto.getTitulo());
        entity.setStatus(ChamadoStatus.PENDETE_OPERADOR);
        entity.setAbertoEm(LocalDateTime.now());

        Long usuarioId = dto.getUsuarioId();
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(()->new RecursoNaoEncontradoException("Usuario com ID: " + usuarioId + " não encontrado"));
        entity.setUsuario(usuario);


        for (ObservacaoRequestDTO obsDTO : dto.getObservacoes()){
            Observacao observacao = new Observacao(obsDTO.getMensagem(),LocalDateTime.now());
            observacao.setChamado(entity);
            entity.getObservacoes().add(observacao);
        }
        chamadoRepository.save(entity);
        return new ChamadoResponseDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<ChamadoResponseDTO> listarChamados(Pageable pageable){
        Page<Chamado> chamados = chamadoRepository.findAll(pageable);
        return chamados.map(ChamadoResponseDTO::new);
    }

    @Transactional(readOnly = true)
    public ChamadoResponseDTO buscarChamadoPorId(Long id){
        Chamado chamado = chamadoRepository.findById(id)
                .orElseThrow(()->new RecursoNaoEncontradoException("Chamado com ID: " + id + " não encontrado!"));
        return new ChamadoResponseDTO(chamado);
    }

    @Transactional
    public ChamadoResponseDTO adicionarObservacoes(ObservacaoRequestDTO dto,Long id){
        Chamado chamado = chamadoRepository.findById(id)
                .orElseThrow(()->new RecursoNaoEncontradoException("Chamado com ID: " + id + " não encontrado!"));

        Observacao observacao = new Observacao();
        observacao.setMensagem(dto.getMensagem());
        observacao.setEnviadaEm(LocalDateTime.now());
        observacao.setChamado(chamado);

        chamado.getObservacoes().add(observacao);

        chamadoRepository.save(chamado);
        return new ChamadoResponseDTO(chamado);
    }


}
