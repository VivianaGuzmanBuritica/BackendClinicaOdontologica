package com.example.clinicaOdontologica.persistance.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name="paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "dni")
    private int dni;

    @Column(name = "fechaDeAlta")
    private Date fechaDeAlta;

    @OneToOne(fetch = FetchType.EAGER,
    cascade = CascadeType.ALL)
    @JoinColumn(name ="id_domicilio", referencedColumnName = "id")
    private Domicilio domicilio;

   /* @OneToMany(fetch = FetchType.LAZY, mappedBy = "paciente",
            cascade = CascadeType.ALL)
            @JsonIgnoreProperties(value = {"referenceList", "handler","hibernateLazyInitializer"}, allowSetters = true)
    private Set<Turno> idTurnos;*/

    public Paciente() {}
}

