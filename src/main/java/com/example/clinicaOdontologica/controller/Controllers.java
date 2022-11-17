package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.model.Odontologo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface Controllers <E>{

    Boolean agregar(E accion);


    Boolean agregar(Odontologo o);

    E buscar(int id);

    List<E> listar();

    int modificar(int matricula, int id);

    int eliminar(int id);
}


