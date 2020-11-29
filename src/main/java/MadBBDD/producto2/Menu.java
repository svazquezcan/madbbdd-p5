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
     /*Opciones producto 2: persistencia XML*/
    "Numero 4. XML de la clase ONG.\n " +
    "Numero 5. XML de la clase Delegación.\n " +
    "Numero 6. XML de la clase Proyecto.\n " +
    "Numero 7. XML de la clase Personal.\n" +
    "Número 8. XML de la clase Voluntario.\n" +
    "Número 9. XML de la clase VoluntarioInternacional.\n" +
    "Numero 10. XML de la clase Contratado.\n" +
     /*Opciones producto 3: persistencia BBDD*/
    "Numero 11. Guardar el personal que se introduce por consola en BBDD.\n" +
    "Numero 12. Volcar los datos del XML de Personal en la BBDD.\n" +
    "Numero 13. Eliminar personal de la BBDD.\n" +
    "Numero 14. Obtener todo el personal de la BBDD.\n" +
    "Numero 15. Modificar personal en la BBDD.\n") ;

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
