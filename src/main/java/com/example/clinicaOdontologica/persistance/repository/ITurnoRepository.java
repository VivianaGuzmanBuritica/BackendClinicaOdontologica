package com.example.clinicaOdontologica.persistance.repository;

import com.example.clinicaOdontologica.persistance.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnoRepository extends JpaRepository<Turno, Long> {
}
