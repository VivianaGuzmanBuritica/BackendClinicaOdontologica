package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.model.OdontologoDto;
import com.example.clinicaOdontologica.service.OdontologoServiceLista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/odontologos")
public class ControllerOdontologo implements Controllers<OdontologoDto> {

    @Autowired
    OdontologoServiceLista serviceLista;


    @Override
    @PostMapping("/agregar")
    public Boolean agregar(@RequestBody OdontologoDto o) {
        boolean respuesta;

        respuesta = serviceLista.agregar(o);

        return respuesta;

    }

    @Override
    @RequestMapping(method = RequestMethod.GET, path = "/buscarPorMatricula")
    public OdontologoDto buscar(@RequestParam("matricula") int matricula) {
        if (matricula != 0) {
            return serviceLista.buscarPorMatricula(matricula);
        }
        return null;
    }

    @Override
    @GetMapping("/todos")
    public List<OdontologoDto> listar() {
        return serviceLista.buscarTodos();
    }


    @Override
    public int modificar(int matricula, int matriculaNueva) {
        return 0;
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE, path = "/eliminarPorMatricula")
    public boolean eliminar(@RequestParam("matricula") int matricula) {
        if (matricula != 0) {
            serviceLista.eliminar(matricula);
        } else {
            return false;
        }
        return true;
    }
}
