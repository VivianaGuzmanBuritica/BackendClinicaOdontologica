package com.example.clinicaOdontologica.dao.imple;

import com.example.clinicaOdontologica.dao.iDao;
import com.example.clinicaOdontologica.dao.util.ConfiguracionJDBC;
import com.example.clinicaOdontologica.model.OdontologoDTO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements iDao<OdontologoDTO> {

    private final static Logger logger = Logger.getLogger(OdontologoDaoH2.class);

    private final static ConfiguracionJDBC jdbc = new ConfiguracionJDBC();
    private final static String TABLE = "odontologos";



    @Override
    public Boolean agregar(OdontologoDTO odontologo) {
        jdbc.cargarElControlador();


        try (Connection conexion = jdbc.conectarConBaseDeDatos();

             PreparedStatement stmt = conexion.prepareStatement("INSERT INTO "+ TABLE + "(apellido, nombre, matricula) " +
                     "VALUES(?, ?, ?)")){


            stmt.setString(1, odontologo.getApellido());
            stmt.setString(2, odontologo.getNombre());
            stmt.setInt(3, odontologo.getMatricula());

            stmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }

    }

    @Override
    public OdontologoDTO buscar(int id) {

        jdbc.cargarElControlador();
        OdontologoDTO respuesta = null;
        List<OdontologoDTO> odontologos = new ArrayList<>();

        try (Connection conexion = jdbc.conectarConBaseDeDatos();
             PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM odontologos WHERE id = ?")){

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                respuesta = new OdontologoDTO(

                        rs.getString("apellido"),
                        rs.getString("nombre"),
                        rs.getInt("matricula"));

                odontologos.add(respuesta);
                logger.debug(respuesta.toString());
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

        return respuesta;
    }

    @Override
    public  List<OdontologoDTO> listar() {

        jdbc.cargarElControlador();

        List<OdontologoDTO> odontologos = new ArrayList<>();

        try (Connection conexion = jdbc.conectarConBaseDeDatos();
             PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM odontologos")){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
              OdontologoDTO odontologo = new OdontologoDTO(
                        rs.getString("apellido"),
                        rs.getString("nombre"),
                        rs.getInt("matricula"));

                odontologos.add(odontologo);
            }

            odontologos.forEach(a -> System.out.println("["+ a.getMatricula() +"]: " + a.getNombre()));

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

        return odontologos;
    }

    @Override
    public int modificar(int matricula, int id) {
        jdbc.cargarElControlador();

        try (Connection conexion = jdbc.conectarConBaseDeDatos();
             PreparedStatement stmt = conexion.prepareStatement(
                     "UPDATE odontologos SET matricula= ? WHERE id =?")){

            stmt.setInt(1, matricula);
            stmt.setInt(2, id);

            int rs = stmt.executeUpdate();

            return rs;

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return 0;
        }

    }

    @Override
    public int eliminar(int id) {

        jdbc.cargarElControlador();


        try (Connection conexion = jdbc.conectarConBaseDeDatos();
             PreparedStatement stmt = conexion.prepareStatement("DELETE FROM odontologos WHERE id = ?")){

            stmt.setInt(1, id);

            int rs = stmt.executeUpdate();

            return rs;

        } catch (SQLException e) {
            logger.error(e.getMessage());
            return 0;
        }
    }
}
