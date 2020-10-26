/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto2.DAO;

import java.io.IOException;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Sandra
 * @param <T>
 * @param <U>
 * @param <K>
 */
public interface CRUD<T,U,K> { /*T = clase que guardamos en el sistema ¡, U = otra clase que guardamos en el sistema y K = tipo de datos de la clave primaria*/
    void insertar(T a);
    void modificar(T a);
    void eliminar(T a); 
    void obtenerTodos(U a) throws JAXBException, IOException; 
    T obtener(K String);
}   