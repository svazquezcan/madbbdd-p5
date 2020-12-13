/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto2.DAO;

import MadBBDD.producto2.SQL.SQLDelegacionDAO;
import MadBBDD.producto2.SQL.SQLONGDAO;
import MadBBDD.producto2.SQL.SQLPersonalDAO;
import MadBBDD.producto2.SQL.SQLProyectoDAO;
import MadBBDD.producto2.XML.XmlContratadoDAO;
import MadBBDD.producto2.Factory.DAOFactoryImpl;
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
   public abstract class DAOFactory {

	public abstract XmlPersonalDAO getPersonalDAO() throws JAXBException;
	public abstract XmlProyectoDAO getProyectosDAO() throws JAXBException;
	public abstract XmlDelegacionDAO getDelegacionesDAO() throws JAXBException;
        public abstract XmlVoluntarioDAO getVoluntariosDAO() throws JAXBException;
        public abstract XmlVoluntarioInternacionalDAO getVoluntariosInternacionalesDAO() throws JAXBException;
        public abstract XmlContratadoDAO getContratadosDAO() throws JAXBException;
        public abstract XmlONGDAO getONGsDAO() throws JAXBException;
        
        public abstract SQLPersonalDAO getPersonalDAOSQL() throws SQLException; 
        public abstract SQLProyectoDAO getProyectosDAOSQL() throws SQLException; 
        public abstract SQLDelegacionDAO getDelegacionesDAOSQL() throws SQLException;
        public abstract SQLONGDAO getONGsDAOSQL() throws SQLException;

	public static DAOFactory getDAOFactory() {
            return new DAOFactoryImpl();
	}

} 
