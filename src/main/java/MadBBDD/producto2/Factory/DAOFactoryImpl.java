/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto2.Factory;

import MadBBDD.producto2.DAO.DAOFactory;
import MadBBDD.producto2.SQL.SQLDelegacionDAO;
import MadBBDD.producto2.SQL.SQLONGDAO;
import MadBBDD.producto2.SQL.SQLPersonalDAO;
import MadBBDD.producto2.SQL.SQLProyectoDAO;
import MadBBDD.producto2.XML.XmlContratadoDAO;
import MadBBDD.producto2.XML.XmlDelegacionDAO;
import MadBBDD.producto2.XML.XmlONGDAO;
import MadBBDD.producto2.XML.XmlPersonalDAO;
import MadBBDD.producto2.XML.XmlProyectoDAO;
import MadBBDD.producto2.XML.XmlVoluntarioDAO;
import MadBBDD.producto2.XML.XmlVoluntarioInternacionalDAO;
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
    public SQLONGDAO getONGsDAOSQL() throws SQLException {
        return new SQLONGDAO(); 
    }

}
