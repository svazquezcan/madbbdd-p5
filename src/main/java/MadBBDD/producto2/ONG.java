/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadBBDD.producto2;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Sandra
 */
public class ONG {
    private String CIF; 
    private String direccion; 
    private int telefono; 
    private ArrayList<Delegacion> delegaciones;
    private ArrayList<Proyecto> proyectos;
    private ArrayList<Personal> listaPersonal; 
    
    /**Creo objeto Scanner para poder leer input por teclado*/
    public static Scanner leerDatos = new Scanner(System.in);

    /**Constructor*/
    
    public ONG(){
        this.CIF = CIF;
        this.direccion = direccion; 
        this.telefono = telefono;     
        this.delegaciones = new ArrayList<Delegacion>(); 
        this.proyectos = new ArrayList<Proyecto>();
        this.listaPersonal = new ArrayList <Personal>(); 
        
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
   
    
    /**Funcion para la entrada de datos por consola de un nuevo miembro del personal*/
    
    public void entrarDatosPersonal(){
        /**Declaracion variables para guardar datos de personal nuevo*/
        String tipoDePersonalDelNuevo;
        String nuevoNombre; 
        String nuevoApellido; 
        String nuevoUsuario; 
        String nuevaContraseña; 
        int numeroProyecto; 
        
        try {
            /**Solicitud por consola del tipo de personal y lectura por teclado de tipoDePersonalDelNuevo*/
           System.out.print("Introduce el tipo de personal del nuevo miembro del personal: ");
           tipoDePersonalDelNuevo = leerDatos.nextLine();

           /**Comprobacion para que campo nombre no esté vacío*/
            while (tipoDePersonalDelNuevo.isEmpty()){

               System.out.print("El tipo de personal del nuevo miembro no puede ser un campo vacío. Introduce el tipo de personal del nuevo miembro del personal: ");
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

           if (newUser){  

               System.out.print("Introduce la contraseña del usuario del nuevo miembro del personal: ");/*como el usuario es nuevo, ahora pedimos que guarde contraseña*/
               nuevaContraseña = leerDatos.nextLine();
               ArrayList<Proyecto> proyectosSinAsignar = this.proyectosLibres();
               ArrayList<Proyecto> totalProyectos = this.getProyectos(); 


               Proyecto proyectoAsignado;
               Personal nuevoPersonal = new Personal (nuevoNombre, nuevoApellido, tipoDePersonalDelNuevo, proyectosSinAsignar, nuevoUsuario, nuevaContraseña);            

               if (proyectosSinAsignar.isEmpty()){

                   proyectoAsignado = totalProyectos.get(0);/*para asignación aleatoria, cojo el primer proyecto de entre todos los proyectos, ya que todos tienen miembros*/
                   proyectosSinAsignar.add(proyectoAsignado);
                   System.out.print("No hay proyectos sin personal asignado. El nuevo miembro de personal colaborará con otros miembros en el proyecto  " + proyectoAsignado.getCodigoDeProyecto());

               }

               else {
                   proyectoAsignado = proyectosSinAsignar.get(0);
                   proyectosSinAsignar.add(proyectoAsignado);
                   System.out.print("Hay proyectos que todavía no tienen personal. El nuevo miembro de personal se asigna al proyecto  " + proyectoAsignado.getCodigoDeProyecto());

               }

                nuevoPersonal.setNombre(nuevoNombre);
                nuevoPersonal.setApellido(nuevoApellido);
                nuevoPersonal.setTipoDePersonal(tipoDePersonalDelNuevo);
                nuevoPersonal.setListadoProyectos(proyectosSinAsignar);
                nuevoPersonal.setUsuario(nuevoUsuario);
                nuevoPersonal.setContraseña(nuevaContraseña);

           }

           else {

               System.out.print("No se puede crear el usuario porque ya existe. Volver a empezar registro de nuevo miembro de personal. "); 


           }
        }   
    
        catch (IndexOutOfBoundsException e){

            System.out.println("La ONG tiene todos sus proyectos cerrados. No se puede asignar un proyecto a ningún miembro del personal en este momento. ");
            
        }
        
    }
}
