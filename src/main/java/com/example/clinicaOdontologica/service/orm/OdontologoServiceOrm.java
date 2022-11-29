package com.example.clinicaOdontologica.service.orm;

import com.example.clinicaOdontologica.model.OdontologoDto;
import com.example.clinicaOdontologica.persistance.entity.Odontologo;
import com.example.clinicaOdontologica.persistance.entity.Paciente;
import com.example.clinicaOdontologica.persistance.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OdontologoServiceOrm {
    private  final IOdontologoRepository odontologoRepository;


    public OdontologoServiceOrm(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }
    public List<Odontologo> listar(){
           return odontologoRepository.findAll();
    }
    public Odontologo  agregar(Odontologo odontologoNuevo){
        if(odontologoNuevo != null){
            return odontologoRepository.save(odontologoNuevo);
        }
        return new Odontologo();
    }
    public Optional <Odontologo> buscarPorId(Long id) {

        return odontologoRepository.findById(id);
    }
    public boolean eliminar(Long id){
        if (!odontologoRepository.findById(id).isPresent()) {
            odontologoRepository.deleteById(id);
        } else {
            return false;
        }
        return true;

    }

}
