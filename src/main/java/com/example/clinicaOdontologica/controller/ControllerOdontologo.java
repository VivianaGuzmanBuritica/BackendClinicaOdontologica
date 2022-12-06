package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.clinicaOdontologica.model.OdontologoDto;
import com.example.clinicaOdontologica.persistance.entity.Odontologo;
import com.example.clinicaOdontologica.service.listas.OdontologoServiceLista;
import com.example.clinicaOdontologica.service.orm.OdontologoServiceOrm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/odontologos")
public class ControllerOdontologo implements Controllers<Odontologo> {

    @Autowired
    OdontologoServiceOrm service;

   @Override
   @PostMapping("/agregar")
    public Odontologo agregar(@RequestBody Odontologo o) {

       return service.agregar(o);
   }

    @Override
    @RequestMapping(method = RequestMethod.GET, path = "/buscarPorId")
    public Optional<Odontologo> buscar(@RequestParam("id") Long id) throws ResourceNotFoundException {
        if (id != 0) {
            return service.buscarPorId(id);
        }
        return null;
    }

    @Override
    @GetMapping(value = "/todos", produces = "application/json")
    public List<Odontologo> listar() {
        return service.listar();
    }


    @Override
    public int modificar(int matricula, int matriculaNueva) {
        return 0;
    }
  @Override
    @RequestMapping(method = RequestMethod.DELETE, path = "/eliminarPorId")
   public boolean eliminar(@RequestParam("id") Long id) throws ResourceNotFoundException {
       if (id != null) {
            service.eliminar(id);
     }
      return true;
  }
}
