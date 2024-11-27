package com.webapplication.latidopartners.repositories;

import com.webapplication.latidopartners.entities.Cuestionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuestionarioRepository extends JpaRepository<Cuestionario, Long> {
}
