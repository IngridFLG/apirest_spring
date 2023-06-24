package com.web.apirest_spring.service;

import com.web.apirest_spring.entity.Estudiante;
import com.web.apirest_spring.respository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class EstudianteService {
    @Autowired
    EstudianteRepository estudianteRepository;

    public List<Estudiante> getEstudiantes(){
        return estudianteRepository.findAll();
    }

    public Estudiante getEstudiante(Integer id){
        return estudianteRepository.findAllById(id);
    }

    public void guardarOActualizar(Estudiante estudiante){
        estudianteRepository.save(estudiante);
    }

    public void eliminar(Integer id){
        estudianteRepository.deleteById(id);
    }


    /**
     * metodo para calcular los datos del estudiante como
     * la nota final que es un dato no persistido
     * la edad la cual se calcula según su fecha de nacimiento
     * @param estudiantes una lista de estudiantes
     */
    public void calcularDatosEstudiantes(List<Estudiante> estudiantes) {
        LocalDate fechaActual = LocalDate.now();

        for (Estudiante estudiante : estudiantes) {
            double notaFinal = (estudiante.getNota1() + estudiante.getNota2() + estudiante.getNota3()) / 3;
            estudiante.setNotaFinal(notaFinal);

            LocalDate fechaNacimiento = estudiante.getFechaNac();
            int edad = Period.between(fechaNacimiento, fechaActual).getYears();
            estudiante.setEdad(edad);
        }
    }

}
