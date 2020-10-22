package MadBBDD.producto2;

import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

@SpringBootApplication
public class Producto2Application {
    
	public static void main(String[] args) throws JAXBException{
		SpringApplication.run(Producto2Application.class, args);
                ONG miONG = new ONG("B858585P","Calle Palomas", 66666666); //creo objeto ONG para tener datos en XML además de los que se introduzcan por consola
                Delegacion delegacion1 = Delegacion.addDelegacion1(); //creo objeto delegeacion para testing (tener datos en el XML además de los que se introduzcan por consola)
                Delegacion delegacion2 = Delegacion.addDelegacion2(); //creo objeto delegeacion para testing (tener datos en el XML además de los que se introduzcan por consola)
                Delegacion delegacion3 = Delegacion.addDelegacion3(); //creo objeto delegeacion para testing (tener datos en el XML además de los que se introduzcan por consola)
                Proyecto proyectoPrueba = Proyecto.addProyecto(); //creo objeto proyecto para testing (tener datos en el XML además de los que se introduzcan por consola)
                Personal personaPrueba = Personal.addPersonal(); //creo objeto personal para testing (tener datos en el XML además de los que se introduzcan por consola)
                ArrayList<Personal> totalPersonal = miONG.getListaPersonal();
                ArrayList<Proyecto> totalProyectos = miONG.getProyectos();
                ArrayList<Delegacion> totalDelegaciones = miONG.getDelegaciones();
                totalProyectos.add(proyectoPrueba); //guardo objeto proyecto para testing
                totalPersonal.add(personaPrueba); //guardo objeto personal para testing
                totalDelegaciones.add(delegacion1); //guardo objeto delegacion para testing
                totalDelegaciones.add(delegacion2); //guardo objeto delegacion para testing
                totalDelegaciones.add(delegacion3); //guardo objeto delegacion para testing

                int opcion = 0; 
                opcion = Menu.OpcionMenu(); 
                while(opcion >= 1 && opcion <= 7){
            
            switch (opcion) {
                case 1:   
                    miONG.entrarDatosPersonal();
                    break;
                case 2:
                    miONG.entrarDatosDelegacion();
                    break;
                case 3:
                    
                    break;
                case 4: 
                    JAXBContext context1 = JAXBContext.newInstance(ONG.class);
                    Marshaller marshaller1 = context1.createMarshaller();
                    marshaller1.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                    marshaller1.marshal(miONG, System.out);
                    break; 
                case 5: 
                    
                    break;
                case 6: 

                    break; 
                case 7: 

                    break; 
                default:
                    System.out.print("Opción no válida. Vuelve a intentarlo e introduce una de las opciones indicadas. ");
                    break;
            }
        
            opcion = Menu.OpcionMenu();    
            
        }

    }
    
}
       
                
        
                

