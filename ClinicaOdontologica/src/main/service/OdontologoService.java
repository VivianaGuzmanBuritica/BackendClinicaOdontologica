package main.service;

import main.dao.iDao;
import main.model.Odontologo;

import java.util.List;

public class OdontologoService {

    private iDao<Odontologo> odontologoiDao;

    public OdontologoService(iDao<Odontologo> odontologoiDao) {

        this.odontologoiDao = odontologoiDao;
    }

    public Odontologo agregar(Odontologo odontologo){

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
