/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto2;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sandra
 */
@XmlRootElement(name="personal")
@XmlAccessorType (XmlAccessType.NONE)

public class Personal {
    private static AtomicInteger codigoDePersonalCount = new AtomicInteger(1);
    @XmlElement (name="codigoDePersonal")
    private int codigoDePersonal;
    @XmlElement (name="tipoDePersonal")
    private String tipoDePersonal;
    @XmlElement (name="nombre")
    private String nombre; 
    @XmlElement (name="apellido")
    private String apellido; 
    private ArrayList<Proyecto> listadoProyectos;  
    @XmlElement (name="usuario")
    private String usuario; 
    @XmlElement (name="contraseña")
    private String contraseña; 
    @XmlElement (name="delegacion")
    private String delegacion;

    /**Constructor
     * @param codigoDePersonal
     * @param tipoDePersonal
     * @param nombre
     * @param apellido
     * @param listadoProyectos
     * @param usuario
     * @param contraseña
     * @param delegacion*/
    
    public Personal (int codigoDePersonal, String tipoDePersonal, String nombre, String apellido,  ArrayList<Proyecto> listadoProyectos, String usuario, String contraseña, String delegacion){
        this.codigoDePersonal = codigoDePersonalCount.getAndIncrement();
        this.tipoDePersonal = tipoDePersonal; 
        this.nombre = nombre; 
        this.apellido = apellido; 
        this.listadoProyectos = listadoProyectos;
        this.usuario = usuario; 
        this.contraseña = contraseña; 
        this.delegacion = delegacion;
    }
    
    /*constructor para testeo*/
    public Personal (String tipoDePersonal, String nombre, String apellido, String usuario, String contraseña, String delegacion){
        this.tipoDePersonal = tipoDePersonal; 
        this.nombre = nombre; 
        this.apellido = apellido; 
        this.usuario = usuario;
        this.contraseña = contraseña; 
        this.delegacion = delegacion; 
    }
    
      /*constructor para testeo*/
    public Personal (int codigoDePersonal){
       this.codigoDePersonal = codigoDePersonalCount.getAndIncrement();
    }
    
    /*constructor sin argumentos para JAXB*/
    public Personal (){
    }
    
    
    /**Getter
     * @return codigoDePersonal*/
    public int getCodigoDePersonal(){
        return this.codigoDePersonal;
    }
    
     /**Getter
     * @return tipoDePersonal*/
    public String getTipoDePersonal(){
        return this.tipoDePersonal;
    }
    
    
     /**Getter
     * @return nombre*/
    public String getNombre(){
        return this.nombre;
    }
    
    
     /**Getter
     * @return apellido*/
    public String getApellido(){
        return this.apellido;
    }
    
    
     /**Getter
     * @return proyecto*/
    public ArrayList<Proyecto> getListadoProyectos(){
        return this.listadoProyectos;
    }
    
    
     /**Getter
     * @return usuario*/
    public String getUsuario(){
        return this.usuario;
    }
    
    
     /**Getter
     * @return contraseña*/
    public String getContraseña(){
        return this.contraseña;
    }  
    
     /**Getter
     * @return delegacion*/
    public String getDelegacion(){
        return this.delegacion;
    }  
    
      /**Setter
     * @param codigoDePersonal, para añadir/modificar el codigoDePersonal de Personal*/
    public void setCodigoDePersonal(int codigoDePersonal){
        this.codigoDePersonal = codigoDePersonal; 
    }  

      /**Setter
     * @param tipoDePersonal, para añadir/modificar el tipoDePersonal de Personal*/
    public void setTipoDePersonal(String tipoDePersonal){
        this.tipoDePersonal = tipoDePersonal; 
    }  
    
       /**Setter
     * @param nombre, para añadir/modificar el nombre de Personal*/
    public void setNombre(String nombre){
        this.nombre = nombre; 
    }  
    
       /**Setter
     * @param apellido, para añadir/modificar el apellido de Personal*/
    public void setApellido (String apellido){
        this.apellido = apellido; 
    }  
    
       /**Setter
     * @param listadoProyectos, para añadir/modificar el listado de Proyectos de Personal*/
    public void setListadoProyectos(ArrayList<Proyecto> listadoProyectos){
        this.listadoProyectos = listadoProyectos; 
    }  
    
       /**Setter
     * @param usuario, para añadir/modificar el usuario de Personal*/
    public void setUsuario(String usuario){
        this.usuario = usuario; 
    }  
    
        /**Setter
     * @param contraseña, para añadir/modificar la contraseña de Personal*/
    public void setContraseña(String contraseña){
        this.contraseña = contraseña; 
    }  
    
       /**Setter
     * @param delegacion, para añadir/modificar la delegacion de Personal*/
    public void setDelegacion(String delegacion){
        this.delegacion = delegacion; 
    }  
    
}