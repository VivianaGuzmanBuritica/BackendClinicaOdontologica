
import com.example.clinicaOdontologica.model.OdontologoDto;
import com.example.clinicaOdontologica.service.OdontologoServiceDaoH2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

class OdontologoServiceDaoH2Test {

    private OdontologoServiceDaoH2 odontologoService = new OdontologoServiceDaoH2();

    @Test
    void agregarOdontologo(){
        //DADOS
        OdontologoDto odontologo = new OdontologoDto("Guzman", "Viviana", 1234);
        OdontologoDto odontologo2 = new OdontologoDto("Buritica", "Viviana", 1235);
        //CUANDO
        odontologoService.agregar(odontologo);
        odontologoService.agregar(odontologo2);
       //ENTONCES
        Assertions.assertTrue(odontologoService.buscar(1) != null);
    }

     @Test
     void buscarPorId(){
        OdontologoDto odontologo = odontologoService.buscar(2);
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
        OdontologoDto odontologo1 = new OdontologoDto("Guzman", "Paca", 1234);
        OdontologoDto odontologo2 = new OdontologoDto("Buritica", "Leon", 1235);
        OdontologoDto odontologo3 = new OdontologoDto("Buritica", "Dani", 1236);
        //CUANDO
        odontologoService.agregar(odontologo1);
        odontologoService.agregar(odontologo2);
        odontologoService.agregar(odontologo3);

        List<OdontologoDto> odontologos= odontologoService.listar();
        //ENTONCES
        Assertions.assertTrue(odontologos.size() >0);

    }
}