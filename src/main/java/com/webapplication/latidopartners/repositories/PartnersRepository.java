package com.webapplication.latidopartners.repositories;

import com.webapplication.latidopartners.entities.Partners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartnersRepository extends JpaRepository<Partners, Long> {
    @Query(value = "select * from partners p where p.nombre = ?1", nativeQuery = true)
    Optional<Partners> findPartnerByName(String name);

    @Modifying
    @Query(value = "delete from partners p where p.nombre = ?1", nativeQuery = true)
    void removeByName(String nombre);
}
