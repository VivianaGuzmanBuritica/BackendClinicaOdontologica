package com.example.clinicaOdontologica.model;

import java.io.Serializable;
import java.util.Date;

public class TurnoDto implements Serializable {
    private int id;
    private Date fechaTurno;
    private OdontologoDto odontologo;
    private PacienteDto paciente;


    /*public class TurnoDTO {

        private Long idPaciente;                           private Long idOdontologo;

        private LocalDate fecha;

        public TurnoDto() {
    }*/

    public TurnoDto(Date fechaTurno, OdontologoDto odontologo, PacienteDto paciente) {
        this.fechaTurno = fechaTurno;
        this.odontologo = odontologo;
        this.paciente = paciente;
    }

    public int getId() {
        return id;
    }

    public Date getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(Date fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public OdontologoDto getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(OdontologoDto odontologo) {
        this.odontologo = odontologo;
    }

    public PacienteDto getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDto paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "TurnoDto{" +
                "id=" + id +
                ", fechaTurno=" + fechaTurno +
                ", odontologo=" + odontologo +
                ", paciente=" + paciente +
                '}';
    }
}
