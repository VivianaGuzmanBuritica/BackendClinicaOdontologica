package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.model.Odontologo;
import com.example.clinicaOdontologica.persistance.OdontologoDaoLista;
import com.example.clinicaOdontologica.service.OdontologoServiceDaoH2;
import com.example.clinicaOdontologica.service.OdontologoServiceLista;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController

public class ControllerOdontologo implements Controllers<Odontologo> {

    OdontologoServiceLista serviceLista = new OdontologoServiceLista();


    @Override
    @PostMapping("/agregar")
    public Boolean agregar(@RequestBody Odontologo o){
        boolean respuesta;

        respuesta = serviceLista.agregar(o);

        return respuesta;

    }

    @Override
    public Odontologo buscar(int id) {
        return null;
    }

    @Override
    @GetMapping("/todos")
    public List<Odontologo> listar() {
        return serviceLista.buscarTodos();
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
