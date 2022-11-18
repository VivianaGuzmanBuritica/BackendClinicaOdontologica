package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.model.OdontologoDTO;

import java.util.List;

public interface Controllers <E>{

    Boolean agregar(E accion);


    Boolean agregar(OdontologoDTO o);

    E buscar(int matricula);

    List<E> listar();

    int modificar(int matricula, int matriculaNueva );

    boolean eliminar(int matricula);
}



