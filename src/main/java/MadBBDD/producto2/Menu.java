/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Sandra
 */
public class Menu {
    
    /**
     *
     * @return opcionLeida
     */
    public static int OpcionMenu(){
            
    int opcionLeida = 0;

    Scanner leerOpcion = new Scanner (System.in);
    System.out.print("Introduce el numero indicado para realizar una de las siguientes opciones:\n " +
    "Numero 1. Introducir nuevo miembro del personal de la ONG.\n " +
    "Numero 2. Introducir nueva delegación.\n " +  
    "Numero 3. Introducir nuevo proyecto.\n " +
    "Numero 4. XML de la clase ONG.\n " +
    "Numero 5. XML de la clase Delegación.\n " +
    "Numero 6. XML de la clase Proyecto.\n " +
    "Numero 7. XML de la clase Personal.\n" +
    "Número 8. XML de la clase Voluntario.\n" +
    "Número 9. XML de la clase VoluntarioInternacional.\n" +
    "Numero 10. XML de la clase Contratado.\n" +
    "Numero 11. Testeo insertar clase VoluntarioInternacional.\n");
    try {
        
        opcionLeida = leerOpcion.nextInt();
        leerOpcion.nextLine();  //elimina salto de línea 
        
    }
    
    catch (InputMismatchException e){
        
        System.out.print("No has introducido una de las opciones indicadas. Vuelve a intentarlo\n");
        
    }
     
    
    return (opcionLeida);
    
    }
    
}
