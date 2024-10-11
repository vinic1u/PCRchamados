package com.pedrochagas.pcrchamados.entities;

import com.pedrochagas.pcrchamados.enums.ChamadoStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_chamado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(70)",nullable = false)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    private LocalDateTime abertoEm;

    @Enumerated(EnumType.STRING)
    private ChamadoStatus status;

    @ManyToOne
    @JoinColumn(name = "id_operador")
    private Operador operador;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

}
