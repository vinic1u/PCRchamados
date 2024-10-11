package com.pedrochagas.pcrchamados.controllers;

import com.pedrochagas.pcrchamados.dtos.usuarioDTO.UsuarioRequestDTO;
import com.pedrochagas.pcrchamados.dtos.usuarioDTO.UsuarioResponseDTO;
import com.pedrochagas.pcrchamados.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criarUsuario(
            @RequestBody UsuarioRequestDTO dto
            ){
        UsuarioResponseDTO response = usuarioService.criarUsuario(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<UsuarioResponseDTO>> listarUsuarios(Pageable pageable){
        return ResponseEntity.ok(usuarioService.listarUsuarios(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarUsuarioPorId(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(id));
    }
}
