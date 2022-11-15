package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.dao.iDao;
import com.example.clinicaOdontologica.model.Odontologo;

import java.util.List;

public class OdontologoService {

    private iDao<Odontologo> odontologoiDao;

    public OdontologoService(iDao<Odontologo> odontologoiDao) {

        this.odontologoiDao = odontologoiDao;
    }

    public OdontologoService() {

        this.odontologoiDao = odontologoiDao;
    }

    public Boolean agregar(Odontologo odontologo){

        return odontologoiDao.agregar(odontologo);
    }

    public Odontologo buscar(int id){

        return odontologoiDao.buscar(id);
    }

    public int modificar(int matricula, int id){

        return odontologoiDao.modificar(matricula, id);

    }

    public int eliminarPorId(int id){

        return odontologoiDao.eliminar(id);

    }

    public List<Odontologo> listar(){

        return odontologoiDao.listar();
    }
}
