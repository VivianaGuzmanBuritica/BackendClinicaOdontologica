package com.example.clinicaOdontologica.model;

public class Domicilio {

    private int codigoPostal;
    private String ciudad;
    private String calle;
    private int numero;
    private int apartamento;

    public Domicilio(int codigoPostal, String ciudad, String calle, int numero, int apartamento) {
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.calle = calle;
        this.numero = numero;
        this.apartamento = apartamento;
    }

    public Domicilio() {

    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getApartamento() {
        return apartamento;
    }

    public void setApartamento(int apartamento) {
        this.apartamento = apartamento;
    }
}
