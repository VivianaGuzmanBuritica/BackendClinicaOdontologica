package com.example.clinicaOdontologica.dao;

import java.util.List;

public interface iDao<T>{

    Boolean agregar(T tipo);

    T buscar(int id);

    List<T> listar();
    int modificar(int matricula, int id);

    int eliminar(int id);
}
