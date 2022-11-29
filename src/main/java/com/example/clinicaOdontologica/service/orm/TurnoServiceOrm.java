package com.example.clinicaOdontologica.service.orm;


import com.example.clinicaOdontologica.config.MapperConfig;
import com.example.clinicaOdontologica.model.TurnoDto;

import com.example.clinicaOdontologica.persistance.entity.Turno;
import com.example.clinicaOdontologica.persistance.repository.IOdontologoRepository;
import com.example.clinicaOdontologica.persistance.repository.IPacienteRepository;
import com.example.clinicaOdontologica.persistance.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurnoServiceOrm {
    private final ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;


/*    @Autowired
    private MapperConfig mMapper;*/

    public TurnoServiceOrm(ITurnoRepository turnoRepository, IOdontologoRepository odontologoRepository, IPacienteRepository pacienteRepository) {
        this.turnoRepository = turnoRepository;
    }

    public TurnoDto agregar(TurnoDto turnoNuevo) {
        Turno t = mapper.convertValue(turnoNuevo, Turno.class);

        if (t != null) {

            turnoRepository.save(t);
        }
        return turnoNuevo;
    }

    public Set<TurnoDto> listar() {
        List<Turno> turnos = turnoRepository.findAll();
        System.out.println(turnos);
        Set<TurnoDto> turnosDto = new HashSet<>();
        System.out.println(turnosDto);

        for (Turno t : turnos) {
            turnosDto.add(mapper.convertValue(t, TurnoDto.class));
            System.out.println(turnosDto);
        }
        return turnosDto;}

       /* public List<TurnoDto> listar() {

        List<TurnoDto> resultado = new ArrayList<>();

       List<Turno> entidades = turnoRepository.findAll();

        entidades.forEach(e -> resultado.add(mMapper.getModelMapper().map(e, TurnoDto.class)));

        return resultado;

    }*/

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
