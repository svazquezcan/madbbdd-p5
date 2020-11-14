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
import java.util.List;
import java.util.Map;
import java.lang.Object;
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
    public void insertar(VoluntarioInternacional a) {
        
        try {
            
            File fileVoluntariosInternacionales = new File("VoluntariosInternacionales.xml");
            JAXBContext context = JAXBContext.newInstance(VoluntariosInternacionales.class);   
            Unmarshaller unmarshaller = context.createUnmarshaller(); 
            
            VoluntariosInternacionales datosVoluntariosInternacionales = (VoluntariosInternacionales) unmarshaller.unmarshal(fileVoluntariosInternacionales);
            ArrayList<VoluntarioInternacional> listaVoluntariosInternacionales = datosVoluntariosInternacionales.getVoluntariosInternacionales();
            /**/
            for(VoluntarioInternacional voluntarioInternacional: listaVoluntariosInternacionales){
                int codigoDePersonal = jdbcTemplate.queryForObject("SELECT codigoDePersonal FROM voluntariointernacional", int.class);
                if(a.getCodigoDePersonal()== voluntarioInternacional.getCodigoDePersonal()){
                    jdbcTemplate.update(
                    "INSERT INTO voluntariointernacional(codigoDePersonal, nie) VALUES (?,?)", a.getCodigoDePersonal(),a.getNIE());               
                }
            
            }
            
            System.out.println("El voluntario internacional de id " + a.getCodigoDePersonal()+ "ha sido creado.");
        
        }
        
        catch(DataIntegrityViolationException e){
            System.out.println("El voluntario internacional de id " + a.getCodigoDePersonal()+ " ya existe.");
            
        } catch (JAXBException ex) {
            Logger.getLogger(SQLVoluntarioInternacionalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modificar(VoluntarioInternacional a) {
     try {
            
            File fileVoluntariosInternacionales = new File("VoluntariosInternacionales.xml");
            JAXBContext context = JAXBContext.newInstance(VoluntariosInternacionales.class);   
            Unmarshaller unmarshaller = context.createUnmarshaller(); 
            
            VoluntariosInternacionales datosVoluntariosInternacionales = (VoluntariosInternacionales) unmarshaller.unmarshal(fileVoluntariosInternacionales);
            ArrayList<VoluntarioInternacional> listaVoluntariosInternacionales = datosVoluntariosInternacionales.getVoluntariosInternacionales();
            
            for(VoluntarioInternacional voluntarioInternacional: listaVoluntariosInternacionales){
                //obtiene codigoDePersonal del voluntarioInternacional seleccionado
                int codigoDePersonal = jdbcTemplate.queryForObject("SELECT codigoDePersonal FROM voluntariointernacional WHERE nie = ?", int.class, a.getNIE());
                //obtiene nie del voluntarioInternacional seleccionado
                String NIE = jdbcTemplate.queryForObject("SELECT nie FROM voluntariointernacional where codigoDePersonal = ?", String.class, a.getCodigoDePersonal());
                //solo modificamos el nie, ya que codigoDePersonal no se puede modificar
                if(a.getNIE().equals(voluntarioInternacional.getNIE())){
                    jdbcTemplate.update("UPDATE voluntarioInternacional SET nie = ? WHERE codigoDePersonal = ?;", a.getNIE(),a.getCodigoDePersonal()); 
                }
            
            }
            
            System.out.println("El voluntario internacional de id " + a.getCodigoDePersonal()+ "ha sido modificado.");
        
        }
        
        catch(DataIntegrityViolationException e){
            System.out.println("El voluntario internacional de id " + a.getCodigoDePersonal()+ " no puede modificarse.");
            
        } catch (JAXBException ex) {
            Logger.getLogger(SQLVoluntarioInternacionalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(VoluntarioInternacional a) {
        int codigoDePersonal = jdbcTemplate.queryForObject("SELECT codigoDePersonal FROM voluntariointernacional WHERE nie = ?", int.class, a.getNIE());
        jdbcTemplate.update(
        "DELETE FROM VoluntarioInternacional WHERE codigoDePersonal = ?;", a.getCodigoDePersonal());
        System.out.println("El voluntario internacional ha sido eliminado correctamente.");

    }

    @Override
    public void obtenerTodos(VoluntariosInternacionales a) throws JAXBException, IOException {
        //List<Map><String, Object>> rows = (List<Map<String, Object>>);
    }

    @Override
    public VoluntarioInternacional obtener(String String) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
                
}
    

