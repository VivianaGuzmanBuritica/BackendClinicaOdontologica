package com.example.clinicaOdontologica.persistance.repository;


import com.example.clinicaOdontologica.persistance.entity.Odontologo;
import com.example.clinicaOdontologica.persistance.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
    @Query("SELECT p FROM Paciente AS p WHERE p.nombre LIKE %:nombre%")
    Optional<Paciente> buscarPorNombre(@Param("nombre") String nombre);

}
