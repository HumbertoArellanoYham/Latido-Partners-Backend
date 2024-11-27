package com.webapplication.latidopartners.controllers;

import com.webapplication.latidopartners.entities.Administrador;
import com.webapplication.latidopartners.services.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin-login")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @GetMapping("/administradores")
    public ResponseEntity<List<Administrador>> foundAdministradores(){
        List<Administrador> administradorList = administradorService.findAll();

        return new ResponseEntity<>(administradorList, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrador> foundAdmin(@PathVariable(value = "id") Long id){
        Optional<Administrador> admin = administradorService.findById(id);

        return admin.map(administrador -> new ResponseEntity<>(administrador, HttpStatus.FOUND)).
                orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping("/agregar-admin/")
    public ResponseEntity<Administrador> agregarAdministrador(@RequestBody Administrador admin){
        return new ResponseEntity<>(administradorService.save(admin), HttpStatus.ACCEPTED);
    }


    @PatchMapping("/modificar-admin/")
    public ResponseEntity<Administrador> modificarAdministrador(@RequestBody Administrador admin){
        return new ResponseEntity<>(administradorService.save(admin), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarAdmin(@PathVariable(value = "id") Long id){
        administradorService.remove(id);

        Optional<Administrador> isFoundAdmin = administradorService.findById(id);

        if(isFoundAdmin.isPresent()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/")
    public ResponseEntity<?> eliminarAdmin(@RequestBody Administrador administrador){
        administradorService.removeForEntity(administrador);

        Optional<Administrador> isFoundAdmin = administradorService.findById(administrador.getIdAdmin());

        if(isFoundAdmin.isPresent()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/validar-login/{usuario}/{clave}")
    public ResponseEntity<Administrador> validarLogin(@PathVariable(value = "usuario") String usuario, @PathVariable(value = "clave") String clave){
        Optional<Administrador> isValidated = administradorService.validarLogin(usuario, clave);

        return isValidated.map(administrador -> new ResponseEntity<>(administrador, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));

    }

}
