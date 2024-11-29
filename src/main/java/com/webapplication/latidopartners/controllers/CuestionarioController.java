package com.webapplication.latidopartners.controllers;

import com.webapplication.latidopartners.entities.Cuestionario;
import com.webapplication.latidopartners.services.CuestionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/cuestionario")
public class CuestionarioController {

    @Autowired
    private CuestionarioService cuestionarioService;

    @PostMapping
    public ResponseEntity<Cuestionario> agregarCuestionario(@RequestBody Cuestionario cuestionario){
        Optional<Cuestionario> cuestionarioAgregado = cuestionarioService.saveOptional(cuestionario);

        return cuestionarioAgregado.map(item -> new ResponseEntity<>(item, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(path = "/all-cuestionarios")
    public ResponseEntity<List<Cuestionario>> obtenerTodosLosCuestionarios(){
        return new ResponseEntity<>(cuestionarioService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeCuestionarioById(@PathVariable(value = "id") Long id){
       cuestionarioService.remove(id);

       Optional<Cuestionario> isFound = cuestionarioService.findById(id);

       return isFound.map(cuestionario -> new ResponseEntity<>(HttpStatus.BAD_REQUEST))
               .orElseGet(() -> new ResponseEntity<>(HttpStatus.OK));
    }

    @GetMapping(path= "/obtener-cuestionario/{id}")
    public ResponseEntity<Cuestionario> obtenerCuestionario(@PathVariable(value = "id") Long id){
        return cuestionarioService.findById(id).map((cuestionario) -> new ResponseEntity<>(cuestionario, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

}
