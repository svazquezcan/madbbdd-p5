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
public class Personal {
    private String tipoDePersonal;
    private String nombre; 
    private String apellido; 
    private Proyecto personalProyecto;  
    private String usuario; 
    private String contraseña; 
    
    
    /**Constructor
     * @param tipoDePersonal
     * @param nombre
     * @param apellido
     * @param personalProyecto
     * @param usuario
     * @param contraseña*/
    
    public Personal (String tipoDePersonal, String nombre, String apellido, Proyecto personalProyecto, String usuario, String contraseña){
        this.tipoDePersonal = tipoDePersonal; 
        this.nombre = nombre; 
        this.apellido = apellido; 
        this.personalProyecto = personalProyecto;
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
   
    public Proyecto getProyecto(){
        return this.personalProyecto;
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
}
