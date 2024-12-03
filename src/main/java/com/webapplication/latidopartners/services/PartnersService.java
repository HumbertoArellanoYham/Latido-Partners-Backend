package com.webapplication.latidopartners.services;

import com.webapplication.latidopartners.entities.Partners;
import com.webapplication.latidopartners.repositories.PartnersRepository;
import com.webapplication.latidopartners.services.interfaces.DataOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PartnersService implements DataOperations<Partners> {

    @Autowired
    private PartnersRepository partnersRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Partners> findAll() {
        return partnersRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Partners> findById(Long id) {
        return partnersRepository.findById(id);
    }

    @Transactional
    @Override
    public Partners save(Partners partners) {
        return partnersRepository.save(partners);
    }

    @Transactional
    @Override
    public void remove(Long id) {
        partnersRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void removeForEntity(Partners partners) {
        partnersRepository.delete(partners);
    }

    @Override
    public Optional<Partners> saveOptional(Partners partners) {
        return Optional.of(partnersRepository.save(partners));
    }

    @Transactional(readOnly = true)
    public Optional<Partners> getByName(String nombre) {
        return partnersRepository.findPartnerByName(nombre);
    }

    @Transactional
    public Optional<Partners> removeByName(String nombre) {
       partnersRepository.removeByName(nombre);

       return partnersRepository.findPartnerByName(nombre);
    }
}
