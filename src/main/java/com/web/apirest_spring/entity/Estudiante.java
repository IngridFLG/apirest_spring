package com.web.apirest_spring.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    private String nombre;

    private LocalDate fechaNac;

    private Integer edad;

    private Double nota1;

    private Double nota2;

    private Double nota3;

    @Transient
    private Double notaFinal;
}
