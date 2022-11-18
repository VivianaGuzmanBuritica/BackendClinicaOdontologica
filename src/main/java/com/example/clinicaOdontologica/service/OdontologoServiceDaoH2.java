package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.dao.iDao;
import com.example.clinicaOdontologica.model.OdontologoDTO;

import java.util.List;

public class OdontologoServiceDaoH2 {

    private iDao<OdontologoDTO> odontologoiDao;

    public OdontologoServiceDaoH2(iDao<OdontologoDTO> odontologoiDao) {

        this.odontologoiDao = odontologoiDao;
    }

    public OdontologoServiceDaoH2() {

        this.odontologoiDao = odontologoiDao;
    }

    public Boolean agregar(OdontologoDTO odontologo){

        return odontologoiDao.agregar(odontologo);
    }



    public OdontologoDTO buscar(int id){

        return odontologoiDao.buscar(id);
    }

    public int modificar(int matricula, int id){

        return odontologoiDao.modificar(matricula, id);

    }

    public int eliminarPorId(int id){

        return odontologoiDao.eliminar(id);

    }

    public List<OdontologoDTO> listar(){

        return odontologoiDao.listar();
    }
}
