package com.example.clinicaOdontologica.persistance.listas;

import com.example.clinicaOdontologica.model.OdontologoDto;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoLista implements IDaoLista<OdontologoDto> {

    private List<OdontologoDto> datos;

    public OdontologoDaoLista() {
        this.datos = new ArrayList<>();
        datos.add(new OdontologoDto("Gonzalez", "Pepe", 12345));
        datos.add(new OdontologoDto("Lopera", "Maria", 4321));
    }

    @Override
    public List<OdontologoDto> getDatos() {return datos; }

}
