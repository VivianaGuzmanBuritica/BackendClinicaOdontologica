package com.example.clinicaOdontologica.persistance.listas;

import com.example.clinicaOdontologica.model.Domicilio;
import com.example.clinicaOdontologica.model.PacienteDto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PacienteDaoLista implements IDaoLista<PacienteDto>{

    private Domicilio domicilio1;
    private Domicilio domicilio2;
    private List<PacienteDto> datos;

    public PacienteDaoLista() {

        this.domicilio1 = new Domicilio(123, "CALi", "siempreViva", 91, 502);
        this.domicilio2 = new Domicilio(567, "BOGOTA", "americas", 32, 10);


        Date fecha = new Date();
        Date fecha2 = new Date(2002, Calendar.JUNE, 21);


        this.datos = new ArrayList<>();
        datos.add(new PacienteDto("Guzman", "Vivi", 9876, fecha, domicilio1 ));
        datos.add(new PacienteDto("Buritica", "Ana", 3456, fecha2, domicilio1 ));
    }

    @Override
    public List<PacienteDto> getDatos() {
        return datos;
    }
}
