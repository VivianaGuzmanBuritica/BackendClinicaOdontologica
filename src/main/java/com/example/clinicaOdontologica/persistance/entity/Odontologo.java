package com.example.clinicaOdontologica.persistance.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name="odontologo")
public class Odontologo {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "matricula")
    private int matricula;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idOdontologo",
            cascade = CascadeType.ALL)
    private Set<Turno> idTurnos;

 /*   public void asignacionTurnosOdontologo(Turno t){
     if (null == idTurnos) {
            idTurnos= new HashSet<>();
        }
        idTurnos.add(t);
        t.setIdOdontologo(this);
    }

    public void eliminarTurnosOdontologo(Turno t){
        idTurnos.remove(t);
        t.setIdOdontologo(null);
    }*/

    public Odontologo() {
    }
}
