/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto2.SQL;

import MadBBDD.producto2.DAO.PersonalDAO;
import MadBBDD.producto2.DataSourceJDBC;
import MadBBDD.producto2.Personal;
import MadBBDD.producto2.PersonalList;
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
public class SQLPersonalDAO implements PersonalDAO {
    
    private DataSourceJDBC mySqlDataSource = new DataSourceJDBC();
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(mySqlDataSource.getDataSource());
    
    public SQLPersonalDAO() throws SQLException {
        this.mySqlDataSource = mySqlDataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertar(PersonalList a) {
        try {                   
            ArrayList<Personal> listadoPersonal = a.getPersonalList();
            /*Recorremos arraylist de personal e insertamos uno a uno en BBDD*/
            for(int i = 0; i<listadoPersonal.size(); i++){
                String delegacion = listadoPersonal.get(i).getDelegacion();
                int idDelegacion = listadoPersonal.get(i).obtenerIdDelegacion(delegacion);

                jdbcTemplate.update(
                "INSERT INTO personal(idDelegacion,nombre,apellido,usuario,contraseña,tipoDePersonal) VALUES (?,?,?,?,?,?)", idDelegacion,listadoPersonal.get(i).getNombre(),listadoPersonal.get(i).getApellido(),listadoPersonal.get(i).getUsuario(),listadoPersonal.get(i).getPassword(),listadoPersonal.get(i).getTipoDePersonal());
                System.out.println("El personal de id " + listadoPersonal.get(i).getCodigoDePersonal()+ " ha sido creado.");
      
            }
        
        }
        
        catch(DataIntegrityViolationException e){
            System.out.println("DataIntegrityViolationException");
            
        }
    }

    @Override
    public void modificar(String a, String b, Integer c) {
        String sql = "UPDATE personal SET ";
        String sqlUpdate = sql.concat(a);
        String sqlLast = sqlUpdate + " = ? WHERE codigoDePersonal = ?";
        jdbcTemplate.update(sqlLast,b,c);
        System.out.println("El atributo " + a + " del personal de código " + c + " pasa a ser ahora " + b);
    }

    @Override
    public void eliminar(Integer a) {
        jdbcTemplate.update(
        "DELETE FROM personal WHERE codigoDePersonal = ?;",a);
        System.out.println("El personal de código " + a + " ha sido eliminado con éxito");

    }

    @Override
    /*En realidad no necesita el parámetro de entrada PersonalList pero lo mantenemos porque es función CRUD y las clases XML del anterior producto sí lo necesitan*/
    public void obtenerTodos(PersonalList a) throws JAXBException, IOException {
        List<Map<String,Object>> rows = (List<Map<String,Object>>)
        jdbcTemplate.queryForList("SELECT * FROM personal"); 
        rows.forEach(System.out::println);
    }
    

    @Override
    public Personal obtener(Integer String) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int lastCodigoDePersonal(){
        int lastCodigoDePersonal = jdbcTemplate.queryForObject("SELECT codigoDePersonal FROM personal ORDER BY idDelegacion DESC LIMIT 1", Integer.class);
        return lastCodigoDePersonal;
    }
    
    public void volcarDatosXML (PersonalList a) throws FileNotFoundException, JAXBException{
        InputStream inStream = new FileInputStream("Personal.xml");
        JAXBContext context = JAXBContext.newInstance(PersonalList.class); 
        Unmarshaller unmarshaller = context.createUnmarshaller(); 

        PersonalList datosPersonalListXML = (PersonalList) unmarshaller.unmarshal(inStream);
        ArrayList<Personal> listaPersonalXML = datosPersonalListXML.getPersonalList();
        /*Recorremos arraylist de voluntariosInternacionales de unmarshaller y volcamos los de la primera BBDD en XML*/
        for(int i = 0; i<listaPersonalXML.size(); i++){
            String delegacion = listaPersonalXML.get(i).getDelegacion();
            int idDelegacion = listaPersonalXML.get(i).obtenerIdDelegacion(delegacion);

        jdbcTemplate.update(
        "INSERT INTO personal(idDelegacion,nombre,apellido,usuario,contraseña,tipoDePersonal) VALUES (?,?,?,?,?,?)", idDelegacion,listaPersonalXML.get(i).getNombre(),listaPersonalXML.get(i).getApellido(),listaPersonalXML.get(i).getUsuario(),listaPersonalXML.get(i).getPassword(),listaPersonalXML.get(i).getTipoDePersonal());
        }

        System.out.println("El XML del listado de personal ha sido volcado con éxito");
        
    }

}
