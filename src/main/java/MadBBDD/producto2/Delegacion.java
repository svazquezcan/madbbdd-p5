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
@XmlRootElement(name="delegacion")
@XmlAccessorType (XmlAccessType.NONE)
public class Delegacion {
   
    @XmlElement(name="nombre")
    private String nombre; 
    @XmlElement(name="direccion")
    private String direccion; 
    @XmlElement(name="telefono")
    private String telefono; 
    private ArrayList<Personal> listaDePersonal;
    
    /**Constructor
     * @param nombre
     * @param direccion
     * @param telefono*/
    
    /*Recordar que si creamos delegaciones hay que modificar método EntrarDatosPersonal() en clase ONG para que permita entrar personal en la nueva delegación*/
    public Delegacion(String nombre, String direccion, String telefono){
    this.nombre = nombre; 
    this.direccion = direccion; 
    this.telefono = telefono; 
}
    /*Constructor sin argumentos para JAXB*/
    public Delegacion(){
    }
    
     /**Getter
     * @return nombre*/
    public String getNombre(){
        return this.nombre;
    }
    
     /**Getter
     * @return direccion*/
    public String getDireccion(){
        return this.direccion;
    }
    
     /**Getter
     * @return telefono*/
    public String getTelefono(){
        return this.telefono;
    }
    
     /**Getter
     * @return listaDePersonal*/
    public ArrayList<Personal> getListaDePersonal(){
        return this.listaDePersonal;
    }
    
    /**Setter
     * @param nombre*/
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**Setter
     * @param direccion*/
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**Setter
     * @param telefono*/
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    /**Setter
     * @param listaDePersonal*/
    public void setListaDePersonal(ArrayList<Personal> listaDePersonal) {
        this.listaDePersonal = listaDePersonal;
    }
    
}
