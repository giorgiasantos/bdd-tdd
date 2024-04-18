package com.example.bddtdd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String curso;
    private double primeiraNota;
    private double segundaNota;
    private double media;

    public Aluno(Long id, String nome, String curso, double primeiraNota, double segundaNota) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.primeiraNota = primeiraNota;
        this.segundaNota = segundaNota;
    }
}
