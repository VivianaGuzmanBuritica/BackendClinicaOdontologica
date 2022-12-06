package com.example.clinicaOdontologica.service.orm;

import com.example.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.clinicaOdontologica.model.OdontologoDto;
import com.example.clinicaOdontologica.model.TurnoDto;
import com.example.clinicaOdontologica.persistance.entity.Odontologo;
import com.example.clinicaOdontologica.persistance.entity.Paciente;
import com.example.clinicaOdontologica.persistance.entity.Turno;
import com.example.clinicaOdontologica.persistance.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.spec.OAEPParameterSpec;
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
    public Optional <Odontologo> buscarPorId(Long id) throws ResourceNotFoundException {
        Optional<Odontologo> resultado = null;
        if (!id.equals(null)) {
            resultado = odontologoRepository.findById(id);
        } else{
            throw new ResourceNotFoundException("No existe un turno con el id: " + id);
        }
        return resultado;
    }

    public boolean eliminar(Long id) throws ResourceNotFoundException {
        if (odontologoRepository.findById(id).isPresent()) {
            odontologoRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("No se puede eliminar, no existe un Odontologo con el id: "+id);
        }
        return true;

    }

}
