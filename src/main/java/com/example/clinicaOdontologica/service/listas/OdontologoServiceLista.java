package com.example.clinicaOdontologica.service.listas;

import com.example.clinicaOdontologica.model.OdontologoDto;
import com.example.clinicaOdontologica.persistance.listas.IDaoLista;
import com.example.clinicaOdontologica.persistance.listas.OdontologoDaoLista;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OdontologoServiceLista {


    IDaoLista<OdontologoDto> repository = new OdontologoDaoLista();

    public List<OdontologoDto> buscarTodos() {
        return repository.getDatos();
    }

    public boolean agregar(OdontologoDto o) {
        if (!o.getNombre().isEmpty()) {
            repository.getDatos().add(o);
        } else {
            return false;
        }

        return true;
    }

    public OdontologoDto buscarPorMatricula(int matricula) {
        List<OdontologoDto> resultadoDeLaBúsqueda = repository.getDatos().stream().filter(e -> e.getMatricula() == (matricula)).collect(Collectors.toList());
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
