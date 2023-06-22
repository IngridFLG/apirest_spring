package com.web.apirest_spring.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "email", unique = true, nullable = false)
    String email;

    String nombre;

    Double nota1;

    Double nota2;

    Double nota3;

    @Transient
    private Double notaFinal;
}
