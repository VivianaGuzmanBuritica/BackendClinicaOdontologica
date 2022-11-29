package com.example.clinicaOdontologica.service.orm;


import com.example.clinicaOdontologica.persistance.entity.Paciente;
import com.example.clinicaOdontologica.persistance.repository.IPacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PacienteServiceOrm {

    private  final IPacienteRepository pacienteRepository;

    public PacienteServiceOrm(IPacienteRepository pacienteRepository) {

        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> listar(){
        return pacienteRepository.findAll();
    }

    public Paciente agregar(Paciente pacienteNuevo){
        if(pacienteNuevo != null){
            return pacienteRepository.save(pacienteNuevo);
        }
        return new Paciente();
    }
    public Optional<Paciente> buscarPorId(Long id) {

        return pacienteRepository.findById(id);
    }

    public boolean eliminar(Long id){
        if (!pacienteRepository.findById(id).isPresent()) {
            pacienteRepository.deleteById(id);
        } else {
            return false;
        }
        return true;

    }


}
