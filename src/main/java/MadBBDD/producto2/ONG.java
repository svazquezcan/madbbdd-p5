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
     * @param CIF, para a√±adir/modificar el CIF de la ONG*/
    public void setCIF(String CIF){
        this.CIF = CIF; 
    }
    
      /**Setter
     * @param direccion, para a√±adir/modificar la direccion de la ONG*/
    public void setDireccion(String direccion){
        this.direccion = direccion; 
    }
    
      /**Setter
     * @param telefono, para a√±adir/modificar el telefono de la ONG*/
    public void setTelefono (int telefono){
        this.telefono = telefono; 
    }
    
      /**Setter
     * @param delegaciones, para a√±adir/modificar lista de delegaciones de la ONG*/
    public void setDelegaciones(ArrayList<Delegacion> delegaciones){
        this.delegaciones = delegaciones; 
    }
    
      /**Setter
     * @param proyectos, para a√±adir/modificar lista de proyectos de la ONG*/
    public void setProyectos(ArrayList<Proyecto> proyectos){
        this.proyectos = proyectos; 
    }
    
       /**Setter
     * @param listaPersonal, para a√±adir/modificar lista de personal de la ONG*/
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
            
            isAssigned = nuevaListaProyectos.get(i).isAssigned(); /*comprobamos cada objeto proyecto seg√∫n m√©todo isAssigned*/
            
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
        String nuevaContrase√±a; 
        String nuevaDelegacion;
        
        
        /**Solicitud por consola del tipo de personal y lectura por teclado de tipoDePersonalDelNuevo*/
       System.out.print("Introduce el tipo de personal del nuevo miembro del personal: Voluntario, VoluntarioInternacional o Contratado: ");
       tipoDePersonalDelNuevo = leerDatos.nextLine();

       /**Comprobacion para que campo nombre no est√© vac√≠o*/
        while (tipoDePersonalDelNuevo.isEmpty()){

           System.out.print("El tipo de personal del nuevo miembro no puede ser un campo vac√≠o. Introduce el tipo de personal del nuevo miembro del personal: ");
           tipoDePersonalDelNuevo = leerDatos.nextLine();

       }
        /**Comprobacion para que campo tipo de personal est√© limitado a los tres tipos posibles y no se pueda introducir cualquier String*/

        while (!"Voluntario".equals(tipoDePersonalDelNuevo) && !"VoluntarioInternacional".equals(tipoDePersonalDelNuevo) && !"Contratado".equals(tipoDePersonalDelNuevo)){ /*comprobacion de campo para que solo se puedan introducir los tipos de habs que existen*/

            System.out.print("El tipo de personal indicado no es correcto. Por favor, vuelve a escribirlo:\n ");
            tipoDePersonalDelNuevo = leerDatos.nextLine(); 

        }

       /**Solicitud por consola del nombre de personal y lectura por teclado del nuevoNombre*/
       System.out.print("Introduce nombre del nuevo miembro del personal: ");
       nuevoNombre = leerDatos.nextLine();

       /**Comprobacion para que campo nombre no est√© vac√≠o*/
        while (nuevoNombre.isEmpty()){

           System.out.print("El nombre del nuevo miembro del personal no puede ser un campo vac√≠o. Introduce el nombre del nuevo miembro del personal: ");
           nuevoNombre = leerDatos.nextLine();

       }

        /**Solicitud por consola del apellido de personal y lectura por teclado del nuevoApellido*/
       System.out.print("Introduce apellido del nuevo miembro del personal: ");
       nuevoApellido = leerDatos.nextLine();

       /**Comprobacion para que campo apellido no est√© vac√≠o*/
        while (nuevoApellido.isEmpty()){

           System.out.print("El apellido del nuevo miembro del personal no puede ser un campo vac√≠o. Introduce el apellido del nuevo miembro del personal: ");
           nuevoApellido = leerDatos.nextLine();

       }

       /**Solicitud por consola del nuevo usuario de personal y lectura por teclado del nuevoUsuario*/
       System.out.print("Introduce usuario del nuevo miembro del personal: ");
       nuevoUsuario = leerDatos.nextLine();

       /**Comprobacion para que campo usuario no est√© vac√≠o*/
        while (nuevoUsuario.isEmpty()){

           System.out.print("El usuario del nuevo miembro del personal no puede ser un campo vac√≠o. Introduce el usuario del nuevo miembro del personal: ");
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
           
           /**Solicitud por consola de contrase√±a y lectura por teclado de contrase√±a*/
           System.out.print("Introduce la contrase√±a del usuario del nuevo miembro del personal: ");
           nuevaContrase√±a = leerDatos.nextLine();
           
           /**Comprobacion para que campo contrase√±a no est√© vac√≠o*/
            while (nuevaContrase√±a.isEmpty()){

               System.out.print("La contrase√±a del nuevo usuario no puede ser un campo vacio. Introduce la contrase√±a del nuevo miembro del personal y usuario: ");
               nuevaContrase√±a = leerDatos.nextLine();

           }
           
            /**Solicitud por consola de la delegacion y lectura por teclado de la delegacion a la que pertenece el nuevo miembro*/
            System.out.print("Introduce al delegaci√≥n a la que pertenece el nuevo miembro del personal: 'Entreculturas Espa√±a', 'Entreculturas Portugal' o 'Entreculturas Francia' ");
            nuevaDelegacion = leerDatos.nextLine();

            /**Comprobacion para que campo delegaci√≥n no est√© vac√≠o*/
            while (tipoDePersonalDelNuevo.isEmpty()){

               System.out.print("La delegaci√≥n del nuevo miembro no puede ser un campo vac√≠o. Introduce la delegaci√≥n del nuevo miembro del personal: ");
               nuevaDelegacion = leerDatos.nextLine();

           }
            
            /**Comprobacion para que campo tipo de personal est√© limitado a los tres tipos posibles y no se pueda introducir cualquier String*/

            while (!"Voluntario".equals(tipoDePersonalDelNuevo) && !"VoluntarioInternacional".equals(tipoDePersonalDelNuevo) && !"Contratado".equals(tipoDePersonalDelNuevo)){ /*comprobacion de campo para que solo se puedan introducir los tipos de habs que existen*/

                System.out.print("El tipo de personal indicado no es correcto. Por favor, vuelve a escribirlo:\n ");
                tipoDePersonalDelNuevo = leerDatos.nextLine(); 

            }
               ArrayList<Proyecto> proyectosSinAsignar = this.proyectosLibres(); /*ArrayList de proyectos libres*/
               Proyecto proyectoAsignado; /*Proyecto que se asignar√°*/
               ArrayList<Proyecto> proyectosDelNuevo = new ArrayList<Proyecto>(); /*ArrayList de proyectos del miembro del personal nuevo*/
               Personal nuevoPersonal = new Personal (nuevoNombre, nuevoApellido, tipoDePersonalDelNuevo, proyectosSinAsignar, nuevoUsuario, nuevaContrase√±a, nuevaDelegacion);            

               if (proyectosSinAsignar.isEmpty()){
                   Collections.shuffle(totalProyectos);
                   proyectoAsignado = totalProyectos.get(0);/*para asignaci√≥n aleatoria, cojo el primer proyecto de entre todos los proyectos, ya que todos tienen miembros*/
                   proyectosDelNuevo.add(proyectoAsignado);
                   System.out.print("No hay proyectos sin personal asignado. El nuevo miembro de personal colaborar√° con otros miembros en el proyecto c√≥digo " + proyectoAsignado.getCodigoDeProyecto());

               }

               else {
                   proyectoAsignado = proyectosSinAsignar.get(0);
                   proyectosDelNuevo.add(proyectoAsignado);
                   System.out.print("Hay proyectos que todav√≠a no tienen personal. El nuevo miembro de personal se asigna al proyecto c√≥digo " + proyectoAsignado.getCodigoDeProyecto());

               }  /*guardamos miembro de personal nuevo*/

                nuevoPersonal.setNombre(nuevoNombre);
                nuevoPersonal.setApellido(nuevoApellido);
                nuevoPersonal.setTipoDePersonal(tipoDePersonalDelNuevo);
                nuevoPersonal.setUsuario(nuevoUsuario);
                nuevoPersonal.setContrase√±a(nuevaContrase√±a);
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
       System.out.print("Introduce la nueva delegaci√≥n a registrar: ");
       newName_Delegacion = leerDatos.nextLine();

       /**Comprobacion para que campo newName_Delegacion no est√© vac√≠o*/
        while (newName_Delegacion.isEmpty()){

           System.out.print("Para registrar una nueva delegaci√≥n, este campo es totalmente obligatorio:");
           newName_Delegacion = leerDatos.nextLine();

       }

       /**Solicitud por consola de la Direcci√≥n y lectura por teclado denewName_Direccion**/
       System.out.print("Introduce la direcci√≥n de la Delegaci√≥n que desee registrar: ");
       newName_Direccion = leerDatos.nextLine();

       /**Comprobacion para que campo newName_Direccion no est√© vac√≠o**/
        while (newName_Direccion.isEmpty()){

           System.out.print("Para registrar una nueva delegaci√≥n, este campo es totalmente obligatorio:");
           newName_Direccion = leerDatos.nextLine();

       }

       /**Solicitud por consola del Telefono y lectura por teclado del newName_Telefono**/
       System.out.print("Introduce un n√∫mero de telefono para poder contactar con usted: ");
       newName_Telefono = leerDatos.nextInt();
       leerDatos.nextLine();/*Consume salto de l√≠nea no leido por nextInt*/

  
       /**Comprobacion para que campo newName_Telefono no est√© vac√≠o
       
       while (newName_Telefono == "\n"){
	   System.out.print("Para registrar una nueva delegaci√≥n, este campo es totalmente obligatorio:");
           newName_Telefono = leerDatos.nextInt();
       }
       21.09.2020 - NO DETECTA NULL */

       /** INICIO - Bloqueo de c√≥digo de la verificaci√≥n de las delegaciones, 
           en caso de que la Delegaci√≥n sea existente, volver√° a empezar de nuevo el formulario.
           En caso contrario, se a√±adir√° la Delegaci√≥n y volver√° al men√∫ inicial**/
       ArrayList<Delegacion> nuevaListaDelegaciones = this.getDelegaciones();

       for (int i = 0; i < nuevaListaDelegaciones.size(); i++){ /**hacemos un loop para recorrer los objetos personal del arraylist listado de personal de la ONG*/
          if (nuevaListaDelegaciones.get(i).getNombre().equals(newName_Delegacion)){ /**comprobamos que el usuario no exista ya para no guardar un nuevo miembro de personal con el mismo user*/

              System.out.println("Esta Delegaci√≥n ya existe. No se puede crear un con el mismo nombre. Por favor, vuelve formular la nueva Delegacion correctamente");
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
        
        
        /**Solicitud por consola del paÌs de Proyecto y lectura por teclado de nuevoPais*/
       System.out.print("Introduce el paÌs del proyecto: ");
       nuevoPais = leerDatos.nextLine();

       /**Comprobacion para que campo paÌs no estÈ vacÌo*/
        while (nuevoPais.isEmpty()){

           System.out.print("El campo paÌs no puede quedar vacÌo, introduce el paÌs del Proyecto: ");
           nuevoPais = leerDatos.nextLine();

       }

       /**Solicitud por consola de la lÌnea de localizaciÛn y lectura por teclado de nuevaLocalizacion*/
       System.out.print("Introduce nombre de la nueva localizaciÛn: ");
       nuevaLocalizacion = leerDatos.nextLine();

       /**Comprobacion para que campo localizaciÛn no estÈ vacÌo*/
        while (nuevaLocalizacion.isEmpty()){

           System.out.print("El nombre de localizaciÛn no puede quedar vacÌo. Introduce el nombre de la localizaciÛn: ");
           nuevaLocalizacion = leerDatos.nextLine();

       }

        /**Solicitud por consola de la lÌnea de acciÛn del proyecto y lectura por teclado de nuevaLineaDeAccion*/
       System.out.print("Introduce la lÌnea de acciÛn: ");
       nuevaLineaDeAccion = leerDatos.nextLine();

       /**Comprobacion para que campo apellido no estÈ vacÌo*/
        while (nuevaLineaDeAccion.isEmpty()){

           System.out.print("La lÌnea de acciÛn no puede ser un campo vacÌo. Introduce la lÌnea de acciÛn: ");
           nuevaLineaDeAccion = leerDatos.nextLine();

       }

       /**Solicitud por consola la sublÌnea y lectura por teclado de nuevaSublineaDeAccion*/
       System.out.print("Introduce la sublÌnea de acciÛn: ");
       nuevaSublineaDeAccion = leerDatos.nextLine();

       /**Comprobacion para que campo sublÌnea de acciÛn no estÈ vacÌo*/
        while (nuevaSublineaDeAccion.isEmpty()){

           System.out.print("La sublÌnea de acciÛn no puede quedar vacÌa. Introduce la sublÌnea de acciÛn: ");
           nuevaSublineaDeAccion = leerDatos.nextLine();

       }  
        
        /**Solicitud por consola de la fecha de inicio y lectura por teclado de fechaDeInicio*/
       System.out.print("Introduce la fecha de inicio del proyecto: ");
       nuevaFechaDeInicio = leerDatos.nextLine();

       /**Comprobacion para que campo fecha de inicio no estÈ vacÌo*/
        while (nuevaFechaDeInicio.isEmpty()){

           System.out.print("La fecha de inicio no puede quedar vacÌa, introduce la fecha de inicio del Proyecto: ");
           nuevaFechaDeInicio = leerDatos.nextLine();

       }

       /**Solicitud por consola de la fecha de finalizaciÛn y lectura por teclado de nuevaFechaDeFinalizacion*/
       System.out.print("Introduce fecha de finalizaciÛn: ");
       nuevaFechaDeFinalizacion = leerDatos.nextLine();

       /**Comprobacion para que campo fecha de finalizaciÛn no estÈ vacÌo*/
        while (nuevaFechaDeFinalizacion.isEmpty()){

           System.out.print("La fecha de finalizaciÛn no puede quedar vacÌa. Introduce la fecha de finalizaciÛn: ");
           nuevaFechaDeFinalizacion = leerDatos.nextLine();

       }

        /**Solicitud por consola de socio local y lectura por teclado de nuevoSocioLocal*/
       System.out.print("Introduce el socio local: ");
       nuevoSocioLocal = leerDatos.nextLine();

       /**Comprobacion para que campo socio local no estÈ vacÌo*/
        while (nuevoSocioLocal.isEmpty()){

           System.out.print("Socio local no puede ser un campo vacÌo. Introduce el socio local: ");
           nuevoSocioLocal = leerDatos.nextLine();

       }

       /**Solicitud por consola del financiador y lectura por teclado de nuevoFinanciador*/
       System.out.print("Introduce el financiador: ");
       nuevoFinanciador = leerDatos.nextLine();

       /**Comprobacion para que campo financiador no estÈ vacÌo*/
        while (nuevoFinanciador.isEmpty()){

           System.out.print("El financiador no puede quedar vacÌo. Introduce el financiador: ");
           nuevoFinanciador = leerDatos.nextLine();

       }
        
        /**Solicitud por consola de la financiaciÛn aportada y lectura por teclado de nuevaFinanciacionAportada*/
       System.out.print("Introduce la financiaciÛn: ");
       nuevaFinanciacionAportada = leerDatos.nextFloat();

       /**Comprobacion para que campo financiaciÛn aportada no estÈ vacÌa*/
        while (nuevaFinanciacionAportada.isEmpty()){

           System.out.print("La financiaciÛn aportada no puede quedar vacÌa. Introduce un importe: ");
           nuevaFinanciacionAportada = leerDatos.nextFloat();

       }  
        
        /**Solicitud por consola del coste del proyecto y lectura por teclado de nuevoCosteProyecto*/
       System.out.print("Introduce el coste del proyecto: ");
       nuevoCosteProyecto = leerDatos.nextFloat();

       /**Comprobacion para que campo coste del proyecto no estÈ vacÌo*/
        while (nuevoCosteProyecto.isEmpty()){

           System.out.print("El coste del proyecto no puede quedar vacÌo. Introduce un importe: ");
           nuevoCosteProyecto = leerDatos.nextFloat();

       }  
        
        /**Solicitud por consola del cÛdigo del proyecto y lectura por teclado de nuevoCodigoDeProyecto*/
       System.out.print("Introduce el cÛdigo del proyecto: ");
       nuevoCodigoDeProyecto = leerDatos.nextInt();

       /**Comprobacion para que campo cÛdigo de proyecto no estÈ vacÌo*/
        while (nuevoCodigoDeProyecto.isEmpty()){

           System.out.print("El cÛdigo del proyecto no puede quedar vacÌo. Introduce un cÛdigo: ");
           nuevoCodigoDeProyecto = leerDatos.nextInt();

       }  

        /**Solicitud por consola de las acciones a realizar por el proyecto y lectura por teclado de nuevasAccionesARealizar*/
       System.out.print("Introduce las acciones a realizar: ");
       nuevasAccionesARealizar = leerDatos.nextLine();

       /**Comprobacion para que campo acciones a realizar no estÈ vacÌo*/
        while (nuevasAccionesARealizar.isEmpty()){

           System.out.print("Debe especificar las acciones a realizar. Por favor, escrÌbalas: ");
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
           
           /**Solicitud por consola de contraseÒa y lectura por teclado de contraseÒa*/
           System.out.print("Introduce la contraseÒa del usuario del nuevo miembro del personal: ");
           nuevaContraseÒa = leerDatos.nextLine();
           
           /**Comprobacion para que campo contraseÒa no estÈ vacÌo*/
            while (nuevaContraseÒa.isEmpty()){

               System.out.print("La contraseÒa del nuevo usuario no puede ser un campo vacio. Introduce la contraseÒa del nuevo miembro del personal y usuario: ");
               nuevaContraseÒa = leerDatos.nextLine();

           }
           
            /**Solicitud por consola de la delegacion y lectura por teclado de la delegacion a la que pertenece el nuevo miembro*/
            System.out.print("Introduce al delegaciÛn a la que pertenece el nuevo miembro del personal: 'Entreculturas EspaÒa', 'Entreculturas Portugal' o 'Entreculturas Francia' ");
            nuevaDelegacion = leerDatos.nextLine();

            /**Comprobacion para que campo delegaciÛn no estÈ vacÌo*/
            while (tipoDePersonalDelNuevo.isEmpty()){

               System.out.print("La delegaciÛn del nuevo miembro no puede ser un campo vacÌo. Introduce la delegaciÛn del nuevo miembro del personal: ");
               nuevaDelegacion = leerDatos.nextLine();

           }
            
            /**Comprobacion para que campo tipo de personal estÈ limitado a los tres tipos posibles y no se pueda introducir cualquier String*/

            while (!"Voluntario".equals(tipoDePersonalDelNuevo) && !"VoluntarioInternacional".equals(tipoDePersonalDelNuevo) && !"Contratado".equals(tipoDePersonalDelNuevo)){ /*comprobacion de campo para que solo se puedan introducir los tipos de habs que existen*/

                System.out.print("El tipo de personal indicado no es correcto. Por favor, vuelve a escribirlo:\n ");
                tipoDePersonalDelNuevo = leerDatos.nextLine(); 

            }
               ArrayList<Proyecto> proyectosSinAsignar = this.proyectosLibres(); /*ArrayList de proyectos libres*/
               Proyecto proyectoAsignado; /*Proyecto que se asignar·*/
               ArrayList<Proyecto> proyectosDelNuevo = new ArrayList<Proyecto>(); /*ArrayList de proyectos del miembro del personal nuevo*/
               Personal nuevoPersonal = new Personal (nuevoNombre, nuevoApellido, tipoDePersonalDelNuevo, proyectosSinAsignar, nuevoUsuario, nuevaContraseÒa, nuevaDelegacion);            

               if (proyectosSinAsignar.isEmpty()){
                   Collections.shuffle(totalProyectos);
                   proyectoAsignado = totalProyectos.get(0);/*para asignaciÛn aleatoria, cojo el primer proyecto de entre todos los proyectos, ya que todos tienen miembros*/
                   proyectosDelNuevo.add(proyectoAsignado);
                   System.out.print("No hay proyectos sin personal asignado. El nuevo miembro de personal colaborar· con otros miembros en el proyecto cÛdigo " + proyectoAsignado.getCodigoDeProyecto());

               }

               else {
                   proyectoAsignado = proyectosSinAsignar.get(0);
                   proyectosDelNuevo.add(proyectoAsignado);
                   System.out.print("Hay proyectos que todavÌa no tienen personal. El nuevo miembro de personal se asigna al proyecto cÛdigo " + proyectoAsignado.getCodigoDeProyecto());

               }  /*guardamos miembro de personal nuevo*/

                nuevoPersonal.setNombre(nuevoNombre);
                nuevoPersonal.setApellido(nuevoApellido);
                nuevoPersonal.setTipoDePersonal(tipoDePersonalDelNuevo);
                nuevoPersonal.setUsuario(nuevoUsuario);
                nuevoPersonal.setContraseÒa(nuevaContraseÒa);
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
       System.out.print("Introduce la nueva delegaciÛn a registrar: ");
       newName_Delegacion = leerDatos.nextLine();

       /**Comprobacion para que campo newName_Delegacion no estÈ vacÌo*/
        while (newName_Delegacion.isEmpty()){

           System.out.print("Para registrar una nueva delegaciÛn, este campo es totalmente obligatorio:");
           newName_Delegacion = leerDatos.nextLine();

       }

       /**Solicitud por consola de la DirecciÛn y lectura por teclado denewName_Direccion**/
       System.out.print("Introduce la direcciÛn de la DelegaciÛn que desee registrar: ");
       newName_Direccion = leerDatos.nextLine();

       /**Comprobacion para que campo newName_Direccion no estÈ vacÌo**/
        while (newName_Direccion.isEmpty()){

           System.out.print("Para registrar una nueva delegaciÛn, este campo es totalmente obligatorio:");
           newName_Direccion = leerDatos.nextLine();

       }

       /**Solicitud por consola del Telefono y lectura por teclado del newName_Telefono**/
       System.out.print("Introduce un n˙mero de telefono para poder contactar con usted: ");
       newName_Telefono = leerDatos.nextInt();
       leerDatos.nextLine();/*Consume salto de lÌnea no leido por nextInt*/

  
       /**Comprobacion para que campo newName_Telefono no estÈ vacÌo
       
       while (newName_Telefono == "\n"){
	   System.out.print("Para registrar una nueva delegaciÛn, este campo es totalmente obligatorio:");
           newName_Telefono = leerDatos.nextInt();
       }
       21.09.2020 - NO DETECTA NULL */

       /** INICIO - Bloqueo de cÛdigo de la verificaciÛn de las delegaciones, 
           en caso de que la DelegaciÛn sea existente, volver· a empezar de nuevo el formulario.
           En caso contrario, se aÒadir· la DelegaciÛn y volver· al men˙ inicial**/
       ArrayList<Delegacion> nuevaListaDelegaciones = this.getDelegaciones();

       for (int i = 0; i < nuevaListaDelegaciones.size(); i++){ /**hacemos un loop para recorrer los objetos personal del arraylist listado de personal de la ONG*/
          if (nuevaListaDelegaciones.get(i).getNombre().equals(newName_Delegacion)){ /**comprobamos que el usuario no exista ya para no guardar un nuevo miembro de personal con el mismo user*/

              System.out.println("Esta DelegaciÛn ya existe. No se puede crear un con el mismo nombre. Por favor, vuelve formular la nueva Delegacion correctamente");
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

       /** FINAL - Bloqueo de c√≥digo de la verificaci√≥n de las delegaciones**/
    }
    
}
