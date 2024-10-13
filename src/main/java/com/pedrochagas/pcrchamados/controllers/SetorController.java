package com.pedrochagas.pcrchamados.controllers;

import com.pedrochagas.pcrchamados.dtos.setorDTO.SetorRequestDTO;
import com.pedrochagas.pcrchamados.dtos.setorDTO.SetorResponseDTO;
import com.pedrochagas.pcrchamados.services.SetorService;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/setores")
public class SetorController {

    @Autowired
    private SetorService setorService;

    @GetMapping
    public ResponseEntity<Page<SetorResponseDTO>> listarSetores(Pageable pageable){
        return ResponseEntity.ok(setorService.listarSetores(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SetorResponseDTO> buscarSetorPorId(
            @PathVariable(name = "id") Long id){
        return ResponseEntity.ok(setorService.buscarSetorPorId(id));
    }

    @PostMapping
    public ResponseEntity<SetorResponseDTO> criarSetor(
            @RequestBody SetorRequestDTO dto
            ){
        SetorResponseDTO response = setorService.criarSetor(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SetorResponseDTO> atualizarSetor(
            @PathVariable(name = "id") Long id,
            @RequestBody SetorRequestDTO dto
    ){
        SetorResponseDTO response = setorService.atualizarSetor(id,dto);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSetor(
            @PathVariable(name = "id") Long id
    ){
        setorService.deletarSetor(id);
        return ResponseEntity.noContent().build();
    }

}
