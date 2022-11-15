package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.model.Odontologo;
import com.example.clinicaOdontologica.service.OdontologoService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController

public class ControllerOdontologo implements Controllers<Odontologo> {

    OdontologoService service = new OdontologoService();



    @Override
    @PostMapping("/agregar")
    public Boolean agregar(@RequestBody Odontologo o){
        boolean respuesta;

        respuesta = service.agregar(o);

        return respuesta;

    }

    @Override
    public Odontologo buscar(int id) {
        return null;
    }

    @Override
    public List listar() {
        return null;
    }

    @Override
    public int modificar(int matricula, int id) {
        return 0;
    }

    @Override
    public int eliminar(int id) {
        return 0;
    }
}
