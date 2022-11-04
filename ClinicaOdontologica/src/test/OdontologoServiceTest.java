package test;

import main.dao.imple.OdontologoDaoH2;
import main.model.Odontologo;
import main.service.OdontologoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

class OdontologoServiceTest {

    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @Test
    void agregarOdontologo(){
        //DADOS
        Odontologo odontologo = new Odontologo("Guzman", "Viviana", 1234);
        Odontologo odontologo2 = new Odontologo("Buritica", "Viviana", 1235);
        //CUANDO
        odontologoService.agregar(odontologo);
        odontologoService.agregar(odontologo2);
       //ENTONCES
        Assertions.assertTrue(odontologoService.buscar(1) != null);
    }

     @Test
     void buscarPorId(){
        Odontologo odontologo = odontologoService.buscar(2);
        Assertions.assertNotNull(odontologo);
     }

    @Test
    void modificarMatriculaPorId(){
        int resultado = odontologoService.modificar(7898, 2);
        System.out.println(resultado);
        Assertions.assertTrue(resultado==1);
    }


    @Test
    void eliminarPorId(){
        int resultado = odontologoService.eliminarPorId(1);
        System.out.println(resultado);
        Assertions.assertTrue(resultado==1);
    }

    @Test
    void listar(){
        //DADOS
        Odontologo odontologo1 = new Odontologo("Guzman", "Paca", 1234);
        Odontologo odontologo2 = new Odontologo("Buritica", "Leon", 1235);
        Odontologo odontologo3 = new Odontologo("Buritica", "Dani", 1236);
        //CUANDO
        odontologoService.agregar(odontologo1);
        odontologoService.agregar(odontologo2);
        odontologoService.agregar(odontologo3);

        List<Odontologo> odontologos= odontologoService.listar();
        //ENTONCES
        Assertions.assertTrue(odontologos.size() >0);

    }
}