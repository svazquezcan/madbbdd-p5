/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto2.SQL;

import MadBBDD.producto2.DAO.DelegacionDAO;
import MadBBDD.producto2.DataSourceJDBC;
import MadBBDD.producto2.Delegacion;
import MadBBDD.producto2.Delegaciones;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Sandra
 */
public class SQLDelegacionDAO implements DelegacionDAO {
    
    private DataSourceJDBC mySqlDataSource = new DataSourceJDBC();
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(mySqlDataSource.getDataSource());
    
    public SQLDelegacionDAO() throws SQLException {
        this.mySqlDataSource = mySqlDataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertar(Delegaciones a) {
        try { 
            
            ArrayList<Delegacion> listadoDelegacion = a.getDelegaciones();
                /*Recorremos arraylist de delegacion e insertamos uno a uno en BBDD*/
                for(int i = 0; i<listadoDelegacion.size(); i++){
                    jdbcTemplate.update(
                    "INSERT INTO delegacion(nombre,direccion,telefono,cifOng) VALUES (?,?,?,?)", listadoDelegacion.get(i).getNombre(),listadoDelegacion.get(i).getDireccion(),listadoDelegacion.get(i).getTelefono(), listadoDelegacion.get(i).getCifOng());
                    System.out.println("La delegación de id " + listadoDelegacion.get(i).getIdDelegacion()+ " ha sido creada.");
               }
        
        }
        
        catch(DataIntegrityViolationException e){
            System.out.println("DataIntegrityViolationException");
            
        }
    }
    
    @Override
    public void modificar(String a, String b, Integer c) {
        String sql = "UPDATE delegacion SET ";
        String sqlUpdate = sql.concat(a);
        String sqlLast = sqlUpdate + " = ? WHERE idDelegacion = ?";
        jdbcTemplate.update(sqlLast,b,c);
        System.out.println("El atributo " + a + " de la delegacion de id " + c + " pasa a ser ahora " + b);
    }    

    @Override
    public void eliminar(Integer a) {
        jdbcTemplate.update(
        "DELETE FROM delegacion WHERE idDelegacion = ?;",a);
        System.out.println("La delegación de id " + a + " ha sido eliminada con éxito");

    }    

    @Override
    public void obtenerTodos(Delegaciones a) throws JAXBException, IOException {
 /*En realidad no necesita el parámetro de entrada Delegaciones pero lo mantenemos porque es función CRUD y las clases XML del anterior producto sí lo necesitan*/
        List<Map<String,Object>> rows = (List<Map<String,Object>>)
        jdbcTemplate.queryForList("SELECT * FROM delegacion"); 
        rows.forEach(System.out::println);
    }    
    
     public int lastIdDelegacion(){
        int lastIdDelegacion = jdbcTemplate.queryForObject("SELECT idDelegacion FROM delegacion ORDER BY idDelegacion DESC LIMIT 1", Integer.class);
        return lastIdDelegacion;
    }
     
     public void volcarDatosXML (Delegaciones a) throws FileNotFoundException, JAXBException{
        InputStream inStream = new FileInputStream("Delegaciones.xml");
        JAXBContext context = JAXBContext.newInstance(Delegaciones.class); 
        Unmarshaller unmarshaller = context.createUnmarshaller(); 

        Delegaciones datosDelegacionesXML = (Delegaciones) unmarshaller.unmarshal(inStream);
        ArrayList<Delegacion> listaDelegacionesXML = datosDelegacionesXML.getDelegaciones();
        /*Recorremos arraylist de voluntariosInternacionales de unmarshaller y volcamos los de la primera BBDD en XML*/
        for(int i = 0; i<listaDelegacionesXML.size(); i++){

        jdbcTemplate.update(
        "INSERT INTO delegacion(cifOng,nombre,direccion,telefono) VALUES (?,?,?,?)", listaDelegacionesXML.get(i).getCifOng(),listaDelegacionesXML.get(i).getNombre(),listaDelegacionesXML.get(i).getDireccion(),listaDelegacionesXML.get(i).getTelefono());
        }
        
        System.out.println("El xml de delegaciones ha sido volcado con éxito");

     }
    
}
