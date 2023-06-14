package com.web.apirest_spring.controller;

import com.web.apirest_spring.entity.Estudiante;
import com.web.apirest_spring.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public List<Estudiante> listarEstudiantes(){
        return estudianteService.getEstudiantes();
    }

    @GetMapping("/{id}")
    public Estudiante obtenerEstudianteId(@PathVariable("id") Integer id){
        return estudianteService.getEstudiante(id);
    }

    @PostMapping
    public void guardarOActualizar(@RequestBody Estudiante estudiante){
        estudianteService.guardarOActualizar(estudiante);
    }

    @DeleteMapping("/{id}")
    public void elimnarEstudiante(@PathVariable("id") Integer id){
        estudianteService.eliminar(id);
    }


}
