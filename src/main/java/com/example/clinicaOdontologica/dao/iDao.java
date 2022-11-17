package com.example.clinicaOdontologica.dao;

import java.util.List;

public interface iDao <accion>{

    Boolean agregar(accion accion);

    accion buscar(int id);

    List<accion> listar();
    int modificar(int matricula, int id);

    int eliminar(int id);
}
