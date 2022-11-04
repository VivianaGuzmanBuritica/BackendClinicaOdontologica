package main.dao;

import main.model.Odontologo;

import java.util.List;

public interface iDao <accion>{

    accion agregar(accion accion);

    accion buscar(int id);

    List<accion> listar();
    int modificar(int matricula, int id);

    int eliminar(int id);
}
