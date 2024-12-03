package com.webapplication.latidopartners.controllers;

import com.webapplication.latidopartners.entities.Resultado;
import com.webapplication.latidopartners.services.CuestionarioService;
import com.webapplication.latidopartners.services.PartnersService;
import com.webapplication.latidopartners.services.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/resultado")
public class ResultadoController {

    @Autowired
    private ResultadoService resultadoService;

    @GetMapping(path = "/resultadoById/{id}")
    public ResponseEntity<Resultado> obtenerResultadoPorId(@PathVariable(value = "id") Long id){
        return resultadoService.findById(id).map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping(path = "/respuesta")
    public ResponseEntity<Resultado> agregarResultado(@RequestBody Resultado resultado){
        Optional<Resultado> guardarResultadoService = resultadoService.saveOptional(resultado);

        return guardarResultadoService.map(item -> new ResponseEntity<>(item, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Resultado>> obtenerListaDeResultados(){
         return new ResponseEntity<>(resultadoService.findAll(), HttpStatus.OK);
    }
}
