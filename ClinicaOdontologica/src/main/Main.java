package main;

import main.dao.imple.OdontologoDaoH2;
import main.model.Odontologo;
import main.service.OdontologoService;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static Logger logger = Logger.getLogger(Main.class);
//
    public static void main(String[] args) {

//        OdontologoService app1= new OdontologoService(new OdontologoDaoH2());
//        app1.buscar(1);

//        // Registrar el Controlador
        try {
            Class.forName("org.h2.Driver");
        }
        catch(ClassNotFoundException ex) {
            logger.error("Error: unable to load driver class!");
            System.exit(1);
        }
//        // REALIZAR LA CONEXION
        String URL = "jdbc:h2:~/test";
        String USER = "sa";
        String PASS = "";
        //BORRAR TABLA
      String SQL_BORRAR_TABLA = "DROP TABLE IF EXISTS odontologo";
//
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement()){
//
            stmt.execute(SQL_BORRAR_TABLA);
//            //CREAR TABLA
//           stmt.execute("CREATE TABLE odontologo(matricula INT PRIMARY KEY, apellido VARCHAR(40), nombre VARCHAR(40))");
//            //INSERTAR DATOS
//            stmt.executeUpdate(generarSentenciaInsert(100, "Ruiz", "Martha"));
//            stmt.executeUpdate(generarSentenciaInsert(101, "Tolo", "Fer"));
//            stmt.executeUpdate(generarSentenciaInsert(102, "Tolo", "mar"));
//            stmt.executeUpdate(generarSentenciaInsert(103, "Tolo", "rick"));

//
//
//            //Utilizar ResultSet para obtener los datos provenientes de una consulta SQL
            ResultSet rs = stmt.executeQuery("SELECT * FROM odontologo");
//
  //          procesarElResultSet(rs);
//
//
//            //MODIFICAR DATOS
//
 //           stmt.executeUpdate(generarSentenciaUpdate(101,"Perez","Vivi"));
  //          stmt.executeUpdate(generarSentenciaUpdate(102,"Garcia","Dani"));
//
            System.out.println("/////////////////////////////");
//            //ELIMINAR DATOS
  //          int cantRegistrosAfectados = stmt.executeUpdate("DELETE FROM odontologo WHERE apellido ='Tolo'");
//
//
//            //Utilizar ResultSet para obtener los datos provenientes de una consulta SQL actualizado
 //           rs = stmt.executeQuery("SELECT * FROM odontologo");
//
 //           System.out.println(rs + "\tRegistros afectados luego del delete: " + cantRegistrosAfectados);
//
 //           procesarElResultSet(rs);
//
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
 }
//
   }
//
//
    public static void procesarElResultSet(ResultSet rs) throws SQLException {
        List<Odontologo> odontologos = new ArrayList<>();
//
        while (rs.next()){
            Odontologo odontologo = new Odontologo();

            odontologo.setMatricula(rs.getInt("matricula"));
            odontologo.setApellido(rs.getString("apellido"));
            odontologo.setNombre(rs.getString("nombre"));
//
            odontologos.add(odontologo);

            logger.info(odontologo.toString());
        }
//
        odontologos.forEach(a -> System.out.println("["+ a.getMatricula() +"]: " + a.getNombre()));
    }
//
    public static String generarSentenciaInsert(int matricula, String apellido, String nombre){
        return "INSERT INTO odontologo VALUES(" + matricula + ", '" + apellido + "', '" + nombre + "')";
    }
//
    public static String generarSentenciaUpdate(int matricula, String apellido, String nombre){
        return "UPDATE odontologo SET apellido='"+apellido+"', nombre='"+nombre+"' WHERE matricula="+matricula;
   }
}