/**
 * Esta clase contiene los metodos necesarios para poder dar de alta
 * y de baja a los socios
 */
package Biblioteca;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author carlos.luengo
 */
public class GestionUsuario {
    
    /**
     * Creamos la estructura para almacenar los socios
     */
   
    private static HashMap<String,Persona> socios = new HashMap<String,Persona>();
    private static Persona objper;
    
     /** Establece el HashMap de gestion de los usuarios */
    public static void setSocios(HashMap<String,Persona> p) {
        socios = p;
    }
   
    
    /**
     * Alta nuevos socios de la biblioteca
     */
    public static boolean altaSocios(Persona objper) {
        if (consultaSocio(objper.getCodigo_socio())== false) {
            socios.put(objper.getCodigo_socio(), objper);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Baja socios de la biblioteca
     */
   public static boolean bajaSocios(String codigo) {
        if (consultaSocio(codigo)) {
                socios.remove(codigo);
            return true;
        } 
        else {
            return false;
        }
    } 
        
        
   /**
    * Consulta si el usuario ya es socio
    */
        
   public static boolean consultaSocio(String codigo){
     if(socios.containsKey(codigo)){
          return true;
      } 
     else{
          return false;
       }
   }
   /** Recuperar socio*/
    public static Persona recuperarSocio(String codigo){
          
          Persona per = socios.get(codigo);
          return per;
       }
   
    /** Carga los datos de los socios del fichero */
    public static void cargarDatos() {
        try {
            //Lectura de los objetos de tipo Publicaciones
            FileInputStream istreampro = new FileInputStream("socios.dat");
            ObjectInputStream oispro = new ObjectInputStream(istreampro);
            socios = (HashMap) oispro.readObject();
            istreampro.close();
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin cargarDatos

    /** Guarda los datos de los socios en el fichero */
    public static void guardarDatos() {
        try {
            //Si hay datos los guardamos...
            if (!socios.isEmpty()) {
                /****** Serialización de los objetos ******/
                //Serialización de las Publicaciones
                FileOutputStream ostreampro = new FileOutputStream("socios.dat");
                ObjectOutputStream oospro = new ObjectOutputStream(ostreampro);
                //guardamos el array de Publicaciones
                oospro.writeObject(socios);
                ostreampro.close();
            } else {
                System.out.println("Error: No hay datos");
            }

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin guardarDatos
        
        
}
