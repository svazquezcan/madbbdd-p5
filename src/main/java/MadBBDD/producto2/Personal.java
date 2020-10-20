/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto2;

import java.util.ArrayList;

/**
 *
 * @author Sandra
 */
public class Personal {
    private String tipoDePersonal;
    private String nombre; 
    private String apellido; 
    private ArrayList<Proyecto> listadoProyectos;  
    private String usuario; 
    private String contraseña; 
    private String delegacion;

    
    
    /**Constructor
     * @param tipoDePersonal
     * @param nombre
     * @param apellido
     * @param listadoProyectos
     * @param usuario
     * @param contraseña
     * @param delegacion*/
    
    public Personal (String tipoDePersonal, String nombre, String apellido,  ArrayList<Proyecto> listadoProyectos, String usuario, String contraseña, String delegacion){
        this.tipoDePersonal = tipoDePersonal; 
        this.nombre = nombre; 
        this.apellido = apellido; 
        this.listadoProyectos = listadoProyectos;
        this.usuario = usuario; 
        this.contraseña = contraseña; 
        this.delegacion = delegacion;
    }
    
    /*constructor para testeo*/
    public Personal (String usuario){
        this.usuario = usuario;
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
    
    public static Personal addPersonal(){
        Personal persona1 = new Personal("test");
        return(persona1);
     }    
}
