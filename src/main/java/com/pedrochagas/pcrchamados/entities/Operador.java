package com.pedrochagas.pcrchamados.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_operador")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(100)",nullable = false)
    private String nome;

    @Column(columnDefinition = "VARCHAR(100)",nullable = false,unique = true)
    private String email;

    @Column(columnDefinition = "VARCHAR(25)",nullable = false,unique = true)
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "id_setor")
    public Setor setor;

}
