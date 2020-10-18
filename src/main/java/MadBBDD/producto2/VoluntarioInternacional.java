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
public class VoluntarioInternacional extends Personal {
    private String NIE; 
    private int codigoDeVoluntario; 

    public VoluntarioInternacional(String tipoDePersonal, String nombre, String apellido, ArrayList<Proyecto> listadoProyectos, String usuario, String contraseña, String NIE, int codigoDeVoluntario) {
        super(tipoDePersonal, nombre, apellido, listadoProyectos, usuario, contraseña);
        this.NIE = NIE; 
        this.codigoDeVoluntario = codigoDeVoluntario;        
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
    
}
