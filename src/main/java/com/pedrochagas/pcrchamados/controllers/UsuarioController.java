package com.pedrochagas.pcrchamados.controllers;

import com.pedrochagas.pcrchamados.dtos.usuarioDTO.UsuarioRequestDTO;
import com.pedrochagas.pcrchamados.dtos.usuarioDTO.UsuarioResponseDTO;
import com.pedrochagas.pcrchamados.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
