package MadBBDD.producto2;

import MadBBDD.producto2.DAO.DAOFactory;
import MadBBDD.producto2.XML.XmlContratadoDAO;
import MadBBDD.producto2.XML.XmlDelegacionDAO;
import MadBBDD.producto2.XML.XmlONGDAO;
import MadBBDD.producto2.XML.XmlPersonalDAO;
import MadBBDD.producto2.XML.XmlProyectoDAO;
import MadBBDD.producto2.XML.XmlVoluntarioDAO;
import MadBBDD.producto2.XML.XmlVoluntarioInternacionalDAO;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.xml.bind.JAXBException;

@SpringBootApplication
public class Producto2Application {
    
	public static void main(String[] args) throws JAXBException, IOException{
		SpringApplication.run(Producto2Application.class, args);
                ONG miONG = new ONG("B858585P","Calle Palomas", 66666666); //creo objeto ONG para tener datos en XML además de los que se introduzcan por consola
                Delegacion delegacion1 = new Delegacion("Entreculturas España", "Calle Ok", "555555"); //creo objeto delegeacion para testing (tener datos en el XML además de los que se introduzcan por consola)
                Delegacion delegacion2 = new Delegacion("Entreculturas Francia", "Calle Calle", "444444"); //creo objeto delegeacion para testing (tener datos en el XML además de los que se introduzcan por consola)
                Delegacion delegacion3 = new Delegacion("Entreculturas Portugal", "Calle Bien", "777777"); //creo objeto delegeacion para testing (tener datos en el XML además de los que se introduzcan por consola)
                Proyecto proyecto1 = new Proyecto("España", "Madrid", "Acceso al agua potable", "Fuentes", LocalDate.parse("2020-12-12"), LocalDate.parse("2021-12-12"), "Carrefour", "Carrefour", 1000000, 200000, 1, "Potabilización"); //creo objeto proyecto para testing (tener datos en el XML además de los que se introduzcan por consola)
                Personal persona11 = new Personal("Voluntario", "Paco", "Pérez", "pacoPerez", "12345", "Entreculturas España"); //creo objeto personal para testing (tener datos en el XML además de los que se introduzcan por consola)
                Personal personal2 = new Personal("VoluntarioInternacional", "John", "Dow", "johnDow", "2563", "Entreculturas Francia");//creo objeto personal para testing (tener datos en el XML además de los que se introduzcan por consola)
                Personal personal3 = new Personal("Contratado", "Megan", "Fox", "meganFox", "88984263", "Entreculturas Portugal");//creo objeto personal para testing (tener datos en el XML además de los que se introduzcan por consola)
                Voluntario voluntario1 = new Voluntario("Voluntario", "Paco", "Pérez", "pacoPerez", "12345", "Entreculturas España","5555555P", 5);//creo objeto voluntario para testing (tener datos en el XML además de los que se introduzcan por consola)
                VoluntarioInternacional voluntarioInternacional1 = new VoluntarioInternacional("VoluntarioInternacional", "John", "Dow", "johnDow", "2563", "Entreculturas Francia","58fs65", 7);//creo objeto voluntarioInternacional para testing (tener datos en el XML además de los que se introduzcan por consola)
                Contratado contratado1 = new Contratado("Contratado", "Megan", "Fox", "meganFox", "88984263", "Entreculturas Portugal", "885966Y", 7, 1999.35f, "hacer fotocopias"); //creo objeto contratado para testing (tener datos en el XML además de los que se introduzcan por consola)
                ArrayList<Personal> totalPersonal = miONG.getListaPersonal();
                ArrayList<Proyecto> totalProyectos = miONG.getProyectos();
                ArrayList<Delegacion> totalDelegaciones = miONG.getDelegaciones();
                ArrayList<Voluntario> totalVoluntarios = miONG.getListaVoluntarios();
                ArrayList<VoluntarioInternacional> totalVoluntariosInternacionales = miONG.getListaVoluntariosInternacionales();
                ArrayList<Contratado> totalContratados = miONG.getListaContratados();
                totalProyectos.add(proyecto1); //guardo objeto proyecto para testing
                totalPersonal.add(persona11); //guardo objeto personal para testing
                totalPersonal.add(personal2); //guardo objeto personal para testing
                totalPersonal.add(personal3); //guardo objeto personal para testing
                totalDelegaciones.add(delegacion1); //guardo objeto delegacion para testing
                totalDelegaciones.add(delegacion2); //guardo objeto delegacion para testing
                totalDelegaciones.add(delegacion3); //guardo objeto delegacion para testing
                totalVoluntarios.add(voluntario1); // guardo objeto voluntario para testing
                totalVoluntariosInternacionales.add(voluntarioInternacional1); //guardo objeto voluntarioInternacional para testing
                totalContratados.add(contratado1); //guardo objeto contratado para testing
                PersonalList miPersonalList = new PersonalList(); //creo objeto que pasaremos al marshaller
                miPersonalList.setPersonal(totalPersonal); //relleno objeto con la info de miONG
                Proyectos listadoProyectos = new Proyectos(); //creo objeto que pasaremos al marshaller
                listadoProyectos.setProyectos(totalProyectos); //relleno objeto con la info de miONG
                Delegaciones listadoDelegaciones = new Delegaciones(); //creo objeto que pasaremos al marshaller
                listadoDelegaciones.setDelegaciones(totalDelegaciones); //relleno objeto con la info de miONG
                ArrayList<Voluntario> voluntarios = miONG.getListaVoluntarios(); //relleno arraylist con la info de miONG
                Voluntarios listadoVoluntarios = new Voluntarios(); //creo objeto que pasaremos al marshaller
                listadoVoluntarios.setVoluntarios(voluntarios); //relleno objeto con la info de miONG
                ArrayList<VoluntarioInternacional> voluntariosInternacionales = miONG.getListaVoluntariosInternacionales(); //relleno arraylist con la info de miONG
                VoluntariosInternacionales listadoVoluntariosInternacionales = new VoluntariosInternacionales(); //creo objeto que pasaremos al marshaller
                listadoVoluntariosInternacionales.setVoluntarios(voluntariosInternacionales); //relleno objeto con la info de miONG
                ArrayList<Contratado> contratados = miONG.getListaContratados();//relleno arraylist con la info de miONG
                Contratados listadoContratados = new Contratados(); //creo objeto que pasaremos al marshaller
                listadoContratados.setContratados(contratados);//relleno objeto con la info de miONG
                ArrayList<ONG> misONGs = new ArrayList<ONG>(); 
                misONGs.add(miONG);
                ONGs ONGs = new ONGs(); 
                ONGs.setONGs(misONGs);
                                
                DAOFactory XmlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.XML);
                int opcion = 0; 
                opcion = Menu.OpcionMenu(); 
                while(opcion >= 1 && opcion <= 10){
            
            switch (opcion) {
                case 1:   
                    miONG.entrarDatosPersonal();
                    break;
                case 2:
                    miONG.entrarDatosDelegacion();
                    break;
                case 3:
                    miONG.entrarDatosProyecto();
                    break;
                case 4: 
                    XmlONGDAO ONGDAO = XmlDAOFactory.getONGsDAO();
                    ONGDAO.obtenerTodos(ONGs);
                    break; 
                case 5: 
                    XmlDelegacionDAO DelegacionDAO = XmlDAOFactory.getDelegacionesDAO();                    
                    DelegacionDAO.obtenerTodos(listadoDelegaciones);
                    break;
                case 6: 
                    XmlProyectoDAO ProyectoDAO = XmlDAOFactory.getProyectosDAO();                    
                    ProyectoDAO.obtenerTodos(listadoProyectos);
                    break; 
                case 7: 
                    XmlPersonalDAO PersonalDAO = XmlDAOFactory.getPersonalDAO();                    
                    PersonalDAO.obtenerTodos(miPersonalList);
                    break; 
                case 8: 
                    XmlVoluntarioDAO VoluntarioDAO = XmlDAOFactory.getVoluntariosDAO();
                    VoluntarioDAO.obtenerTodos(listadoVoluntarios);
                    break;
                case 9: 
                    XmlVoluntarioInternacionalDAO VoluntarioInternacionalDAO = XmlDAOFactory.getVoluntariosInternacionalesDAO();
                    VoluntarioInternacionalDAO.obtenerTodos(listadoVoluntariosInternacionales);
                    break;
                case 10: 
                    XmlContratadoDAO ContratadoDAO = XmlDAOFactory.getContratadosDAO();
                    ContratadoDAO.obtenerTodos(listadoContratados);
                    break;
                default:
                    System.out.print("Opción no válida. Vuelve a intentarlo e introduce una de las opciones indicadas. ");
                    break;
            }
        
            opcion = Menu.OpcionMenu();    
            
        }

    }
    
}
       
                
        
                

