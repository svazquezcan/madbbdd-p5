/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto2;

import java.time.LocalDate;
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
    public void entrarDatosProyecto(){
        /**Declaracion variables para guardar datos de proyecto nuevo*/
    private String nuevoPais; 
    private String nuevaLocalizacion; 
    private String nuevaLineaDeAccion; 
    private String nuevaSublineaDeAccion; 
    private LocalDate nuevaFechaDeInicio; 
    private LocalDate nuevaFechaDeFinalizacion;
    private String nuevoSocioLocal; 
    private String nuevoFinanciador; 
    private float nuevaFinanciacionAportada;
    private float nuevoCosteProyecto;
    private int nuevoCodigoDeProyecto; 
    private String nuevasAccionesARealizar; 
        
        
        /**Solicitud por consola del pa�s de Proyecto y lectura por teclado de nuevoPais*/
       System.out.print("Introduce el pa�s del proyecto: ");
       nuevoPais = leerDatos.nextLine();

       /**Comprobacion para que campo pa�s no est� vac�o*/
        while (nuevoPais.isEmpty()){

           System.out.print("El campo pa�s no puede quedar vac�o, introduce el pa�s del Proyecto: ");
           nuevoPais = leerDatos.nextLine();

       }

       /**Solicitud por consola de la l�nea de localizaci�n y lectura por teclado de nuevaLocalizacion*/
       System.out.print("Introduce nombre de la nueva localizaci�n: ");
       nuevaLocalizacion = leerDatos.nextLine();

       /**Comprobacion para que campo localizaci�n no est� vac�o*/
        while (nuevaLocalizacion.isEmpty()){

           System.out.print("El nombre de localizaci�n no puede quedar vac�o. Introduce el nombre de la localizaci�n: ");
           nuevaLocalizacion = leerDatos.nextLine();

       }

        /**Solicitud por consola de la l�nea de acci�n del proyecto y lectura por teclado de nuevaLineaDeAccion*/
       System.out.print("Introduce la l�nea de acci�n: ");
       nuevaLineaDeAccion = leerDatos.nextLine();

       /**Comprobacion para que campo apellido no est� vac�o*/
        while (nuevaLineaDeAccion.isEmpty()){

           System.out.print("La l�nea de acci�n no puede ser un campo vac�o. Introduce la l�nea de acci�n: ");
           nuevaLineaDeAccion = leerDatos.nextLine();

       }

       /**Solicitud por consola la subl�nea y lectura por teclado de nuevaSublineaDeAccion*/
       System.out.print("Introduce la subl�nea de acci�n: ");
       nuevaSublineaDeAccion = leerDatos.nextLine();

       /**Comprobacion para que campo subl�nea de acci�n no est� vac�o*/
        while (nuevaSublineaDeAccion.isEmpty()){

           System.out.print("La subl�nea de acci�n no puede quedar vac�a. Introduce la subl�nea de acci�n: ");
           nuevaSublineaDeAccion = leerDatos.nextLine();

       }  
        
        /**Solicitud por consola de la fecha de inicio y lectura por teclado de fechaDeInicio*/
       System.out.print("Introduce la fecha de inicio del proyecto: ");
       nuevaFechaDeInicio = leerDatos.nextLine();

       /**Comprobacion para que campo fecha de inicio no est� vac�o*/
        while (nuevaFechaDeInicio.isEmpty()){

           System.out.print("La fecha de inicio no puede quedar vac�a, introduce la fecha de inicio del Proyecto: ");
           nuevaFechaDeInicio = leerDatos.nextLine();

       }

       /**Solicitud por consola de la fecha de finalizaci�n y lectura por teclado de nuevaFechaDeFinalizacion*/
       System.out.print("Introduce fecha de finalizaci�n: ");
       nuevaFechaDeFinalizacion = leerDatos.nextLine();

       /**Comprobacion para que campo fecha de finalizaci�n no est� vac�o*/
        while (nuevaFechaDeFinalizacion.isEmpty()){

           System.out.print("La fecha de finalizaci�n no puede quedar vac�a. Introduce la fecha de finalizaci�n: ");
           nuevaFechaDeFinalizacion = leerDatos.nextLine();

       }

        /**Solicitud por consola de socio local y lectura por teclado de nuevoSocioLocal*/
       System.out.print("Introduce el socio local: ");
       nuevoSocioLocal = leerDatos.nextLine();

       /**Comprobacion para que campo socio local no est� vac�o*/
        while (nuevoSocioLocal.isEmpty()){

           System.out.print("Socio local no puede ser un campo vac�o. Introduce el socio local: ");
           nuevoSocioLocal = leerDatos.nextLine();

       }

       /**Solicitud por consola del financiador y lectura por teclado de nuevoFinanciador*/
       System.out.print("Introduce el financiador: ");
       nuevoFinanciador = leerDatos.nextLine();

       /**Comprobacion para que campo financiador no est� vac�o*/
        while (nuevoFinanciador.isEmpty()){

           System.out.print("El financiador no puede quedar vac�o. Introduce el financiador: ");
           nuevoFinanciador = leerDatos.nextLine();

       }
        
        /**Solicitud por consola de la financiaci�n aportada y lectura por teclado de nuevaFinanciacionAportada*/
       System.out.print("Introduce la financiaci�n: ");
       nuevaFinanciacionAportada = leerDatos.nextFloat();

       /**Comprobacion para que campo financiaci�n aportada no est� vac�a*/
        while (nuevaFinanciacionAportada.isEmpty()){

           System.out.print("La financiaci�n aportada no puede quedar vac�a. Introduce un importe: ");
           nuevaFinanciacionAportada = leerDatos.nextFloat();

       }  
        
        /**Solicitud por consola del coste del proyecto y lectura por teclado de nuevoCosteProyecto*/
       System.out.print("Introduce el coste del proyecto: ");
       nuevoCosteProyecto = leerDatos.nextFloat();

       /**Comprobacion para que campo coste del proyecto no est� vac�o*/
        while (nuevoCosteProyecto.isEmpty()){

           System.out.print("El coste del proyecto no puede quedar vac�o. Introduce un importe: ");
           nuevoCosteProyecto = leerDatos.nextFloat();

       }  
        
        /**Solicitud por consola del c�digo del proyecto y lectura por teclado de nuevoCodigoDeProyecto*/
       System.out.print("Introduce el c�digo del proyecto: ");
       nuevoCodigoDeProyecto = leerDatos.nextInt();

       /**Comprobacion para que campo c�digo de proyecto no est� vac�o*/
        while (nuevoCodigoDeProyecto.isEmpty()){

           System.out.print("El c�digo del proyecto no puede quedar vac�o. Introduce un c�digo: ");
           nuevoCodigoDeProyecto = leerDatos.nextInt();

       }  

        /**Solicitud por consola de las acciones a realizar por el proyecto y lectura por teclado de nuevasAccionesARealizar*/
       System.out.print("Introduce las acciones a realizar: ");
       nuevasAccionesARealizar = leerDatos.nextLine();

       /**Comprobacion para que campo acciones a realizar no est� vac�o*/
        while (nuevasAccionesARealizar.isEmpty()){

           System.out.print("Debe especificar las acciones a realizar. Por favor, escr�balas: ");
           nuevasAccionesARealizar = leerDatos.nextLine();

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
           
           /**Solicitud por consola de contrase�a y lectura por teclado de contrase�a*/
           System.out.print("Introduce la contrase�a del usuario del nuevo miembro del personal: ");
           nuevaContrase�a = leerDatos.nextLine();
           
           /**Comprobacion para que campo contrase�a no est� vac�o*/
            while (nuevaContrase�a.isEmpty()){

               System.out.print("La contrase�a del nuevo usuario no puede ser un campo vacio. Introduce la contrase�a del nuevo miembro del personal y usuario: ");
               nuevaContrase�a = leerDatos.nextLine();

           }
           
            /**Solicitud por consola de la delegacion y lectura por teclado de la delegacion a la que pertenece el nuevo miembro*/
            System.out.print("Introduce al delegaci�n a la que pertenece el nuevo miembro del personal: 'Entreculturas Espa�a', 'Entreculturas Portugal' o 'Entreculturas Francia' ");
            nuevaDelegacion = leerDatos.nextLine();

            /**Comprobacion para que campo delegaci�n no est� vac�o*/
            while (tipoDePersonalDelNuevo.isEmpty()){

               System.out.print("La delegaci�n del nuevo miembro no puede ser un campo vac�o. Introduce la delegaci�n del nuevo miembro del personal: ");
               nuevaDelegacion = leerDatos.nextLine();

           }
            
            /**Comprobacion para que campo tipo de personal est� limitado a los tres tipos posibles y no se pueda introducir cualquier String*/

            while (!"Voluntario".equals(tipoDePersonalDelNuevo) && !"VoluntarioInternacional".equals(tipoDePersonalDelNuevo) && !"Contratado".equals(tipoDePersonalDelNuevo)){ /*comprobacion de campo para que solo se puedan introducir los tipos de habs que existen*/

                System.out.print("El tipo de personal indicado no es correcto. Por favor, vuelve a escribirlo:\n ");
                tipoDePersonalDelNuevo = leerDatos.nextLine(); 

            }
               ArrayList<Proyecto> proyectosSinAsignar = this.proyectosLibres(); /*ArrayList de proyectos libres*/
               Proyecto proyectoAsignado; /*Proyecto que se asignar�*/
               ArrayList<Proyecto> proyectosDelNuevo = new ArrayList<Proyecto>(); /*ArrayList de proyectos del miembro del personal nuevo*/
               Personal nuevoPersonal = new Personal (nuevoNombre, nuevoApellido, tipoDePersonalDelNuevo, proyectosSinAsignar, nuevoUsuario, nuevaContrase�a, nuevaDelegacion);            

               if (proyectosSinAsignar.isEmpty()){
                   Collections.shuffle(totalProyectos);
                   proyectoAsignado = totalProyectos.get(0);/*para asignaci�n aleatoria, cojo el primer proyecto de entre todos los proyectos, ya que todos tienen miembros*/
                   proyectosDelNuevo.add(proyectoAsignado);
                   System.out.print("No hay proyectos sin personal asignado. El nuevo miembro de personal colaborar� con otros miembros en el proyecto c�digo " + proyectoAsignado.getCodigoDeProyecto());

               }

               else {
                   proyectoAsignado = proyectosSinAsignar.get(0);
                   proyectosDelNuevo.add(proyectoAsignado);
                   System.out.print("Hay proyectos que todav�a no tienen personal. El nuevo miembro de personal se asigna al proyecto c�digo " + proyectoAsignado.getCodigoDeProyecto());

               }  /*guardamos miembro de personal nuevo*/

                nuevoPersonal.setNombre(nuevoNombre);
                nuevoPersonal.setApellido(nuevoApellido);
                nuevoPersonal.setTipoDePersonal(tipoDePersonalDelNuevo);
                nuevoPersonal.setUsuario(nuevoUsuario);
                nuevoPersonal.setContrase�a(nuevaContrase�a);
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
       System.out.print("Introduce la nueva delegaci�n a registrar: ");
       newName_Delegacion = leerDatos.nextLine();

       /**Comprobacion para que campo newName_Delegacion no est� vac�o*/
        while (newName_Delegacion.isEmpty()){

           System.out.print("Para registrar una nueva delegaci�n, este campo es totalmente obligatorio:");
           newName_Delegacion = leerDatos.nextLine();

       }

       /**Solicitud por consola de la Direcci�n y lectura por teclado denewName_Direccion**/
       System.out.print("Introduce la direcci�n de la Delegaci�n que desee registrar: ");
       newName_Direccion = leerDatos.nextLine();

       /**Comprobacion para que campo newName_Direccion no est� vac�o**/
        while (newName_Direccion.isEmpty()){

           System.out.print("Para registrar una nueva delegaci�n, este campo es totalmente obligatorio:");
           newName_Direccion = leerDatos.nextLine();

       }

       /**Solicitud por consola del Telefono y lectura por teclado del newName_Telefono**/
       System.out.print("Introduce un n�mero de telefono para poder contactar con usted: ");
       newName_Telefono = leerDatos.nextInt();
       leerDatos.nextLine();/*Consume salto de l�nea no leido por nextInt*/

  
       /**Comprobacion para que campo newName_Telefono no est� vac�o
       
       while (newName_Telefono == "\n"){
	   System.out.print("Para registrar una nueva delegaci�n, este campo es totalmente obligatorio:");
           newName_Telefono = leerDatos.nextInt();
       }
       21.09.2020 - NO DETECTA NULL */

       /** INICIO - Bloqueo de c�digo de la verificaci�n de las delegaciones, 
           en caso de que la Delegaci�n sea existente, volver� a empezar de nuevo el formulario.
           En caso contrario, se a�adir� la Delegaci�n y volver� al men� inicial**/
       ArrayList<Delegacion> nuevaListaDelegaciones = this.getDelegaciones();

       for (int i = 0; i < nuevaListaDelegaciones.size(); i++){ /**hacemos un loop para recorrer los objetos personal del arraylist listado de personal de la ONG*/
          if (nuevaListaDelegaciones.get(i).getNombre().equals(newName_Delegacion)){ /**comprobamos que el usuario no exista ya para no guardar un nuevo miembro de personal con el mismo user*/

              System.out.println("Esta Delegaci�n ya existe. No se puede crear un con el mismo nombre. Por favor, vuelve formular la nueva Delegacion correctamente");
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
