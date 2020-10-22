/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto2;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sandra
 */
@XmlRootElement(name="proyecto")
@XmlAccessorType (XmlAccessType.FIELD)

public class Proyecto {
    
    private String pais; 
    private String localizacion; 
    private String lineaDeAccion; 
    private String sublineaDeAccion; 
    private LocalDate fechaDeInicio; 
    private LocalDate fechaDeFinalizacion;
    private String socioLocal; 
    private String financiador; 
    private float financiacionAportada;
    private float costeProyecto;
    private int codigoDeProyecto; 
    private String accionesARealizar; 
    private ArrayList<Personal> personalAsignado; 
    
    /**Constructor
     * @param pais
     * @param localizacion
     * @param lineaDeAccion
     * @param sublineaDeAccion
     * @param fechaDeInicio
     * @param fechaDeFinalizacion
     * @param socioLocal
     * @param financiador
     * @param financiacionAportada
     * @param codigoDeProyecto
     * @param accionesARealizar
     * @param costeProyecto
     */
    
    public Proyecto(String pais, String localizacion, String lineaDeAccion, String sublineaDeAccion, LocalDate fechaDeInicio, LocalDate fechaDeFinalizacion, String socioLocal, String financiador, float financiacionAportada, float costeProyecto, int codigoDeProyecto, String accionesARealizar){
        this.pais = pais; 
        this.localizacion = localizacion; 
        this.lineaDeAccion = lineaDeAccion; 
        this.sublineaDeAccion = sublineaDeAccion; 
        this.fechaDeInicio = fechaDeInicio; 
        this.fechaDeFinalizacion = fechaDeFinalizacion; 
        this.socioLocal = socioLocal; 
        this.financiador = financiador; 
        this.financiacionAportada = financiacionAportada; 
        this.codigoDeProyecto = codigoDeProyecto; 
        this.accionesARealizar = accionesARealizar; 
    }
    
    /*constructor sin argumentos*/
    public Proyecto(){ 
    }
    
    /**Getter
     * @return pais*/
    public String getPais(){
        return this.pais;
    }
    
        /**Getter
     * @return localizacion*/
    public String getLocalizacion(){
        return this.localizacion;
    }
    
        /**Getter
     * @return lineaDeAccion*/
    public String getLineaDeAccion(){
        return this.lineaDeAccion;
    }
    
        /**Getter
     * @return sublineaDeAccion*/
    public String getSublineaDeAccion(){
        return this.sublineaDeAccion;
    }
    
        /**Getter
     * @return fechaDeInicio*/
    public LocalDate getFechaDeInicio(){
        return this.fechaDeInicio;
    }
    
        /**Getter
     * @return fechaDeFinalizacion*/
    public LocalDate getFechaDeFinalizacion(){
        return this.fechaDeFinalizacion;
    }
    
        /**Getter
     * @return socioLocal*/
    public String getSocioLocal(){
        return this.socioLocal;
    }
    
        /**Getter
     * @return financiador*/
    public String getFinanciador(){
        return this.financiador;
    }
    
        /**Getter
     * @return financiacionAportada*/
    public float getFinanciacionAportada(){
        return this.financiacionAportada;
    }
    
     /**Getter
     * @return costeProyecto*/
    public float getCosteProyecto(){
        return this.costeProyecto;
    }
    
        /**Getter
     * @return codigoDeProyecto*/
    public int getCodigoDeProyecto(){
        return this.codigoDeProyecto;
    }
    
        /**Getter
     * @return accionesARealizar*/
    public String getAccionesARealizar(){
        return this.accionesARealizar;
    }
    
        /**Getter
     * @return personalAsignado*/
    public  ArrayList<Personal> getPersonalAsignado(){
        return this.personalAsignado;
    }
    
    /**Funcion para comprobar proyectos sin asignar
     * @return boolean*/
    
    public boolean isAssigned(){
        
        boolean isAssigned = true; 
        ArrayList<Personal> busyProjects = new ArrayList<Personal>(); 
        busyProjects = this.getPersonalAsignado();
             
         if (busyProjects == null){
            isAssigned = false; 
        }      
         
         else if (busyProjects.isEmpty()){
            isAssigned = false; 
         }
          
        return isAssigned;
            
    }    
    /*creo proyecto para testeo*/
    public static Proyecto addProyecto(){
            Proyecto proyecto1 = new Proyecto("España", "Madrid", "Acceso al agua potable", "Fuentes", LocalDate.parse("2020-12-12"), LocalDate.parse("2021-12-12"), "Carrefour", "Carrefour", 1000000, 200000, 01, "Potabilización");
            return(proyecto1);
        }    
  
    
    
}
