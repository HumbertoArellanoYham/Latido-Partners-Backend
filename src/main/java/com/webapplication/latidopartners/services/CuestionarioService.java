package com.webapplication.latidopartners.services;

import com.webapplication.latidopartners.entities.Cuestionario;
import com.webapplication.latidopartners.entities.Pregunta;
import com.webapplication.latidopartners.entities.Resultado;
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

    @Autowired
    private PreguntaService preguntaService;

    @Override
    public List<Cuestionario> findAll() {
        return cuestionarioRepository.findAll();
    }

    @Override
    public Optional<Cuestionario> findById(Long id) {
        return cuestionarioRepository.findById(id);
    }

    @Override
    public Cuestionario save(Cuestionario cuestionario) {
        return null;
    }

    @Override
    public Optional<Cuestionario> saveOptional(Cuestionario cuestionario) {
        Cuestionario cuestionario1 = new Cuestionario();
        cuestionario1.setNombre(cuestionario.getNombre());
        cuestionario1.setActivo(cuestionario.getActivo());

        cuestionarioRepository.save(cuestionario1);

        /*
         * Recorrer toda la lista de preguntas
         * a cada pregunta se le va a asignar el cuestionario correspondiente
         */
        cuestionario.getPreguntasList().forEach((pregunta) ->{
            pregunta.setCuestionario(cuestionario1);
            preguntaService.save(pregunta);
        });

        // Validar si se agrego correctamente
        return cuestionarioRepository.searchCuestionarioByName(cuestionario1.getNombre());
    }

    @Override
    public void remove(Long id) {
        cuestionarioRepository.deleteById(id);
    }

    @Override
    public void removeForEntity(Cuestionario cuestionario) {

    }

    public List<Cuestionario> obtenerSoloLosCuestionarioActivos(){
        return cuestionarioRepository.obtenerCuestionarioActivos();
    }

}
