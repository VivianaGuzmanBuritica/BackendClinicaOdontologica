package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.model.OdontologoDTO;
import com.example.clinicaOdontologica.persistance.IDaoLista;
import com.example.clinicaOdontologica.persistance.OdontologoDaoLista;

import java.util.List;
import java.util.stream.Collectors;

public class OdontologoServiceLista {


    IDaoLista<OdontologoDTO> repository = new OdontologoDaoLista();

    public List<OdontologoDTO> buscarTodos() {
        return repository.getDatos();
    }

    public boolean agregar(OdontologoDTO o) {
        if (!o.getNombre().isEmpty()) {
            repository.getDatos().add(o);
        } else {
            return false;
        }

        return true;
    }

    public OdontologoDTO buscarPorMatricula(int matricula) {
        List<OdontologoDTO> resultadoDeLaBúsqueda = repository.getDatos().stream().filter(e -> e.getMatricula() == (matricula)).collect(Collectors.toList());
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
