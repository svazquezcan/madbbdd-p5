/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto2;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sandra
 */
@XmlRootElement(name="contratado")
@XmlAccessorType (XmlAccessType.NONE)
public class Contratado extends Personal {
    
    @XmlElement(name="dni")
    private String DNI;
    @XmlElement(name="nºcontrato")
    private int nºContrato; 
    @XmlElement(name="costeSalario")
    private float costeSalario; 
    @XmlElement(name="funcion")
    private String funcion;
    
    /**Constructor
     * @param tipoDePersonal
     * @param nombre
     * @param apellido
     * @param listadoProyectos
     * @param usuario
     * @param contraseña
     * @param DNI
     * @param nºContrato
     * @param costeSalario
     * @param funcion
     * @param delegacion*/
    
    /*Constructor para crear contratado y asignarle un proyecto a la vez*/
    public Contratado(String tipoDePersonal, String nombre, String apellido, ArrayList<Proyecto> listadoProyectos, String usuario, String contraseña, String delegacion, String DNI, int nºContrato, float costeSalario, String funcion) {
        super(tipoDePersonal, nombre, apellido, listadoProyectos, usuario, contraseña, delegacion);
        this.DNI = DNI;
        this.nºContrato = nºContrato; 
        this.costeSalario = costeSalario; 
        this.funcion = funcion; 
    }
    
    /*Constructor para crear contratado sin asignarle un proyecto*/
     public Contratado(String tipoDePersonal, String nombre, String apellido, String usuario, String contraseña, String delegacion, String DNI, int nºContrato, float costeSalario, String funcion) {
        super(tipoDePersonal, nombre, apellido, usuario, contraseña, delegacion);
        this.DNI = DNI;
        this.nºContrato = nºContrato; 
        this.costeSalario = costeSalario; 
        this.funcion = funcion; 
    }
    
    /*Constructor sin args para JAXB*/
    public Contratado(){
    
    }
    
    /**Getter
     * @return DNI*/
    public String getDNI(){
        return this.DNI;
    }
    
     /**Getter
     * @return nºContrato*/
    public int getNºContrato(){
        return this.nºContrato;
    }
    
     /**Getter
     * @return costeSalario*/
    public float getCosteSalario(){
        return this.costeSalario;
    }
    
     /**Getter
     * @return funcion*/
    public String getFuncion(){
        return this.funcion;
    }
    
        /**Setter
     * @param DNI, para añadir/modificar el DNI de Contratado*/
    public void setDNI (String DNI){
        this.DNI = DNI; 
    } 
    
        /**Setter
     * @param nºContrato, para añadir/modificar el nºContrato de Contratado*/
    public void setNºContrato (int nºContrato){
        this.nºContrato = nºContrato; 
    } 
    
        /**Setter
     * @param costeSalario, para añadir/modificar el costeSalario de Contratado*/
    public void setCosteSalario (float costeSalario){
        this.costeSalario = costeSalario; 
    } 
    
        /**Setter
     * @param funcion, para añadir/modificar la funcion de Contratado*/
    public void setFuncion (String funcion){
        this.funcion = funcion; 
    } 
    
 
}
