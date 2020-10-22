/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto2;      

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sandra
 */
@XmlRootElement(name="voluntariointernacional")
public class VoluntarioInternacional extends Personal {
    private String NIE; 
    private int codigoDeVoluntario; 

    public VoluntarioInternacional(String tipoDePersonal, String nombre, String apellido, ArrayList<Proyecto> listadoProyectos, String usuario, String contraseña, String NIE, int codigoDeVoluntario, String delegacion) {
        super(tipoDePersonal, nombre, apellido, listadoProyectos, usuario, contraseña, delegacion);
        this.NIE = NIE; 
        this.codigoDeVoluntario = codigoDeVoluntario;        
    }
    
     /**Getter
     * @return NIE*/
    @XmlAttribute(name="nie")
    public String getNIE(){
        return this.NIE;
    }
    
     /**Getter
     * @return codigoDeVoluntario*/
    @XmlAttribute(name="codigodevoluntario")
    public int getCodigoDeVoluntario(){
        return this.codigoDeVoluntario;
    }
    
}
