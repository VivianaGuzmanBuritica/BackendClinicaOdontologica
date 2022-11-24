package com.example.clinicaOdontologica.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "Domicilio")
public class Domicilio {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;

    @Column(name="codigoPostal")
    private int codigoPostal;

    @Column(name="ciudad")
    private String ciudad;

    @Column(name="calle")
    private String calle;

    @Column(name="numero")
    private int numero;

    @Column(name="apartamento")
    private int apartamento;


}
