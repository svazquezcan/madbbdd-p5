/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto2.DAO;

import MadBBDD.producto2.XML.XmlContratadoDAO;
import MadBBDD.producto2.XML.XmlDAOFactory;
import MadBBDD.producto2.XML.XmlDelegacionDAO;
import MadBBDD.producto2.XML.XmlONGDAO;
import MadBBDD.producto2.XML.XmlPersonalDAO;
import MadBBDD.producto2.XML.XmlProyectoDAO;
import MadBBDD.producto2.XML.XmlVoluntarioDAO;
import MadBBDD.producto2.XML.XmlVoluntarioInternacionalDAO;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Sandra
 */
   public abstract class DAOFactory {

	// Tipos de DAO soportados por la factoría
	public static final int XML = 1;
	public static final int MYSQL = 2;

	// Debe haber un método por cada DAO que pueda ser creado.
	// La factoría concreta para cada tipo deberá implementar
	// el método que le corresponde.

	public abstract XmlPersonalDAO getPersonalDAO() throws JAXBException;
	public abstract XmlProyectoDAO getProyectosDAO() throws JAXBException;
	public abstract XmlDelegacionDAO getDelegacionesDAO() throws JAXBException;
        public abstract XmlVoluntarioDAO getVoluntariosDAO() throws JAXBException;
        public abstract XmlVoluntarioInternacionalDAO getVoluntariosInternacionalesDAO() throws JAXBException;
        public abstract XmlContratadoDAO getContratadosDAO() throws JAXBException;
        public abstract XmlONGDAO getONGsDAO() throws JAXBException;


	
	public static DAOFactory getDAOFactory(int whichFactory) {

		switch (whichFactory) {
		case XML:
			return new XmlDAOFactory();
		// case MYSQL:
		// return new MySqlDAOFactory();
		default:
			return null;
		}
	}

} 
