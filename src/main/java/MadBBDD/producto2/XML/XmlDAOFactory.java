/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto2.XML;

import MadBBDD.producto2.DAO.DAOFactory;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Sandra
 */
public class XmlDAOFactory extends DAOFactory {

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
}
