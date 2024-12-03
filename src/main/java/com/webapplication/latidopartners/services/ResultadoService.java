package com.webapplication.latidopartners.services;

import com.webapplication.latidopartners.entities.Resultado;
import com.webapplication.latidopartners.repositories.ResultadoRepository;
import com.webapplication.latidopartners.services.interfaces.DataOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultadoService implements DataOperations<Resultado> {

    @Autowired
    private PartnersService partnersService;

    @Autowired
    private CuestionarioService cuestionarioService;

    @Autowired
    private ResultadoRepository resultadoRepository;

    @Override
    public List<Resultado> findAll() {
        return resultadoRepository.findAll();
    }

    @Override
    public Optional<Resultado> findById(Long id) {
        return resultadoRepository.findById(id);
    }

    @Override
    public Resultado save(Resultado resultado) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void removeForEntity(Resultado resultado) {

    }

    @Override
    public Optional<Resultado> saveOptional(Resultado resultado) {
        return Optional.of(resultadoRepository.save(resultado));
    }
}
