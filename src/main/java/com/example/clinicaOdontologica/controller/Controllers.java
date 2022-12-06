package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.clinicaOdontologica.model.OdontologoDto;
import com.example.clinicaOdontologica.persistance.entity.Paciente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface Controllers <E>{

    E agregar(E accion);

      Optional<E> buscar(Long id) throws ResourceNotFoundException;

    List<E> listar();

    int modificar(int matricula, int matriculaNueva );

    boolean eliminar(Long id) throws ResourceNotFoundException;
}



