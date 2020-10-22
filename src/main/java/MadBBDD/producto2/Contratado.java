/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto2;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sandra
 */
@XmlRootElement(name="contratado")
public class Contratado extends Personal {
    
    private String DNI;
    private int nºContrato; 
    private float costeSalario; 
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
    
    public Contratado(String tipoDePersonal, String nombre, String apellido, ArrayList<Proyecto> listadoProyectos, String usuario, String contraseña, String DNI, int nºContrato, float costeSalario, String funcion, String delegacion) {
        super(tipoDePersonal, nombre, apellido, listadoProyectos, usuario, contraseña, delegacion);
        this.DNI = DNI;
        this.nºContrato = nºContrato; 
        this.costeSalario = costeSalario; 
        this.funcion = funcion; 
    }
    
    
    /**Getter
     * @return DNI*/
    @XmlAttribute(name="dni")
    public String getDNI(){
        return this.DNI;
    }
    
     /**Getter
     * @return nºContrato*/
    @XmlAttribute(name="ncontrato")
    public int getNºContrato(){
        return this.nºContrato;
    }
    
     /**Getter
     * @return costeSalario*/
    @XmlAttribute(name="costesalario")
    public float getCosteSalario(){
        return this.costeSalario;
    }
    
     /**Getter
     * @return funcion*/
    @XmlAttribute(name="funcion")
    public String getFuncion(){
        return this.funcion;
    }
    
 
}
