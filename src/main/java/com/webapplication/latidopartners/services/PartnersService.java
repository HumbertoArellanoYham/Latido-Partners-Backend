package com.webapplication.latidopartners.services;

import com.webapplication.latidopartners.entities.Partners;
import com.webapplication.latidopartners.repositories.PartnersRepository;
import com.webapplication.latidopartners.services.interfaces.DataOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartnersService implements DataOperations<Partners> {

    @Autowired
    private PartnersRepository partnersRepository;

    @Override
    public List<Partners> findAll() {
        return List.of();
    }

    @Override
    public Optional<Partners> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Partners save(Partners partners) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void removeForEntity(Partners partners) {

    }
}
