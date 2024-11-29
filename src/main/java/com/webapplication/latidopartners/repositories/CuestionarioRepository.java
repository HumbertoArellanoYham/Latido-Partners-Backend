package com.webapplication.latidopartners.repositories;

import com.webapplication.latidopartners.entities.Cuestionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuestionarioRepository extends JpaRepository<Cuestionario, Long> {
    @Query(value = "Select * from cuestionario c where c.nombre = ?1", nativeQuery = true)
    Optional<Cuestionario> searchCuestionarioByName(String nombre);
}
