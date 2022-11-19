package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.dao.iDao;
import com.example.clinicaOdontologica.model.OdontologoDto;

import java.util.List;

public class OdontologoServiceDaoH2 {

    private iDao<OdontologoDto> odontologoiDao;

    public OdontologoServiceDaoH2(iDao<OdontologoDto> odontologoiDao) {

        this.odontologoiDao = odontologoiDao;
    }

    public OdontologoServiceDaoH2() {

        this.odontologoiDao = odontologoiDao;
    }

    public Boolean agregar(OdontologoDto odontologo){

        return odontologoiDao.agregar(odontologo);
    }



    public OdontologoDto buscar(int id){

        return odontologoiDao.buscar(id);
    }

    public int modificar(int matricula, int id){

        return odontologoiDao.modificar(matricula, id);

    }

    public int eliminarPorId(int id){

        return odontologoiDao.eliminar(id);

    }

    public List<OdontologoDto> listar(){

        return odontologoiDao.listar();
    }
}
