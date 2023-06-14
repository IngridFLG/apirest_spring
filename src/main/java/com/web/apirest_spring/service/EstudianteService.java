package com.web.apirest_spring.service;

import com.web.apirest_spring.entity.Estudiante;
import com.web.apirest_spring.respository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {
    @Autowired
    EstudianteRepository estudianteRepository;

    public List<Estudiante> getEstudiantes(){
        return estudianteRepository.findAll();
    }

    public Estudiante getEstudiantes(Integer id){
        return estudianteRepository.findAllById(id);
    }

    public void guardarOActualizar(Estudiante estudiante){
        estudianteRepository.save(estudiante);
    }

    public void eliminar(Integer id){
        estudianteRepository.deleteById(id);
    }

}
