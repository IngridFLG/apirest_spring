package com.web.apirest_spring.controller;

import com.web.apirest_spring.entity.Estudiante;
import com.web.apirest_spring.models.response.AnyResponse;
import com.web.apirest_spring.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

/*    @GetMapping
    public List<Estudiante> listarEstudiantes(){
        return estudianteService.getEstudiantes();
    }*/

    @GetMapping
    public List<Estudiante> listarEstudiantes() {
        List<Estudiante> estudiantes = estudianteService.getEstudiantes();
        for (Estudiante estudiante : estudiantes) {
            double notaFinal = (estudiante.getNota1() + estudiante.getNota2() + estudiante.getNota3())/3;
            estudiante.setNotaFinal(notaFinal);
        }
        return estudiantes;
    }

    @GetMapping("/{id}")
    public Estudiante obtenerEstudianteId(@PathVariable("id") Integer id){
        Estudiante estudiante = estudianteService.getEstudiante(id);
        double notaFinal = (estudiante.getNota1() + estudiante.getNota2() + estudiante.getNota3())/3;
        estudiante.setNotaFinal(notaFinal);

        return estudiante;
    }

    @PostMapping
    public ResponseEntity<AnyResponse> guardarOActualizar(@RequestBody Estudiante estudiante){

        try {
            boolean esNuevoEstudiante = (estudiante.getId() == null);

            estudianteService.guardarOActualizar(estudiante);

            String mensaje;
            if (esNuevoEstudiante) {
                mensaje = "Estudiante guardado exitosamente";
            } else {
                mensaje = "Estudiante actualizado exitosamente";
            }

            AnyResponse response = new AnyResponse(mensaje);

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            AnyResponse response = new AnyResponse("Error al guardar o actualizar el estudiante");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarEstudiante(@PathVariable("id") Integer id){
        estudianteService.eliminar(id);
    }


}
