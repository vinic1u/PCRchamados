package com.pedrochagas.pcrchamados.entities;

import com.pedrochagas.pcrchamados.dtos.observacaoDTO.ObservacaoRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_observacoes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Observacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String mensagem;

    private LocalDateTime enviadaEm;

    @ManyToOne
    private Chamado chamado;

    public Observacao(String mensagem,LocalDateTime enviadaEm){
        this.mensagem = mensagem;
        this.enviadaEm = enviadaEm;
    }
}
