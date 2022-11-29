package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.model.TurnoDto;
import com.example.clinicaOdontologica.service.orm.OdontologoServiceOrm;
import com.example.clinicaOdontologica.service.orm.TurnoServiceOrm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@SpringBootApplication
@RestController
@RequestMapping("/turnos")
public class ControllerTurno {
    @Autowired
    TurnoServiceOrm serviceTurno;
  /*  @Autowired
    OdontologoServiceOrm serviceOdntologo;*/

    @PostMapping("/agregar")
    public TurnoDto agregar(@RequestBody TurnoDto t){

        return serviceTurno.agregar(t);
    }


    @GetMapping("/buscarPorId")
    private TurnoDto buscar(@RequestParam("id") Long id){
        if (id != 0) {
            return serviceTurno.buscarPorId(id);
        }
        return null;
    }

    @GetMapping(value = "/todos", produces = "application/json")
    public Set<TurnoDto> listar(){
        return serviceTurno.listar();
    }
/*
    @GetMapping(value = "/todos", produces = "application/json")
    public List<TurnoDto> listar(){
        return serviceTurno.listar();
    }*/



    @RequestMapping(method = RequestMethod.DELETE, path = "/eliminarPorId")
    public boolean eliminar(@RequestParam("id") Long id) {
        if (id != 0) {
            serviceTurno.eliminar(id);
        } else {
            return false;
        }
        return true;
    }
}
