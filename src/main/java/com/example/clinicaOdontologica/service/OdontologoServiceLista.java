package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.model.Odontologo;
import com.example.clinicaOdontologica.persistance.IDaoLista;
import com.example.clinicaOdontologica.persistance.OdontologoDaoLista;

import java.util.List;
import java.util.stream.Collectors;

public class OdontologoServiceLista {


    IDaoLista<Odontologo> repository = new OdontologoDaoLista();

    public List<Odontologo> buscarTodos() {
        return repository.getDatos();
    }

    public boolean agregar(Odontologo o) {
        if (!o.getNombre().isEmpty()) {
            repository.getDatos().add(o);
        } else {
            return false;
        }

        return true;
    }

    public Odontologo buscarPorMatricula(int matricula) {
        List<Odontologo> resultadoDeLaBúsqueda = repository.getDatos().stream().filter(e -> e.getMatricula() == (matricula)).collect(Collectors.toList());
        return resultadoDeLaBúsqueda.get(0);
    }

    public boolean eliminar(int matricula){
        if (!repository.getDatos().isEmpty()) {
            repository.getDatos().removeIf(e -> e.getMatricula() == (matricula));
        } else {
            return false;
        }
        return true;

    }
}
