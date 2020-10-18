/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto2;

import java.util.ArrayList;
import java.util.Scanner;

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
    
    
    /**Constructor
     * @param tipoDePersonal
     * @param nombre
     * @param apellido
     * @param listadoProyectos
     * @param usuario
     * @param contraseña*/
    
    public Personal (String tipoDePersonal, String nombre, String apellido,  ArrayList<Proyecto> listadoProyectos, String usuario, String contraseña){
        this.tipoDePersonal = tipoDePersonal; 
        this.nombre = nombre; 
        this.apellido = apellido; 
        this.listadoProyectos = listadoProyectos;
        this.usuario = usuario; 
        this.contraseña = contraseña; 
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
        return this.tipoDePersonal;
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
    
  /**Funcion para crear un arraylist de proyectos libres
     * @return proyectosLibres (arrayList de proyectos libres*/
    
    public ArrayList<Proyecto> proyectosLibres(){
        
        ArrayList<Proyecto> nuevaListaProyectos = this.getListadoProyectos();
        ArrayList<Proyecto> listaProyectosLibres = new ArrayList<Proyecto>();
        boolean isAssigned = true;
        
        for (int i = 0; i < nuevaListaProyectos.size(); i++){
            
            isAssigned = nuevaListaProyectos.get(i).isAssigned(); /*comprobamos cada objeto proyecto según método isAssigned*/
            
            if (isAssigned){
            }
            
            else {
                 listaProyectosLibres.add(nuevaListaProyectos.get(i)); /*guardamos cada proyecto sin asignar en el arraylist de proyectos libres creado*/
            }
            
        }
        
        return listaProyectosLibres;
        
    }
        
        

}
