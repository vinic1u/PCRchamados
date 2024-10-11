package com.pedrochagas.pcrchamados.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_setor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(100)",nullable = false,unique = true)
    private String nome;

    @OneToMany(mappedBy = "setor")
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "setor")
    private List<Operador> operadores;
}
