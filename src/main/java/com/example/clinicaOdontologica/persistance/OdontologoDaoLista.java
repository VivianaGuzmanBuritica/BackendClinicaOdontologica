package com.example.clinicaOdontologica.persistance;

import com.example.clinicaOdontologica.model.OdontologoDTO;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoLista implements IDaoLista<OdontologoDTO> {

    private List<OdontologoDTO> datos;

    public OdontologoDaoLista() {
        this.datos = new ArrayList<>();
        datos.add(new OdontologoDTO("Gonzalez", "Pepe", 12345));
        datos.add(new OdontologoDTO("Lopera", "Maria", 4321));
    }

    @Override
    public List<OdontologoDTO> getDatos() {return datos; }

}
