package com.example.clinicaOdontologica.persistance.repository;


import com.example.clinicaOdontologica.persistance.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
}
