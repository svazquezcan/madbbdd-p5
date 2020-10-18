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
    "Numero 2. Introducir nuevo proyecto.\n " +  
    "Numero 3. Introducir nueva delegación.\n " +
    "Numero 4. Sacar un listado de miembros del personal de la ONG.\n " +
    "Numero 5. Sacar un listado de proyectos de la ONG.\n " +
    "Numero 6. Sacar un listado de delegaciones.\n ");
    try {
        
        opcionLeida = leerOpcion.nextInt();
        leerOpcion.nextLine();   
        
    }
    
    catch (InputMismatchException e){
        
        System.out.print("No has introducido una de las opciones indicadas. Vuelve a intentarlo\n");
        
    }
     
    
    return (opcionLeida);
    
    }
    
}
