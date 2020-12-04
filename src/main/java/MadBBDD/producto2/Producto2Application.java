package MadBBDD.producto2;

import MadBBDD.producto2.DAO.DAOFactory;
import MadBBDD.producto2.SQL.SQLDelegacionDAO;
import MadBBDD.producto2.SQL.SQLPersonalDAO;
import MadBBDD.producto2.XML.XmlContratadoDAO;
import MadBBDD.producto2.XML.XmlDelegacionDAO;
import MadBBDD.producto2.XML.XmlONGDAO;
import MadBBDD.producto2.XML.XmlPersonalDAO;
import MadBBDD.producto2.XML.XmlProyectoDAO;
import MadBBDD.producto2.XML.XmlVoluntarioDAO;
import MadBBDD.producto2.XML.XmlVoluntarioInternacionalDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.xml.bind.JAXBException;

@SpringBootApplication
public class Producto2Application {
    
    public static void main(String[] args) throws JAXBException, IOException, SQLException{

        MadBBDD.producto2.SQL.SQLPersonalDAO personalDAO = new MadBBDD.producto2.SQL.SQLPersonalDAO();
        int num = personalDAO.lastCodigoDePersonal();
        Personal.inicializarAutoincrement(num+1);
        
        MadBBDD.producto2.SQL.SQLDelegacionDAO delegacionDAO = new MadBBDD.producto2.SQL.SQLDelegacionDAO();
        int id = delegacionDAO.lastIdDelegacion(); 
        Delegacion.inicializarAutoincrement(id+1);
        
        SpringApplication.run(Producto2Application.class, args);
        ONG miONG = new ONG("A12345678","Calle Palomas", "66666666"); //creo objeto ONG para tener datos en XML además de los que se introduzcan por consola
        Proyecto proyecto1 = new Proyecto("España", "Madrid", "Acceso al agua potable", "Fuentes", LocalDate.parse("2020-12-12"), LocalDate.parse("2021-12-12"), "Carrefour", "Carrefour", 1000000, 200000, "Potabilización"); //creo objeto proyecto para testing (tener datos en el XML además de los que se introduzcan por consola
        Delegacion delegacion1 = new Delegacion("Entreculturas Portugal", "Calle ok", "78787777", "A12345678");
        Delegacion delegacion2 = new Delegacion("Entreculturas Polonia", "Calle lol", "89852632", "A12345678");
        Delegacion delegacion3 = new Delegacion("Entreculturas Francia", "Calle bien", "85916486", "A12345678");
        Voluntario voluntario1 = new Voluntario("Voluntario", "Paco", "Perez", "pacoPerez", "12345", "Entreculturas Polonia","5555555P");//creo objeto voluntario para testing (tener datos en el XML además de los que se introduzcan por consola)
        VoluntarioInternacional voluntarioInternacional1 = new VoluntarioInternacional("VoluntarioInternacional","John","Dow","johndow","john","Entreculturas Francia", "5555552");//creo objeto voluntarioInternacional para testing (tener datos en el XML además de los que se introduzcan por consola)
        VoluntarioInternacional voluntarioInternacional2 = new VoluntarioInternacional("VoluntarioInternacional", "Madeline", "Miau", "miau", "miau", "Entreculturas Portugal", "5555554");//creo objeto voluntarioInternacional para testing (tener datos en el XML además de los que se introduzcan por consola)
        Contratado contratado1 = new Contratado("Contratado", "Megan", "Fox", "meganFox", "88984263", "Entreculturas Portugal", "885966Y", 1999.35f, "hacer fotocopias"); //creo objeto contratado para testing (tener datos en el XML además de los que se introduzcan por consola)
        ArrayList<Personal> totalPersonal = miONG.getListaPersonal();
        ArrayList<Proyecto> totalProyectos = miONG.getProyectos();
        ArrayList<Delegacion> totalDelegaciones = miONG.getDelegaciones();
        ArrayList<Voluntario> totalVoluntarios = miONG.getListaVoluntarios();
        ArrayList<VoluntarioInternacional> totalVoluntariosInternacionales = miONG.getListaVoluntariosInternacionales();
        ArrayList<Contratado> totalContratados = miONG.getListaContratados();
        totalProyectos.add(proyecto1); //guardo objeto proyecto para testing
        totalDelegaciones.add(delegacion1);
        totalDelegaciones.add(delegacion2);
        totalDelegaciones.add(delegacion3);
        totalPersonal.add(voluntario1);
        totalVoluntarios.add(voluntario1); // guardo objeto voluntario para testing
        totalVoluntariosInternacionales.add(voluntarioInternacional1); //guardo objeto voluntarioInternacional para testing
        totalVoluntariosInternacionales.add(voluntarioInternacional2); //guardo objeto voluntarioInternacional para testing
        totalPersonal.add(voluntarioInternacional1);
        totalPersonal.add(voluntarioInternacional2);
        totalPersonal.add(contratado1);
        totalContratados.add(contratado1); //guardo objeto contratado para testing
        PersonalList miPersonalList = new PersonalList(); //creo objeto que pasaremos al marshaller
        miPersonalList.setPersonal(totalPersonal); //relleno objeto con la info de miONG
        Proyectos listadoProyectos = new Proyectos(); //creo objeto que pasaremos al marshaller
        listadoProyectos.setProyectos(totalProyectos); //relleno objeto con la info de miONG
        Delegaciones listadoDelegaciones = new Delegaciones(); //creo objeto que pasaremos al marshaller
        listadoDelegaciones.setDelegaciones(totalDelegaciones);//relleno objeto con la info de miONG
        ArrayList<Voluntario> voluntarios = miONG.getListaVoluntarios(); //relleno arraylist con la info de miONG
        Voluntarios listadoVoluntarios = new Voluntarios(); //creo objeto que pasaremos al marshaller
        listadoVoluntarios.setVoluntarios(voluntarios); //relleno objeto con la info de miONG
        ArrayList<VoluntarioInternacional> voluntariosInternacionales = miONG.getListaVoluntariosInternacionales(); //relleno arraylist con la info de miONG
        VoluntariosInternacionales listadoVoluntariosInternacionales = new VoluntariosInternacionales(); //creo objeto que pasaremos al marshaller
        listadoVoluntariosInternacionales.setVoluntarios(voluntariosInternacionales); //relleno objeto con la info de miONG
        ArrayList<Contratado> contratados = miONG.getListaContratados();//relleno arraylist con la info de miONG
        Contratados listadoContratados = new Contratados(); //creo objeto que pasaremos al marshaller
        listadoContratados.setContratados(contratados);//relleno objeto con la info de miONG
        ArrayList<ONG> misONGs = new ArrayList<>(); 
        misONGs.add(miONG);
        ONGs ONGs = new ONGs(); 
        ONGs.setONGs(misONGs);

        DAOFactory DAOFactoryImpl = DAOFactory.getDAOFactory();
        int opcion = 0; 
        opcion = Menu.OpcionMenu(); 
        while(opcion >= 0 && opcion <= 20){

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
                    XmlONGDAO ONGDAO = DAOFactoryImpl.getONGsDAO();
                    ONGDAO.obtenerTodos(ONGs);
                    break; 
                case 5: 
                    XmlDelegacionDAO DelegacionDAO = DAOFactoryImpl.getDelegacionesDAO();                    
                    DelegacionDAO.obtenerTodos(listadoDelegaciones);
                    break;
                case 6: 
                    XmlProyectoDAO ProyectoDAO = DAOFactoryImpl.getProyectosDAO();                    
                    ProyectoDAO.obtenerTodos(listadoProyectos);
                    break; 
                case 7: 
                    XmlPersonalDAO PersonalDAO = DAOFactoryImpl.getPersonalDAO();                    
                    PersonalDAO.obtenerTodos(miPersonalList);
                    break; 
                case 8: 
                    XmlVoluntarioDAO VoluntarioDAO = DAOFactoryImpl.getVoluntariosDAO();
                    VoluntarioDAO.obtenerTodos(listadoVoluntarios);
                    break;
                case 9: 
                    XmlVoluntarioInternacionalDAO VoluntarioInternacionalDAO = DAOFactoryImpl.getVoluntariosInternacionalesDAO();
                    VoluntarioInternacionalDAO.obtenerTodos(listadoVoluntariosInternacionales);
                    break;
                case 10: 
                    XmlContratadoDAO ContratadoDAO = DAOFactoryImpl.getContratadosDAO();
                    ContratadoDAO.obtenerTodos(listadoContratados);
                    break;
                case 11: //producto 3. Opción para guardar el personal que se introduce por consola en BBDD
                    SQLPersonalDAO SQLPersonalDAO = DAOFactoryImpl.getPersonalDAOSQL();
                    SQLPersonalDAO.insertar(miPersonalList);
                    SQLPersonalDAO.insertarVoluntario(totalVoluntarios);
                    SQLPersonalDAO.insertarVoluntarioInternacional(totalVoluntariosInternacionales);
                    SQLPersonalDAO.insertarContratado(totalContratados);
                    break;
                case 12: //producto 3. Opción para volcar los datos del XML de Personal y sus subclases en la BBDD
                    SQLPersonalDAO SQLPersonalDAOXML = DAOFactoryImpl.getPersonalDAOSQL();
                    SQLPersonalDAOXML.volcarDatosXML(miPersonalList);
                    break;
                case 13: // producto 3. Opción para eliminar personal de la BBDD
                    int codigoDePersonalAEliminar = miONG.codigoDePersonalAEliminar();
                    SQLPersonalDAO SQLPersonalDAOSQLAEliminar = DAOFactoryImpl.getPersonalDAOSQL();
                    SQLPersonalDAOSQLAEliminar.eliminar(codigoDePersonalAEliminar);
                    break;   
                case 14: //producto 3. Opción para obtener todo el personal de la BBDD
                    SQLPersonalDAO totalSQLPersonalDAO = DAOFactoryImpl.getPersonalDAOSQL();
                    totalSQLPersonalDAO.obtenerTodos(miPersonalList);
                    break;
                case 15: //producto 3. Opción para modificar personal en la BBDD
                    int codigoDePersonalAModificar = miONG.codigoDePersonalAEliminar();
                    SQLPersonalDAO SQLPersonalDAOSQLAModificar = DAOFactoryImpl.getPersonalDAOSQL();
                    String atributoAModificar = miONG.atributoDePersonalAModificar(); 
                    String atributoNuevo = miONG.atributoModicado(atributoAModificar);
                    SQLPersonalDAOSQLAModificar.modificar(atributoAModificar, atributoNuevo, codigoDePersonalAModificar);
                    break;
                case 16: //producto 3. Opción para guardar las delegaciones que se introduzcan por consola en la BBDD
                    SQLDelegacionDAO SQLDelegacionDAO = DAOFactoryImpl.getDelegacionesDAOSQL();
                    SQLDelegacionDAO.insertar(listadoDelegaciones);
                    break;
                case 17:  //producto 3. Opción para volcar los datos del XML de Delegacion en la BBDD
                    SQLDelegacionDAO SQLDelegacionDAOXML = DAOFactoryImpl.getDelegacionesDAOSQL();
                    SQLDelegacionDAOXML.volcarDatosXML(listadoDelegaciones);
                    break;
                case 18:  //producto 3. Opción para eliminar delegaciones de la BBDD
                    int idDeDelegacionAEliminar = miONG.idDeDelegacionAEliminar();
                    SQLDelegacionDAO SQLDelegacionAEliminarDAOXML = DAOFactoryImpl.getDelegacionesDAOSQL();
                    SQLDelegacionAEliminarDAOXML.eliminar(idDeDelegacionAEliminar);
                    break;
                case 19:  //producto 3. Opción para modificar delegaciones en la BBDD
                    int idDeDelegacionAModificar = miONG.idDeDelegacionAEliminar();
                    SQLDelegacionDAO SQLDelegacionAModificarDAOXML = DAOFactoryImpl.getDelegacionesDAOSQL();
                    String atributoViejo = miONG.atributoDeDelegacionAModificar(); 
                    String atributoModificado = miONG.atributoModicado(atributoViejo);
                    SQLDelegacionAModificarDAOXML.modificar(atributoViejo, atributoModificado, idDeDelegacionAModificar);
                    break;
                case 20: //producto 3. Opción para obtener todas las delegaciones de la BBDD
                    SQLDelegacionDAO totalSQLDelegacionDAO = DAOFactoryImpl.getDelegacionesDAOSQL();
                    totalSQLDelegacionDAO.obtenerTodos(listadoDelegaciones);
                    break;
                default:
                    break;
            }

            opcion = Menu.OpcionMenu();    

        }

    }
    
}
       
                
        
                

