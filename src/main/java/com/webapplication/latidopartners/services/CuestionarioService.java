package com.webapplication.latidopartners.services;

import com.webapplication.latidopartners.entities.Cuestionario;
import com.webapplication.latidopartners.repositories.CuestionarioRepository;
import com.webapplication.latidopartners.services.interfaces.DataOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuestionarioService implements DataOperations<Cuestionario> {

    @Autowired
    private CuestionarioRepository cuestionarioRepository;

    @Override
    public List<Cuestionario> findAll() {
        return List.of();
    }

    @Override
    public Optional<Cuestionario> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Cuestionario save(Cuestionario cuestionario) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void removeForEntity(Cuestionario cuestionario) {

    }
}
