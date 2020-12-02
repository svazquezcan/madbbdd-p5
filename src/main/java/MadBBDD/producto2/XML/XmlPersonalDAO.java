/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto2.XML;

import MadBBDD.producto2.DAO.PersonalDAO;
import MadBBDD.producto2.DataSourceJDBC;
import MadBBDD.producto2.Personal;
import MadBBDD.producto2.PersonalList;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 *
 * @author Sandra
 */
public class XmlPersonalDAO implements PersonalDAO{
    
    private JAXBContext context;
    private String nombreFichero;
    private JdbcTemplate jdbcTemplate;
    private DataSourceJDBC mySqlDataSource = new DataSourceJDBC();



    public XmlPersonalDAO() throws JAXBException{
        
        this.context = JAXBContext.newInstance(PersonalList.class);
	this.nombreFichero = "Personal.xml";
        this.jdbcTemplate = new JdbcTemplate(mySqlDataSource.getDataSource());

    }
    
    @Override
    public void insertar(PersonalList a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(String a, String b, Integer c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void obtenerTodos(PersonalList personal) throws PropertyException, JAXBException, IOException {
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(personal, new FileWriter("Personal.xml"));
        System.out.println("El archivo Personal.xml ha sido creado correctamente ");

    }
    
    public int lastCodigoDePersonal(){
        int lastCodigoDePersonal = jdbcTemplate.queryForObject("SELECT codigoDePersonal FROM personal ORDER BY idDelegacion DESC LIMIT 1", Integer.class);
        return lastCodigoDePersonal;
    }
}
