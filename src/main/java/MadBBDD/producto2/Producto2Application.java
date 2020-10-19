package MadBBDD.producto2;

import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Producto2Application {
     
	public static void main(String[] args){
		SpringApplication.run(Producto2Application.class, args);
                ONG miONG = new ONG();
                int opcion = 0; 
                
                opcion = Menu.OpcionMenu();
                
                while(opcion >= 1 && opcion <= 6){
            
            switch (opcion) {
                case 1:   
                    miONG.entrarDatosPersonal();
                    break;
                default:
                    System.out.print("Opción no válida. Vuelve a intentarlo e introduce una de las opciones indicadas. ");
                    break;
            }
        
        opcion = Menu.OpcionMenu();    
            
        }

    }
    
}
       
                
        
                

