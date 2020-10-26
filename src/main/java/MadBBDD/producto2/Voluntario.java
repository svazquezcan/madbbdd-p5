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
@XmlRootElement(name="voluntario")
@XmlAccessorType (XmlAccessType.NONE)
public class Voluntario extends Personal {
    
    @XmlElement(name="dni")
    private String DNI; 
    @XmlElement(name="codigodevoluntario")
    private int codigoDeVoluntario; 
    
    /*Constructor para crear voluntario y asignarle un proyecto a la vez*/
    public Voluntario(String tipoDePersonal, String nombre, String apellido, ArrayList<Proyecto> listadoProyectos, String usuario, String contraseña, String delegacion, String DNI, int codigoDeVoluntario) {
        super(tipoDePersonal, nombre, apellido, listadoProyectos, usuario, contraseña, delegacion);
        this.DNI = DNI; 
        this.codigoDeVoluntario = codigoDeVoluntario; 
    }
    
    /*Constructor para crear voluntario sin asignar proyecto*/
    public Voluntario(String tipoDePersonal, String nombre, String apellido, String usuario, String contraseña, String delegacion, String DNI, int codigoDeVoluntario) {
        super(tipoDePersonal, nombre, apellido, usuario, contraseña, delegacion);
        this.DNI = DNI; 
        this.codigoDeVoluntario = codigoDeVoluntario; 
    }
    
    /*Constructor sin args para JAXB*/
    public Voluntario(){
        
    }
    
   /**Getter
     * @return DNI*/   
    public String getDNI(){
        return this.DNI;
    }
    
    /**Getter
     * @return codigoDeVoluntario*/
    public int getcodigoDeVoluntario(){
        return this.codigoDeVoluntario;
    }
   
       /**Setter
     * @param DNI, para añadir/modificar el DNI de Voluntario*/
    public void setDNI (String DNI){
        this.DNI = DNI; 
    } 
    
        /**Setter
     * @param codigoDeVoluntario, para añadir/modificar el codigoDeVoluntario de Voluntario*/
    public void setCodigoDeVoluntario (int codigoDeVoluntario){
        this.codigoDeVoluntario = codigoDeVoluntario; 
    }  
   
}
