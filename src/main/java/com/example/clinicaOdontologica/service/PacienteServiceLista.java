package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.model.OdontologoDto;
import com.example.clinicaOdontologica.model.PacienteDto;
import com.example.clinicaOdontologica.persistance.IDaoLista;
import com.example.clinicaOdontologica.persistance.OdontologoDaoLista;
import com.example.clinicaOdontologica.persistance.PacienteDaoLista;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteServiceLista {

    IDaoLista<PacienteDto> repository = new PacienteDaoLista();

    public List<PacienteDto> buscarTodos() {
        return repository.getDatos();
    }

    public boolean agregar(PacienteDto o) {
        if (!o.getNombre().isEmpty()) {
            repository.getDatos().add(o);
        } else {
            return false;
        }

        return true;
    }

    public PacienteDto buscarPorDni(int dni) {
        List<PacienteDto> resultadoDeLaBúsqueda = repository.getDatos().stream().filter(e -> e.getDni() == (dni)).collect(Collectors.toList());
        return resultadoDeLaBúsqueda.get(0);
    }

    public boolean eliminar(int dni){
        if (!repository.getDatos().isEmpty()) {
            repository.getDatos().removeIf(e -> e.getDni() == (dni));
        } else {
            return false;
        }
        return true;

    }
}
