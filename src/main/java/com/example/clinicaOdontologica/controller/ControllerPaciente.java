package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.model.OdontologoDto;
import com.example.clinicaOdontologica.model.PacienteDto;
import com.example.clinicaOdontologica.service.OdontologoServiceLista;
import com.example.clinicaOdontologica.service.PacienteServiceLista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/pacientes")
public class ControllerPaciente implements Controllers<PacienteDto>{

    @Autowired
    PacienteServiceLista serviceLista;


    @Override
    @PostMapping("/agregar")
    public Boolean agregar(@RequestBody PacienteDto p) {
        boolean respuesta;

        respuesta = serviceLista.agregar(p);

        return respuesta;

    }

    @Override
    @RequestMapping(method = RequestMethod.GET, path = "/buscarPorDni")
    public PacienteDto buscar(@RequestParam("dni") int dni) {
        if (dni != 0) {
            return serviceLista.buscarPorDni(dni);
        }
        return null;
    }

    @Override
    @GetMapping("/todos")
    public List<PacienteDto> listar() {
        return serviceLista.buscarTodos();
    }


    @Override
    public int modificar(int matricula, int matriculaNueva) {
        return 0;
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE, path = "/eliminarPorDni")
    public boolean eliminar(@RequestParam("dni") int dni) {
        if (dni != 0) {
            serviceLista.eliminar(dni);
        } else {
            return false;
        }
        return true;
    }
}

