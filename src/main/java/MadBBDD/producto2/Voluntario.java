/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto2;

/**
 *
 * @author Sandra
 */
public class Voluntario extends Personal {
    
    private String DNI; 
    private int codigoDeVoluntario; 

    public Voluntario(String tipoDePersonal, String nombre, String apellido, Proyecto personalProyecto, String usuario, String contraseña, String DNI, int codigoDeVoluntario) {
        super(tipoDePersonal, nombre, apellido, personalProyecto, usuario, contraseña);
        this.DNI = DNI; 
        this.codigoDeVoluntario = codigoDeVoluntario; 
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
    
   
}
