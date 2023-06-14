package com.web.apirest_spring.respository;

import com.web.apirest_spring.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
    Estudiante findAllById(Integer id);
}
