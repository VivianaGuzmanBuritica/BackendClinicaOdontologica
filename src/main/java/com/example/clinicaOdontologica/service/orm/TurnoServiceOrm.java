package com.example.clinicaOdontologica.service.orm;



import com.example.clinicaOdontologica.exceptions.BadDateRequestException;
import com.example.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.clinicaOdontologica.model.TurnoDto;

import com.example.clinicaOdontologica.persistance.entity.Turno;
import com.example.clinicaOdontologica.persistance.repository.IOdontologoRepository;
import com.example.clinicaOdontologica.persistance.repository.IPacienteRepository;
import com.example.clinicaOdontologica.persistance.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Setter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;




@Setter
@Service
public class TurnoServiceOrm {
    private final ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    private static final Logger logger = Logger.getLogger(OdontologoServiceOrm.class);

    @Autowired
    public TurnoServiceOrm(ITurnoRepository turnoRepository, IOdontologoRepository odontologoRepository, IPacienteRepository pacienteRepository) {
        this.turnoRepository = turnoRepository;
    }

    public TurnoDto agregar(TurnoDto turnoNuevo) throws BadDateRequestException {
        List<Turno> turnos = turnoRepository.findAll();
        Turno t = mapper.convertValue(turnoNuevo, Turno.class);


        for(Turno turno: turnos){
            if (t.getFechaTurno().equals(turno.getFechaTurno())) {
                logger.error("No se pueden agendar dos turnos con la misma fecha");
                throw new BadDateRequestException("No se pueden agendar dos turnos con la misma fecha");

            }
        }
        turnoRepository.save(t);
        logger.info("Se agrego correctamente el turno");

        return turnoNuevo;
    }

    public Set<TurnoDto> listar() throws ResourceNotFoundException {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDto> turnosDto = new HashSet<>();

        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        if(!turnos.isEmpty()){
        for (Turno t : turnos) {
            turnosDto.add(mapper.convertValue(t, TurnoDto.class));

        }} else{
            throw new ResourceNotFoundException("No se encuentran turnos");
        }

        return turnosDto;
    }

     public TurnoDto buscarPorId(Long id) throws ResourceNotFoundException {
        Optional<Turno> t = turnoRepository.findById(id);
        TurnoDto turnoDtoId = null;
        if (t.isPresent()) {
            turnoDtoId = mapper.convertValue(t, TurnoDto.class);

               } else{
            throw new ResourceNotFoundException("No existe un turno con el id: "+id);
        }
        return turnoDtoId;
    }

    public Set<TurnoDto> buscarPorFecha(Date fechaTurno)throws ResourceNotFoundException{
        List<Turno> turnos = turnoRepository.buscarPorFecha(fechaTurno);
        Set<TurnoDto> turnosDto = new HashSet<>();

        if(!turnos.isEmpty()){
            for (Turno t : turnos) {
                turnosDto.add(mapper.convertValue(t, TurnoDto.class));

            }} else{
            throw new ResourceNotFoundException("No se encuentran turnos");
        }

        return turnosDto;
    }

    public boolean eliminar(Long id) throws ResourceNotFoundException {
        if(turnoRepository.findById(id).isPresent()){
            turnoRepository.deleteById(id);
        }  else{
            throw new ResourceNotFoundException("No se puede eliminar, no existe un turno con el id: "+id);
        }
        return true;
    }



}
