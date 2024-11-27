package com.webapplication.latidopartners.services;

import com.webapplication.latidopartners.entities.Administrador;
import com.webapplication.latidopartners.repositories.AdministradorRepository;
import com.webapplication.latidopartners.services.interfaces.DataOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorService implements DataOperations<Administrador> {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Administrador> findAll() {
        return administradorRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Administrador> findById(Long id) {
        return administradorRepository.findById(id);
    }

    @Transactional
    @Override
    public Administrador save(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    @Transactional
    @Override
    public void remove(Long id) {
        administradorRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void removeForEntity(Administrador administrador) {
        administradorRepository.delete(administrador);
    }

    // Validar administrador login
    @Transactional(readOnly = true)
    public Optional<Administrador> validarLogin(String usuario, String clave) {
        Optional<Administrador> admin = Optional.of(administradorRepository.findAdminWithUser(usuario));

        if (admin.get().getClave().equals(clave)) {
            return admin;
        }

        return Optional.empty();
    }
}
