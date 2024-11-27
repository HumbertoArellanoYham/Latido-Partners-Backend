package com.webapplication.latidopartners.services;

import com.webapplication.latidopartners.entities.Pregunta;
import com.webapplication.latidopartners.repositories.PreguntaRepository;
import com.webapplication.latidopartners.services.interfaces.DataOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreguntaService implements DataOperations<Pregunta> {

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Override
    public List<Pregunta> findAll() {
        return List.of();
    }

    @Override
    public Optional<Pregunta> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Pregunta save(Pregunta pregunta) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void removeForEntity(Pregunta pregunta) {

    }
}
