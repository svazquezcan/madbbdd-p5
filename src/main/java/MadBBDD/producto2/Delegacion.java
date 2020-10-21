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
    public int getTelefono(){
        return this.telefono;
    }
}
