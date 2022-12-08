package com.example.clinicaOdontologica.persistance.repository;

import com.example.clinicaOdontologica.persistance.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {

    @Query("SELECT o FROM Odontologo AS o WHERE o.matricula LIKE %:matricula%")
    Optional<Odontologo> buscarPorMatricula(@Param("matricula") String matricula);

}
