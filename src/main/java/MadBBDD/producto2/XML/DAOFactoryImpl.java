/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto2.XML;

import MadBBDD.producto2.DAO.DAOFactory;
import MadBBDD.producto2.SQL.SQLContratadoDAO;
import MadBBDD.producto2.SQL.SQLDelegacionDAO;
import MadBBDD.producto2.SQL.SQLONGDAO;
import MadBBDD.producto2.SQL.SQLPersonalDAO;
import MadBBDD.producto2.SQL.SQLProyectoDAO;
import MadBBDD.producto2.SQL.SQLVoluntarioDAO;
import MadBBDD.producto2.SQL.SQLVoluntarioInternacionalDAO;
import java.sql.SQLException;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Sandra
 */
public class DAOFactoryImpl extends DAOFactory {

    @Override
    public XmlPersonalDAO getPersonalDAO() throws JAXBException {
        return new XmlPersonalDAO();        
    }

    @Override
    public XmlProyectoDAO getProyectosDAO() throws JAXBException {
        return new XmlProyectoDAO(); 
    }
        

    @Override
    public XmlDelegacionDAO getDelegacionesDAO() throws JAXBException {
        return new XmlDelegacionDAO();
    }

    @Override
    public XmlVoluntarioDAO getVoluntariosDAO() throws JAXBException {
        return new XmlVoluntarioDAO(); 
    }

    @Override
    public XmlVoluntarioInternacionalDAO getVoluntariosInternacionalesDAO() throws JAXBException {
        return new XmlVoluntarioInternacionalDAO(); 
    }

    @Override
    public XmlContratadoDAO getContratadosDAO() throws JAXBException {
        return new XmlContratadoDAO();
    }
    
    @Override
    public XmlONGDAO getONGsDAO() throws JAXBException {
        return new XmlONGDAO();
    }

    @Override
    public SQLPersonalDAO getPersonalDAOSQL() throws SQLException {
        return new SQLPersonalDAO(); 
    }

    @Override
    public SQLProyectoDAO getProyectosDAOSQL() throws SQLException {
        return new SQLProyectoDAO(); 
    }

    @Override
    public SQLDelegacionDAO getDelegacionesDAOSQL() throws SQLException {
        return new SQLDelegacionDAO(); 
    }

    @Override
    public SQLVoluntarioDAO getVoluntariosDAOSQL() throws SQLException {
        return new SQLVoluntarioDAO(); 
    }

    @Override
    public SQLVoluntarioInternacionalDAO getVoluntariosInternacionalesDAOSQL() throws SQLException {
        return new SQLVoluntarioInternacionalDAO(); 
    }

    @Override
    public SQLContratadoDAO getContratadosDAOSQL() throws SQLException {
        return new SQLContratadoDAO(); 
    }

    @Override
    public SQLONGDAO getONGsDAOSQL() throws SQLException {
        return new SQLONGDAO(); 
    }

}
