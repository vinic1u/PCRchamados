package com.pedrochagas.pcrchamados.controllers;

import com.pedrochagas.pcrchamados.dtos.chamadoDTO.ChamadoRequestDTO;
import com.pedrochagas.pcrchamados.dtos.chamadoDTO.ChamadoResponseDTO;
import com.pedrochagas.pcrchamados.dtos.observacaoDTO.ObservacaoRequestDTO;
import com.pedrochagas.pcrchamados.entities.Chamado;
import com.pedrochagas.pcrchamados.enums.ChamadoStatus;
import com.pedrochagas.pcrchamados.services.ChamadoService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {

    @Autowired
    private ChamadoService chamadoService;

    @PostMapping
    public ResponseEntity<ChamadoResponseDTO> abrirChamado(
            @RequestBody ChamadoRequestDTO dto
            ){
        ChamadoResponseDTO response = chamadoService.abrirChamado(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<ChamadoResponseDTO>> listarChamados(Pageable pageable){
        return ResponseEntity.ok(chamadoService.listarChamados(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChamadoResponseDTO> buscarChamadoPorId(
            @PathVariable(name = "id") Long id
    ){
        return ResponseEntity.ok(chamadoService.buscarChamadoPorId(id));
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<ChamadoResponseDTO>> buscarChamadoPorNome(
            @RequestParam(name = "usuario") String nome,
            Pageable pageable
    ){
        return ResponseEntity.ok(chamadoService.buscarChamadosPorUsuario(nome,pageable));
    }

    @PostMapping("/{id}/novaobservacao")
    public ResponseEntity<ChamadoResponseDTO> adicionarObservacao(
            @PathVariable(name = "id") Long id,
            @RequestBody ObservacaoRequestDTO dto
            ){
        ChamadoResponseDTO response = chamadoService.adicionarObservacoes(dto,id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Void> atualizarStatus(
            @PathVariable(name = "id") Long id,
            @RequestBody ChamadoStatus status
    ){
        chamadoService.atualizarStatus(id,status);
        return ResponseEntity.noContent().build();
    }


}
