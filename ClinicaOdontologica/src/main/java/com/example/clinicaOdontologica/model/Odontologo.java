package com.example.clinicaOdontologica.model;

public class Odontologo {

    private int id;
    private String apellido;
    private String nombre;
    private int matricula;

    public Odontologo() {
    }

    public Odontologo(String apellido, String nombre, int matricula) {

        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
    }

        public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", matricula=" + matricula +
                '}';
    }
}
