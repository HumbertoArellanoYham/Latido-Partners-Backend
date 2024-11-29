package com.webapplication.latidopartners.controllers;

import com.webapplication.latidopartners.entities.Partners;
import com.webapplication.latidopartners.services.PartnersService;
import jakarta.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/partners")
public class PartnersController {
    @Autowired
    private PartnersService partnersService;

    @GetMapping(path = "/all-partners")
    public ResponseEntity<List<Partners>> obtenerTodosLosEmpleados(){
        List<Partners> partnersList = partnersService.findAll();

        return new ResponseEntity<>(partnersList, HttpStatus.OK);
    }

    @GetMapping(path = "/byName/{nombre}")
    public ResponseEntity<Partners> obtenerEmpleadoPorNombre(@PathVariable(value = "nombre") String nombre){
        Optional<Partners> getPartner = partnersService.getByName(nombre);

        return getPartner.map((partner) -> new ResponseEntity<>(partner, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping()
    public ResponseEntity<Partners> guardarEmpleado(@RequestBody Partners partner){
        return partnersService.saveOptional(partner).map((item) ->
                new ResponseEntity<>(item, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping(path = "/removeByName/{nombre}")
    public ResponseEntity<?> eliminarEmpleado(@PathVariable(value = "nombre") String nombre){
        Optional<Partners> isRemoved = partnersService.removeByName(nombre);

        return isRemoved.map(partners -> new ResponseEntity<>(HttpStatus.BAD_REQUEST))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.ACCEPTED));
    }
}
