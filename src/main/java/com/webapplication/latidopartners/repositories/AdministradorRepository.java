package com.webapplication.latidopartners.repositories;

import com.webapplication.latidopartners.entities.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

    @Query(value = "select * from administrador a where a.usuario = ?1", nativeQuery = true)
    Administrador findAdminWithUser(String usuario);
}
