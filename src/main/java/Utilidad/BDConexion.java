/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidad;
import java.sql.*;


/**
 *
 * @author Sandra
 */
public class BDConexion {

    private Connection conexion = null;
    private Statement sentencia;

    void conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");

            // useSSL = true para que la conexion sea cifrada
            String sURL = "jdbc:mysql://127.0.0.1:3306/producto3?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";

            conexion = java.sql.DriverManager.getConnection(sURL, "root", "arkarianKirtash4");
            System.out.println("Base de datos conectada con éxito.");
        }
        catch( Exception e ){
            e.printStackTrace();
        }
}

    void desconectar(){
        try{
            conexion.close();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //insert / update / delete
    void ejecutar( String sql ){
        try {
            conectar();

            sentencia = conexion.createStatement();

            sentencia.executeUpdate(sql);

        } 
        catch (SQLException e) {
             e.printStackTrace();
        } 
        finally {
            try {
                sentencia.close();
                conexion.close();
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //select
    void consultar( String sql ){
        try {
            conectar();
            sentencia = conexion.createStatement();
            sentencia.executeQuery(sql);

        } 
        catch (SQLException e) {
            e.printStackTrace();
        } 
        finally {
            try {
                sentencia.close();
                conexion.close();
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
	

}

