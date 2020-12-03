/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto2.SQL;

import MadBBDD.producto2.Contratado;
import MadBBDD.producto2.Contratados;
import MadBBDD.producto2.DAO.PersonalDAO;
import MadBBDD.producto2.DataSourceJDBC;
import MadBBDD.producto2.Personal;
import MadBBDD.producto2.PersonalList;
import MadBBDD.producto2.Voluntario;
import MadBBDD.producto2.VoluntarioInternacional;
import MadBBDD.producto2.Voluntarios;
import MadBBDD.producto2.VoluntariosInternacionales;
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
    
    public int lastCodigoDePersonal(){
        int lastCodigoDePersonal = jdbcTemplate.queryForObject("SELECT codigoDePersonal FROM personal ORDER BY codigoDePersonal DESC LIMIT 1", Integer.class);
        return lastCodigoDePersonal;
    }
    
    
    public void volcarDatosXML (PersonalList a) throws FileNotFoundException, JAXBException{
        InputStream inStream = new FileInputStream("Personal.xml");
        JAXBContext context = JAXBContext.newInstance(PersonalList.class); 
        Unmarshaller unmarshaller = context.createUnmarshaller(); 

        PersonalList datosPersonalListXML = (PersonalList) unmarshaller.unmarshal(inStream);
        ArrayList<Personal> listaPersonalXML = datosPersonalListXML.getPersonalList();
        /*Recorremos arraylist de personal de unmarshaller y volcamos los miembros de personal en la BBDD*/
        for(int i = 0; i<listaPersonalXML.size(); i++){
            String delegacion = listaPersonalXML.get(i).getDelegacion();
            int idDelegacion = listaPersonalXML.get(i).obtenerIdDelegacion(delegacion);

            jdbcTemplate.update(
            "INSERT INTO personal(idDelegacion,nombre,apellido,usuario,contraseña,tipoDePersonal) VALUES (?,?,?,?,?,?)", idDelegacion,listaPersonalXML.get(i).getNombre(),listaPersonalXML.get(i).getApellido(),listaPersonalXML.get(i).getUsuario(),listaPersonalXML.get(i).getPassword(),listaPersonalXML.get(i).getTipoDePersonal());
        
        }
        
        System.out.println("El XML del listado de personal ha sido volcado con éxito");
        
        /*Volvemos a recorrer arraylist de personal de unmarshaller y esta vez vamos detectando las subclases
        y recorriendo a su vez los unmarshaller de las subclases para volcar los tipos de personal en sus respectivas tablas también*/

        for(int i = 0; i<listaPersonalXML.size(); i++){

            if ("Voluntario".equals(listaPersonalXML.get(i).getTipoDePersonal())){
                InputStream inStream2 = new FileInputStream("Voluntarios.xml");
                JAXBContext context2 = JAXBContext.newInstance(Voluntarios.class); 
                Unmarshaller unmarshaller2 = context2.createUnmarshaller(); 

                Voluntarios datosVoluntariosXML = (Voluntarios) unmarshaller2.unmarshal(inStream2);
                ArrayList<Voluntario> listaVoluntariosXML = datosVoluntariosXML.getVoluntarios();
                
                for(int x = 0; x>listaVoluntariosXML.size();x++){
                  jdbcTemplate.update(
                  "INSERT INTO voluntario(dni, codigoDePersonal) VALUES (?, ?)",listaVoluntariosXML.get(i).getDNI(), listaVoluntariosXML.get(i).getCodigoDePersonal());
                  
                }
            }

            else if("VoluntarioInternacional".equals(listaPersonalXML.get(i).getTipoDePersonal())){
                InputStream inStream2 = new FileInputStream("VoluntariosInternacionales.xml");
                JAXBContext context2 = JAXBContext.newInstance(VoluntariosInternacionales.class); 
                Unmarshaller unmarshaller2 = context2.createUnmarshaller(); 

                VoluntariosInternacionales datosVoluntariosInternacionalesXML = (VoluntariosInternacionales) unmarshaller2.unmarshal(inStream2);
                ArrayList<VoluntarioInternacional> listaVoluntariosInternacionalesXML = datosVoluntariosInternacionalesXML.getVoluntariosInternacionales();
                
                for(int y=0; y>listaVoluntariosInternacionalesXML.size(); y++){
                  jdbcTemplate.update(
                  "INSERT INTO voluntariointernacional(nie, codigoDePersonal) VALUES (?, ?)",listaVoluntariosInternacionalesXML.get(i).getNIE(),listaVoluntariosInternacionalesXML.get(i).getCodigoDePersonal());
                  
                }
            }

            else{
                InputStream inStream2 = new FileInputStream("Contratados.xml");
                JAXBContext context2 = JAXBContext.newInstance(Contratados.class); 
                Unmarshaller unmarshaller2 = context2.createUnmarshaller(); 

                Contratados datosContratadosXML = (Contratados) unmarshaller2.unmarshal(inStream2);
                ArrayList<Contratado> listaContratadosXML = datosContratadosXML.getContratados();
                
                for(int z=0;z>listaContratadosXML.size();z++){
                  jdbcTemplate.update(
                  "INSERT INTO contratados(dni, costeSalario, funcion, codigoDePersonal) VALUES (?,?,?,?)",listaContratadosXML.get(i).getDNI(),listaContratadosXML.get(i).getCosteSalario(),listaContratadosXML.get(i).getFuncion(),listaContratadosXML.get(i).getCodigoDePersonal()    );
                  
                } 
            }
                   
        }

        System.out.println("El XML de los listados de las subclases de personal (voluntario, voluntario internacional y contratado) han sido volcados con éxito");

    }

}
