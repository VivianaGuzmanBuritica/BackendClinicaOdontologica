package com.example.clinicaOdontologica.persistance;

import com.example.clinicaOdontologica.model.Odontologo;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoLista implements IDaoLista<Odontologo> {

    private List<Odontologo> datos;

    public OdontologoDaoLista() {
        this.datos = new ArrayList<>();
        datos.add(new Odontologo("Gonzalez", "Pepe", 12345));
        datos.add(new Odontologo("Lopera", "Maria", 4321));
    }

    @Override
    public List<Odontologo> getDatos() {return datos; }

}
