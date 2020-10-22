/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sandra
 */
@XmlRootElement(name="ONG")
@XmlAccessorType (XmlAccessType.FIELD)
public class ONG {
    private String CIF; 
    private String direccion; 
    private int telefono; 
    private ArrayList<Delegacion> delegaciones;
    private ArrayList<Proyecto> proyectos;
    private ArrayList<Personal> listaPersonal; 
    
    /**Creo objeto Scanner para poder leer input por teclado*/
    public static Scanner leerDatos = new Scanner(System.in);

    /**Constructo
     * @param CIF
     * @param direccion
     * @param telefono*/
    
    public ONG(String CIF, String direccion, int telefono){
        this.CIF = CIF;
        this.direccion = direccion; 
        this.telefono = telefono;     
        this.delegaciones = new ArrayList<Delegacion>(); 
        this.proyectos = new ArrayList<Proyecto>();
        this.listaPersonal = new ArrayList <Personal>(); 
        
    }
    
    /*Constructor sin argumentos para JABX*/
    public ONG(){
    }
    
     /**Getter
     * @return CIF*/
    public String getCIF(){
        return this.CIF;
    }
    
     /**Getter
     * @return direccion*/
    public String getDireccion(){
        return this.direccion;
    }
    
     /**Getter
     * @return telefono*/
    public int getTelefono(){
        return this.telefono;
    }
    
     /**Getter
     * @return delegaciones*/
    public ArrayList<Delegacion> getDelegaciones(){
        return this.delegaciones;
    }
    
     /**Getter
     * @return proyectos*/
    public ArrayList<Proyecto> getProyectos(){
        return this.proyectos;
    }
    
         /**Getter
     * @return listaPersonal*/
    public ArrayList<Personal> getListaPersonal(){
        return this.listaPersonal;
    }
    
     /**Setter
     * @param CIF, para añadir/modificar el CIF de la ONG*/
    public void setCIF(String CIF){
        this.CIF = CIF; 
    }
    
      /**Setter
     * @param direccion, para añadir/modificar la direccion de la ONG*/
    public void setDireccion(String direccion){
        this.direccion = direccion; 
    }
    
      /**Setter
     * @param telefono, para añadir/modificar el telefono de la ONG*/
    public void setTelefono (int telefono){
        this.telefono = telefono; 
    }
    
      /**Setter
     * @param delegaciones, para añadir/modificar lista de delegaciones de la ONG*/
    public void setDelegaciones(ArrayList<Delegacion> delegaciones){
        this.delegaciones = delegaciones; 
    }
    
      /**Setter
     * @param proyectos, para añadir/modificar lista de proyectos de la ONG*/
    public void setProyectos(ArrayList<Proyecto> proyectos){
        this.proyectos = proyectos; 
    }
    
       /**Setter
     * @param listaPersonal, para añadir/modificar lista de personal de la ONG*/
    public void setListaPersonal(ArrayList<Personal> listaPersonal){
        this.listaPersonal = listaPersonal; 
    }
 
     /**Funcion para crear un arraylist de proyectos libres
     * @return proyectosLibres (arrayList de proyectos libres*/
    
    public ArrayList<Proyecto> proyectosLibres(){
        
        ArrayList<Proyecto> nuevaListaProyectos = this.getProyectos();
        ArrayList<Proyecto> listaProyectosLibres = new ArrayList<Proyecto>();
        boolean isAssigned = true;
        
        for (int i = 0; i < nuevaListaProyectos.size(); i++){
            
            isAssigned = nuevaListaProyectos.get(i).isAssigned(); /*comprobamos cada objeto proyecto según método isAssigned*/
            
            if (isAssigned){
            }
            
            else {
                 listaProyectosLibres.add(nuevaListaProyectos.get(i)); /*guardamos cada proyecto sin asignar en el arraylist de proyectos libres creado*/
            }
            
        }
        
        return listaProyectosLibres;
        
    }
    
    /**Funcion para la entrada de datos por consola de un nuevo miembro del persona*/
    
