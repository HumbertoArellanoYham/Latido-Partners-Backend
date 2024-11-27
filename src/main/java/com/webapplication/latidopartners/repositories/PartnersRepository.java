package com.webapplication.latidopartners.repositories;

import com.webapplication.latidopartners.entities.Partners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnersRepository extends JpaRepository<Partners, Long> {
}
