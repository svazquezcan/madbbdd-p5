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
public class ONG {
    private String CIF; 
    private String direccion; 
    private int telefonoPersonal; 
    private ArrayList<Delegacion> delegaciones;
    private ArrayList<Proyecto> proyectos;
    
    /**Constructor
     * @param CIF
     * @param direccion
     * @param telefonoPersonal*/
    
    public ONG(String CIF, String direccion, int telefonoPersonal){
        this.CIF = CIF;
        this.direccion = direccion; 
        this.telefonoPersonal = telefonoPersonal; 
    }
     
}
