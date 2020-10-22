/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto2;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sandra
 */
@XmlRootElement(name="delegacion")
public class Delegacion {
   
    private String nombre; 
    private String direccion; 
    private int telefono; 
    private ArrayList<Personal> listaDePersonal;
    
    /**Constructor
     * @param nombre
     * @param direccion
     * @param telefono*/
    
    public Delegacion(String nombre, String direccion, int telefono){
    this.nombre = nombre; 
    this.direccion = direccion; 
    this.telefono = telefono; 
}
    /*Constructor sin argumentos para JAXB*/
    public Delegacion(){
    }
    
     /**Getter
     * @return nombre*/
    @XmlAttribute(name="nombre")
    public String getNombre(){
        return this.nombre;
    }
    
     /**Getter
     * @return direccion*/
    @XmlAttribute(name="direccion")
    public String getDireccion(){
        return this.direccion;
    }
    
     /**Getter
     * @return telefono*/
    @XmlAttribute(name="telefono")
    public int getTelefono(){
        return this.telefono;
    }
    
     /**Getter
     * @return listaDePersonal*/
    @XmlElementWrapper(name="listaDePersonal")
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
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    /**Setter
     * @param listaDePersonal*/
    public void setListaDePersonal(ArrayList<Personal> listaDePersonal) {
        this.listaDePersonal = listaDePersonal;
    }
    
      /*creo delegacion para testeo*/
    public static Delegacion addDelegacion1(){
        Delegacion delegacion1 = new Delegacion("Entreculturas España", "Calle Ok", 555555);
        return(delegacion1);
     } 
    
    public static Delegacion addDelegacion2(){
        Delegacion delegacion2 = new Delegacion("Entreculturas Francia", "Calle Calle", 444444);
        return(delegacion2);
    }
    
    public static Delegacion addDelegacion3(){
         Delegacion delegacion3 = new Delegacion("Entreculturas Portugal", "Calle Bien", 777777); 
         return(delegacion3);
    }
}
