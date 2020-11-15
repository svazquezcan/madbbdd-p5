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
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
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
            
            //InputStream inStream = new FileInputStream("Personal.xml");
            //JAXBContext context = JAXBContext.newInstance(PersonalList.class);   
            //Unmarshaller unmarshaller = context.createUnmarshaller(); 
            
           // PersonalList datosPersonalListXML = (PersonalList) unmarshaller.unmarshal(inStream);
            ArrayList<Personal> listadoPersonal = a.getPersonalList();
            //ArrayList<Personal> listaPersonalXML = datosPersonalListXML.getPersonalList();
            /*Recorremos arraylist de voluntariosInternacionales e insertamos los que sean nuevos*/
            for(int i = 0; i<listadoPersonal.size(); i++){
                int lastCodigoDePersonal = lastCodigoDePersonal();
                if(listadoPersonal.get(i).getCodigoDePersonal()<=lastCodigoDePersonal){
                    System.out.println("El personal de id " + listadoPersonal.get(i).getCodigoDePersonal()+ " ya existe.");
                }
               
                else{
                    
                    String delegacion = listadoPersonal.get(i).getDelegacion();
                    int idDelegacion = listadoPersonal.get(i).obtenerIdDelegacion(delegacion);
                    
                    jdbcTemplate.update(
                    "INSERT INTO personal(idDelegacion,nombre,apellido,usuario,contraseña,tipoDePersonal) VALUES (?,?,?,?,?,?)", idDelegacion,listadoPersonal.get(i).getNombre(),listadoPersonal.get(i).getApellido(),listadoPersonal.get(i).getUsuario(),listadoPersonal.get(i).getContraseña(),listadoPersonal.get(i).getTipoDePersonal());
                    System.out.println("El personal de id " + listadoPersonal.get(i).getCodigoDePersonal()+ " ha sido creado.");
        
                }
            }
        
        }
        
        catch(DataIntegrityViolationException e){
            System.out.println("DataIntegrityViolationException");
            
        }
    }

    @Override
    public void modificar(Personal a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Personal a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void obtenerTodos(PersonalList a) throws JAXBException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Personal obtener(String String) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int lastCodigoDePersonal(){
        int lastCodigoDePersonal = jdbcTemplate.queryForObject("SELECT codigoDePersonal FROM personal ORDER BY idDelegacion DESC LIMIT 1", Integer.class);
        return lastCodigoDePersonal;
    }
    
}
