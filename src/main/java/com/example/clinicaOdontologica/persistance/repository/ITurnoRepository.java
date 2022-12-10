package com.example.clinicaOdontologica.persistance.repository;

import com.example.clinicaOdontologica.persistance.entity.Paciente;
import com.example.clinicaOdontologica.persistance.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ITurnoRepository extends JpaRepository<Turno, Long> {
    @Query("SELECT t FROM Turno AS t WHERE t.fechaTurno LIKE %:fechaTurno%")
    List<Turno> buscarPorFecha(@Param("fechaTurno") Date fechaTurno);
}
