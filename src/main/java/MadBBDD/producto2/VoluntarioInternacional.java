/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto2;      

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sandra
 */
@XmlRootElement(name="voluntariointernacional")
@XmlAccessorType (XmlAccessType.NONE)

public class VoluntarioInternacional extends Personal {
    @XmlElement(name="nie")
    private String NIE; 
    @XmlElement(name="codigodevoluntario")
    private int codigoDeVoluntario; 
    
    /*Constructor para asignar proyectos al crear VoluntarioInternacional*/
    public VoluntarioInternacional(String tipoDePersonal, String nombre, String apellido, ArrayList<Proyecto> listadoProyectos, String usuario, String contraseña, String delegacion, String NIE, int codigoDeVoluntario) {
        super(tipoDePersonal, nombre, apellido, listadoProyectos, usuario, contraseña, delegacion);
        this.NIE = NIE; 
        this.codigoDeVoluntario = codigoDeVoluntario;        
    }
    
     /*Constructor para crear VoluntarioInternacional sin asignar proyecto*/
     public VoluntarioInternacional(String tipoDePersonal, String nombre, String apellido, String usuario, String contraseña, String delegacion, String NIE, int codigoDeVoluntario) {
        super(tipoDePersonal, nombre, apellido, usuario, contraseña, delegacion);
        this.NIE = NIE; 
        this.codigoDeVoluntario = codigoDeVoluntario;        
    }
     
    /*Constructor sin args para JABX*/
     public VoluntarioInternacional(){
         
     }
    
     /**Getter
     * @return NIE*/
    public String getNIE(){
        return this.NIE;
    }
    
     /**Getter
     * @return codigoDeVoluntario*/
    public int getCodigoDeVoluntario(){
        return this.codigoDeVoluntario;
    }
    
       /**Setter
     * @param NIE, para añadir/modificar el NIE de VoluntarioInternacional*/
    public void setNIE (String NIE){
        this.NIE = NIE; 
    } 
    
        /**Setter
     * @param codigoDeVoluntario, para añadir/modificar el codigoDeVoluntario de VoluntarioInternacional*/
    public void setCodigoDeVoluntario (int codigoDeVoluntario){
        this.codigoDeVoluntario = codigoDeVoluntario; 
    }  
   
    
}
