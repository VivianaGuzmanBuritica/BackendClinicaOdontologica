package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.model.Odontologo;
import com.example.clinicaOdontologica.persistance.IDaoLista;
import com.example.clinicaOdontologica.persistance.OdontologoDaoLista;

import java.util.List;

public class OdontologoServiceLista {


    IDaoLista<Odontologo> repository = new OdontologoDaoLista();

    public List<Odontologo> buscarTodos(){
        return repository.getDatos();
    }
    public boolean agregar(Odontologo o) {
        if(!o.getNombre().isEmpty()) {
            repository.getDatos().add(o);
        }else{
            return false;
        }

        return true;
    }
}
