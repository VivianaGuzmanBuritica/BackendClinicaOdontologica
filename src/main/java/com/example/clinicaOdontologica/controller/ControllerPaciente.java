package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.clinicaOdontologica.model.PacienteDto;
import com.example.clinicaOdontologica.persistance.entity.Paciente;
import com.example.clinicaOdontologica.service.orm.PacienteServiceOrm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/pacientes")
public class ControllerPaciente implements Controllers<Paciente>{

    @Autowired
    PacienteServiceOrm service;

    @Override
    @PostMapping("/agregar")
   public Paciente agregar(@RequestBody Paciente p) {

     return service.agregar(p);
//
  }

    @Override
    @RequestMapping(method = RequestMethod.GET, path = "/buscarPorId")
    public Optional<Paciente> buscar(@RequestParam("id") Long id) {
        if (id != 0) {
           return service.buscarPorId(id);
        }
      return null;
   }

   @GetMapping("/buscarPorNombre")
   public Optional<Paciente> buscarPorMatricula(@RequestParam("nombre") String nombre){
        if(!nombre.equals(null)){
            return  service.buscarPorNombre(nombre);
        }
        return null;
   }
    @Override
    @GetMapping("/todos")
    public List<Paciente> listar() {
        return service.listar();
    }


    @Override
    public int modificar(int matricula, int matriculaNueva) {
        return 0;
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE, path = "/eliminarPorId")
    public boolean eliminar(@RequestParam("id") Long id) throws ResourceNotFoundException {
        if (id != 0) {
            service.eliminar(id);
        }
        return true;
    }
}

