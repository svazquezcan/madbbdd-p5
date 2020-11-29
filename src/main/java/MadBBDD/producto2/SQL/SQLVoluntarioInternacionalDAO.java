/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto2.SQL;

import MadBBDD.producto2.DAO.VoluntarioInternacionalDAO;
import MadBBDD.producto2.DataSourceJDBC;
import MadBBDD.producto2.VoluntarioInternacional;
import MadBBDD.producto2.VoluntariosInternacionales;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Sandra
 */
public class SQLVoluntarioInternacionalDAO implements VoluntarioInternacionalDAO {
    
    private DataSourceJDBC mySqlDataSource = new DataSourceJDBC();
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(mySqlDataSource.getDataSource());
    
    public SQLVoluntarioInternacionalDAO() throws SQLException {
        this.mySqlDataSource = mySqlDataSource;
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public void insertar(VoluntariosInternacionales a) {
        try {
            
            File fileVoluntariosInternacionales = new File("VoluntariosInternacionales.xml", "ISO-8859-1");
            JAXBContext context = JAXBContext.newInstance(VoluntariosInternacionales.class);   
            Unmarshaller unmarshaller = context.createUnmarshaller(); 
            
            VoluntariosInternacionales datosVoluntariosInternacionalesXML = (VoluntariosInternacionales) unmarshaller.unmarshal(fileVoluntariosInternacionales);
            ArrayList<VoluntarioInternacional> listaVoluntariosInternacionales = a.getVoluntariosInternacionales();
            ArrayList<VoluntarioInternacional> listaVoluntariosInternacionalesXML = datosVoluntariosInternacionalesXML.getVoluntariosInternacionales();
            int i= 0;
            /*Recorremos arraylist de voluntariosInternacionales e insertamos los que sean nuevos*/
            for(VoluntarioInternacional volInt: listaVoluntariosInternacionales){
                if(volInt.getCodigoDePersonal()==listaVoluntariosInternacionalesXML.get(i).getCodigoDePersonal()){
                     System.out.println("El voluntario internacional de id " + listaVoluntariosInternacionales.get(i).getCodigoDePersonal()+ " ya existe.");
                }
               
                else{
                    jdbcTemplate.update(
                    "INSERT INTO voluntariointernacional( nie) VALUES (?)", listaVoluntariosInternacionales.get(i).getNIE());
                    System.out.println("El voluntario internacional de id " + listaVoluntariosInternacionales.get(i).getCodigoDePersonal()+ "ha sido creado.");
        
                }
            }
        
        }
        
        catch(DataIntegrityViolationException e){
            System.out.println("DataIntegrityViolationException");
            
        } catch (JAXBException ex) {
            Logger.getLogger(SQLVoluntarioInternacionalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void modificar(String a, String b, Integer c) {
   
    }

    @Override
    public void eliminar(Integer a) {


    }

    @Override
    public void obtenerTodos(VoluntariosInternacionales a) throws JAXBException, IOException {
    }

    @Override
    public VoluntarioInternacional obtener(Integer String) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
                
}
    

