package com.example.clinicaOdontologica.service.orm;


import com.example.clinicaOdontologica.model.TurnoDto;

import com.example.clinicaOdontologica.persistance.entity.Turno;
import com.example.clinicaOdontologica.persistance.repository.IOdontologoRepository;
import com.example.clinicaOdontologica.persistance.repository.IPacienteRepository;
import com.example.clinicaOdontologica.persistance.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoServiceOrm {

    private final ITurnoRepository turnoRepository;

   /* private final IOdontologoRepository odontologoRepository;

    private final IPacienteRepository pacienteRepository;*/

    @Autowired
    ObjectMapper mapper;

    public TurnoServiceOrm(ITurnoRepository turnoRepository, IOdontologoRepository odontologoRepository, IPacienteRepository pacienteRepository) {
        this.turnoRepository = turnoRepository;
        /*this.odontologoRepository = odontologoRepository;
        this.pacienteRepository = pacienteRepository;*/
    }

    public TurnoDto agregar(TurnoDto turnoNuevo) {
        Turno t = mapper.convertValue(turnoNuevo, Turno.class);

        if (t != null
        /*&& odontologoRepository.findById(t.getOdontologo().getId()).isPresent()
        && pacienteRepository.findById(t.getOdontologo().getId()).isPresent()*/
        ) {

            turnoRepository.save(t);
        }
        return turnoNuevo;
    }

    public Set<TurnoDto> listar() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDto> turnosDto = new HashSet<>();

        for (Turno t : turnos) {
            turnosDto.add(mapper.convertValue(t, TurnoDto.class));
        }
        return turnosDto;
    }

    public TurnoDto buscarPorId(Long id) {
        Optional<Turno> t = turnoRepository.findById(id);
        TurnoDto turnoDtoId = null;
        if (t.isPresent()) {
            turnoDtoId = mapper.convertValue(t, TurnoDto.class);
        }
        return turnoDtoId;
    }

    public boolean eliminar(Long id){
        if(!turnoRepository.findById(id).isPresent()){
            turnoRepository.deleteById(id);
        }  else{
            return false;
        }
        return true;
    }


}