    public void entrarDatosPersonal(){
        /**Declaracion variables para guardar datos de personal nuevo*/
        String tipoDePersonalDelNuevo;
        String nuevoNombre; 
        String nuevoApellido; 
        String nuevoUsuario; 
        String nuevaContraseña; 
        String nuevaDelegacion;
        
        
        /**Solicitud por consola del tipo de personal y lectura por teclado de tipoDePersonalDelNuevo*/
       System.out.print("Introduce el tipo de personal del nuevo miembro del personal: Voluntario, VoluntarioInternacional o Contratado: ");
       tipoDePersonalDelNuevo = leerDatos.nextLine();

       /**Comprobacion para que campo nombre no esté vacío*/
        while (tipoDePersonalDelNuevo.isEmpty()){

           System.out.print("El tipo de personal del nuevo miembro no puede ser un campo vacío. Introduce el tipo de personal del nuevo miembro del personal: ");
           tipoDePersonalDelNuevo = leerDatos.nextLine();

       }
        /**Comprobacion para que campo tipo de personal esté limitado a los tres tipos posibles y no se pueda introducir cualquier String*/

        while (!"Voluntario".equals(tipoDePersonalDelNuevo) && !"VoluntarioInternacional".equals(tipoDePersonalDelNuevo) && !"Contratado".equals(tipoDePersonalDelNuevo)){ /*comprobacion de campo para que solo se puedan introducir los tipos de habs que existen*/

            System.out.print("El tipo de personal indicado no es correcto. Por favor, vuelve a escribirlo:\n ");
            tipoDePersonalDelNuevo = leerDatos.nextLine(); 

        }

       /**Solicitud por consola del nombre de personal y lectura por teclado del nuevoNombre*/
       System.out.print("Introduce nombre del nuevo miembro del personal: ");
       nuevoNombre = leerDatos.nextLine();

       /**Comprobacion para que campo nombre no esté vacío*/
        while (nuevoNombre.isEmpty()){

           System.out.print("El nombre del nuevo miembro del personal no puede ser un campo vacío. Introduce el nombre del nuevo miembro del personal: ");
           nuevoNombre = leerDatos.nextLine();

       }

        /**Solicitud por consola del apellido de personal y lectura por teclado del nuevoApellido*/
       System.out.print("Introduce apellido del nuevo miembro del personal: ");
       nuevoApellido = leerDatos.nextLine();

       /**Comprobacion para que campo apellido no esté vacío*/
        while (nuevoApellido.isEmpty()){

           System.out.print("El apellido del nuevo miembro del personal no puede ser un campo vacío. Introduce el apellido del nuevo miembro del personal: ");
           nuevoApellido = leerDatos.nextLine();

       }

       /**Solicitud por consola del nuevo usuario de personal y lectura por teclado del nuevoUsuario*/
       System.out.print("Introduce usuario del nuevo miembro del personal: ");
       nuevoUsuario = leerDatos.nextLine();

       /**Comprobacion para que campo usuario no esté vacío*/
        while (nuevoUsuario.isEmpty()){

           System.out.print("El usuario del nuevo miembro del personal no puede ser un campo vacío. Introduce el usuario del nuevo miembro del personal: ");
           nuevoUsuario = leerDatos.nextLine();

       }  

       ArrayList<Personal> nuevaListaPersonal = this.getListaPersonal();/*usamos el getter de la clase ONG para conseguir listado de personal y almacenarlo en variable nuevaListaPersonal*/
       boolean newUser = true;

       for (int i = 0; i < nuevaListaPersonal.size(); i++){ /**hacemos un loop para recorrer los objetos personal del arraylist listado de personal de la ONG*/
          if (nuevaListaPersonal.get(i).getUsuario().equals(nuevoUsuario)){ /**comprobamos que el usuario no exista ya para no guardar un nuevo miembro de personal con el mismo user*/

              System.out.println("El usuario ya existe. No se puede crear un usuario con el mismo nombre. Por favor, vuelve a iniciar el registro de nuevo miembro de personal ");
              newUser = false;

           }
          
       }
       
       ArrayList<Proyecto> totalProyectos = this.getProyectos(); 

       if (totalProyectos.isEmpty()){

            System.out.println("No hay proyectos activos en la ONG en este momento, asi que no es posible registrar nuevo personal ");
        }
       
       else if (newUser){  /*como el usuario es nuevo, ahora pedimos que se guarden el resto de los datos de miembro de personal*/
           
           /**Solicitud por consola de contraseña y lectura por teclado de contraseña*/
           System.out.print("Introduce la contraseña del usuario del nuevo miembro del personal: ");
           nuevaContraseña = leerDatos.nextLine();
           
           /**Comprobacion para que campo contraseña no esté vacío*/
            while (nuevaContraseña.isEmpty()){

               System.out.print("La contraseña del nuevo usuario no puede ser un campo vacio. Introduce la contraseña del nuevo miembro del personal y usuario: ");
               nuevaContraseña = leerDatos.nextLine();

           }
           
            /**Solicitud por consola de la delegacion y lectura por teclado de la delegacion a la que pertenece el nuevo miembro*/
            System.out.print("Introduce al delegación a la que pertenece el nuevo miembro del personal: 'Entreculturas España', 'Entreculturas Portugal' o 'Entreculturas Francia' ");
            nuevaDelegacion = leerDatos.nextLine();

            /**Comprobacion para que campo delegación no esté vacío*/
            while (tipoDePersonalDelNuevo.isEmpty()){

               System.out.print("La delegación del nuevo miembro no puede ser un campo vacío. Introduce la delegación del nuevo miembro del personal: ");
               nuevaDelegacion = leerDatos.nextLine();

           }
            
            /**Comprobacion para que campo tipo de personal esté limitado a los tres tipos posibles y no se pueda introducir cualquier String*/

            while (!"Voluntario".equals(tipoDePersonalDelNuevo) && !"VoluntarioInternacional".equals(tipoDePersonalDelNuevo) && !"Contratado".equals(tipoDePersonalDelNuevo)){ /*comprobacion de campo para que solo se puedan introducir los tipos de habs que existen*/

                System.out.print("El tipo de personal indicado no es correcto. Por favor, vuelve a escribirlo:\n ");
                tipoDePersonalDelNuevo = leerDatos.nextLine(); 

            }
               ArrayList<Proyecto> proyectosSinAsignar = this.proyectosLibres(); /*ArrayList de proyectos libres*/
               Proyecto proyectoAsignado; /*Proyecto que se asignará*/
               ArrayList<Proyecto> proyectosDelNuevo = new ArrayList<Proyecto>(); /*ArrayList de proyectos del miembro del personal nuevo*/
               Personal nuevoPersonal = new Personal (nuevoNombre, nuevoApellido, tipoDePersonalDelNuevo, proyectosSinAsignar, nuevoUsuario, nuevaContraseña, nuevaDelegacion);            

               if (proyectosSinAsignar.isEmpty()){
                   Collections.shuffle(totalProyectos);
                   proyectoAsignado = totalProyectos.get(0);/*para asignación aleatoria, cojo el primer proyecto de entre todos los proyectos, ya que todos tienen miembros*/
                   proyectosDelNuevo.add(proyectoAsignado);
                   System.out.print("No hay proyectos sin personal asignado. El nuevo miembro de personal colaborará con otros miembros en el proyecto código " + proyectoAsignado.getCodigoDeProyecto());

               }

               else {
                   proyectoAsignado = proyectosSinAsignar.get(0);
                   proyectosDelNuevo.add(proyectoAsignado);
                   System.out.print("Hay proyectos que todavía no tienen personal. El nuevo miembro de personal se asigna al proyecto código " + proyectoAsignado.getCodigoDeProyecto());

               }  /*guardamos miembro de personal nuevo*/

                nuevoPersonal.setNombre(nuevoNombre);
                nuevoPersonal.setApellido(nuevoApellido);
                nuevoPersonal.setTipoDePersonal(tipoDePersonalDelNuevo);
                nuevoPersonal.setUsuario(nuevoUsuario);
                nuevoPersonal.setContraseña(nuevaContraseña);
                nuevoPersonal.setDelegacion(nuevaDelegacion);
                nuevoPersonal.setListadoProyectos(proyectosDelNuevo);
                nuevaListaPersonal.add(nuevoPersonal);
                System.out.print("Nuevo miembro de personal guardado correctamente "); 
       }
       
    }  
    
    
     public void entrarDatosDelegacion(){
        /**Declaracion variables**/
        String  newName_Delegacion; 
        String  newName_Direccion; 
        int newName_Telefono;
        boolean newDelegacion = true;
   
       /**Solicitud por consola del nombre de la delegacion y lectura por teclado de newName_Delegacion**/
       System.out.print("Introduce la nueva delegación a registrar: ");
       newName_Delegacion = leerDatos.nextLine();

       /**Comprobacion para que campo newName_Delegacion no esté vacío*/
        while (newName_Delegacion.isEmpty()){

           System.out.print("Para registrar una nueva delegación, este campo es totalmente obligatorio:");
           newName_Delegacion = leerDatos.nextLine();

       }

       /**Solicitud por consola de la Dirección y lectura por teclado denewName_Direccion**/
       System.out.print("Introduce la dirección de la Delegación que desee registrar: ");
       newName_Direccion = leerDatos.nextLine();

       /**Comprobacion para que campo newName_Direccion no esté vacío**/
        while (newName_Direccion.isEmpty()){

           System.out.print("Para registrar una nueva delegación, este campo es totalmente obligatorio:");
           newName_Direccion = leerDatos.nextLine();

       }

       /**Solicitud por consola del Telefono y lectura por teclado del newName_Telefono**/
       System.out.print("Introduce un número de telefono para poder contactar con usted: ");
       newName_Telefono = leerDatos.nextInt();
       leerDatos.nextLine();/*Consume salto de línea no leido por nextInt*/

  
       /**Comprobacion para que campo newName_Telefono no esté vacío
       
       while (newName_Telefono == "\n"){
	   System.out.print("Para registrar una nueva delegación, este campo es totalmente obligatorio:");
           newName_Telefono = leerDatos.nextInt();
       }
       21.09.2020 - NO DETECTA NULL */

       /** INICIO - Bloqueo de código de la verificación de las delegaciones, 
           en caso de que la Delegación sea existente, volverá a empezar de nuevo el formulario.
           En caso contrario, se añadirá la Delegación y volverá al menú inicial**/
       ArrayList<Delegacion> nuevaListaDelegaciones = this.getDelegaciones();

       for (int i = 0; i < nuevaListaDelegaciones.size(); i++){ /**hacemos un loop para recorrer los objetos personal del arraylist listado de personal de la ONG*/
          if (nuevaListaDelegaciones.get(i).getNombre().equals(newName_Delegacion)){ /**comprobamos que el usuario no exista ya para no guardar un nuevo miembro de personal con el mismo user*/

              System.out.println("Esta Delegación ya existe. No se puede crear un con el mismo nombre. Por favor, vuelve formular la nueva Delegacion correctamente");
              newDelegacion = false;
           }
            else{
              
            }
       }
       
       if (newDelegacion) {
        Delegacion nuevaDelegacion = new Delegacion (newName_Delegacion, newName_Direccion, newName_Telefono); 
        nuevaDelegacion.setNombre(newName_Delegacion);
        nuevaDelegacion.setDireccion(newName_Direccion);
        nuevaDelegacion.setTelefono(newName_Telefono);
        nuevaListaDelegaciones.add(nuevaDelegacion);
        System.out.print("Nueva Delegacion guardada correctamente ");   
       }

       /** FINAL - Bloqueo de código de la verificación de las delegaciones**/
    }
    
}
