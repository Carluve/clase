/*
 * Métodos para gestionar las publicaciones
 */
package Biblioteca;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author carlos.luengo
 */
public class GestionPublicacion {
    /**ArrayList para publicaciones */
    private static ArrayList<Publicaciones> publicaciones = new ArrayList<Publicaciones>();
    private static Publicaciones objpub;
   
    /**ArrayList para prestamos */
    private static ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
    private static Prestamo objpres;

    
    /** Establece el ArrayList de publicaciones */
    public static void setPublicacaciones(ArrayList<Publicaciones> p) {
        publicaciones = p;
    }
    
    /** Establece el ArrayList de prestamos */
    public static void setPrestamo(ArrayList<Prestamo> a) {
        prestamos = a;
    }
    
   

    /** Devuelve el ArrayList de Publicaciones */
    public static ArrayList<Publicaciones> getPublicaciones() {
        //Comparador para ordenar los Productos por su nombre
        Comparator NomproComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Publicaciones p1 = (Publicaciones) o1;
                Publicaciones p2 = (Publicaciones) o2;
                return p1.getTitulo().compareTo(p2.getTitulo());
            }
        };
        //Ordenamos el array
        Collections.sort(publicaciones, NomproComp);
        return publicaciones;
    }

    /** Da de alta una Publicacion*/
    public static boolean altaPublicaciones(Publicaciones objpub) {
        if (!publicaciones.contains(objpub)) {
            publicaciones.add(objpub);
            return true;
        } else {
            return false;
        }

    }

    /** Da de baja una Publicacion */
    public static boolean bajaPublicaciones(Publicaciones objpub) {
        if (publicaciones.contains(objpub)) {
            publicaciones.remove(objpub);
            return true;
        } else {
            return false;
        }
    }

   

    /** Modifica los datos de una Publicacion */
     public static boolean modificaPublicaciones(int codigo,Publicaciones pub){
            publicaciones.set(codigo, pub);
            return true;       
    }

   
    /** Consultar una publicación para extraerla (Funcionalidad para el boton comprobar)    */
    
  public static Publicaciones consultaPublicacionesPorCodigo(String codigo) {
        //Comparador para ordenar los Productos por su código
        Comparator CodigoproComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Publicaciones p1 = (Publicaciones) o1;
                Publicaciones p2 = (Publicaciones) o2;
                return p1.getCodigo().compareTo(p2.getCodigo());
            }
        };
        //Ordenamos el array
        Collections.sort(publicaciones, CodigoproComp);
        //creamos una Publicacion con el código a buscar
       Publicaciones p = new Publicaciones();
        p.setCodigo(codigo);
        int pos = Collections.binarySearch(publicaciones, p,CodigoproComp);
        if (pos >= 0) {
            objpub = publicaciones.get(pos);
        } else {
            objpub = null;
        }

        return objpub;
    }
  
  /**Constulta si existe una publicación */
   public static boolean consultaPublicaciones(String codigo) {
        //Comparador para ordenar los Productos por su código
        Comparator CodigoproComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Publicaciones p1 = (Publicaciones) o1;
                Publicaciones p2 = (Publicaciones) o2;
                return p1.getCodigo().compareTo(p2.getCodigo());
            }
        };
        //Ordenamos el array
        Collections.sort(publicaciones, CodigoproComp);
        //creamos una Publicacion con el código a buscar
       Publicaciones p = new Publicaciones();
        p.setCodigo(codigo);
        int pos = Collections.binarySearch(publicaciones, p,CodigoproComp);
        if (pos >= 0) {
            return true;
        } else {
            return false;
        }

     }
    
    /**Método para prestar un libro*/
   public static boolean prestamoPublicacion(Publicaciones pub, Persona per){
       String tipoper = per.getCategoria_socio();
       String tipopub = pub.getClass().getSimpleName();
       int dias = 0;
       SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
         Calendar c1 = Calendar.getInstance();
         Calendar c2 = Calendar.getInstance();
       
    if(publicaciones.contains(pub)){   
       if(tipoper.equals("Alumno")){
           if(tipopub.equals("Libro")){
                dias = 6; 
           }
           if(tipopub.equals("Revistas")){
               dias = 3;  
           }
           if(tipopub.equals("Proyectos")){
               dias= 10;  
           }
          if(tipopub.equals("Tesis")){
              dias =10;   
          }
           
       }
       else{
           if(tipopub.equals("Libro")){
                dias = 10;    
           }
           if(tipopub.equals("Revistas")){
               dias = 6;
           }
           if(tipopub.equals("Proyectos")){
           }
               dias = 12;
          if(tipopub.equals("Tesis")){
              dias = 12;
          }
       }
       c2.add(Calendar.DATE,dias);
       Prestamo pres = new Prestamo(per.getCodigo_socio(), pub.getCodigo(), c1,c2);
       prestamos.add(pres);
       try{
       ticketPrestamo(pres);
       }
       catch(Exception IOE){
           System.out.println("Error al imprimir el ticket");
       }
       guardarDatosPrestamo();
       return true;
       }
    else{
        return false;
    }
   }
   
   /**Método para devolver un prestamo */
   public static boolean devolucionPublicacion(Prestamo objpres){
   if (prestamos.contains(objpres)) {
            prestamos.remove(objpres);
            return true;
        } else {
            return false;
        }
   
   }
   
   /** Devuelve el ArrayList de prestamo */
    public static ArrayList<Prestamo> getPrestamo() {
        //Comparador para ordenar los Productos por su nombre
        Comparator NomproComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Prestamo p1 = (Prestamo) o1;
                Prestamo p2 = (Prestamo) o2;
                return p1.getSocio().compareTo(p2.getSocio());
            }
        };
        //Ordenamos el array
        Collections.sort(prestamos, NomproComp);
        return prestamos;
    }
    
     /**Constulta si existe un prestamo */
   public static boolean consultaPrestamo(String codigo) {
        //Comparador para ordenar los Productos por su código
        Comparator CodigoproComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Prestamo p1 = (Prestamo) o1;
                Prestamo p2 = (Prestamo) o2;
                return p1.getSocio().compareTo(p2.getSocio());
            }
        };
        //Ordenamos el array
        Collections.sort(prestamos, CodigoproComp);
        //creamos una Publicacion con el código a buscar
       Prestamo pres = new Prestamo();
        pres.setSocio(codigo);
        int pos = Collections.binarySearch(prestamos, pres,CodigoproComp);
        if (pos >= 0) {
            return true;
        } else {
            return false;
        }
     }
    /** Consultar una publicación para extraerla (Funcionalidad para el boton comprobar)    */
    
  public static Prestamo consultaPrestamoPres(String codigo) {
        //Comparador para ordenar los Productos por su código
        Comparator CodigoproComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Prestamo p1 = (Prestamo) o1;
                Prestamo p2 = (Prestamo) o2;
                return p1.getSocio().compareTo(p2.getSocio());
            }
        };
        //Ordenamos el array
        Collections.sort(prestamos, CodigoproComp);
        //creamos una Publicacion con el código a buscar
        Prestamo pres = new Prestamo();
        pres.setSocio(codigo);
        int pos = Collections.binarySearch(prestamos, pres,CodigoproComp);
        if (pos >= 0) {
            objpres = prestamos.get(pos);
        } else {
            objpres = null;
        }

        return objpres;
    }

  public static  boolean consultaPrestamos(){
    if(prestamos.isEmpty()){
        return true;
  }
    else{
        return false;
    }
      
  }

      /** Crea el fichero de prestamo */
    public static void ticketPrestamo(Prestamo pres) throws IOException {
        Date d = new GregorianCalendar().getTime();
        String fn = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT).format(d);        
        String rutaFicheroPrestamo = "./Prestamos/Prestamo(" + fn.replace(':', '_') + ").txt";
       
        try {
            //Si no existe el directorio Prestamos, lo creamos
            File dirPrestamos = new File("./Prestamos");

            if (!dirPrestamos.exists()) {
                dirPrestamos.mkdir();
            }
           
            FileWriter fw = new FileWriter(rutaFicheroPrestamo);
            PrintWriter salida = new PrintWriter(new BufferedWriter(fw));
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            
            Calendar c1 = pres.fecha_prestamo;
            Calendar c2 = pres.fecha_devolucion;
            
            //Escribimos la plantilla
            salida.println("-------------------------------- Ticket Prestamo --------------------------------");
            salida.println("\n");
            salida.println("-------------------------------- Fecha: " + fn + " -----------------------");
            salida.println("\n");
            salida.println("Código de publicación: " + pres.getCodigo_Publicacion());
            salida.println("\n");
            salida.println("Codigo de socio: " + pres.getSocio());
            salida.println("---------------------------------------------------------------------------------");
            salida.println("Fecha de prestamo: "+ formato.format(pres.fecha_prestamo.getTime()));
            salida.println("Fecha de devolucion: "+ formato.format(pres.fecha_devolucion.getTime()));
            salida.println("\n");
            salida.println("---------------------------------------------------------------------------------");
            salida.close();
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin generaTicket
    
    
    public static void ticketDevolucion(Prestamo pres) throws IOException {
        Date d = new GregorianCalendar().getTime();
        String fn = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT).format(d);        
        String rutaFicheroPrestamo = "./Devoluciones/Devolucion(" + fn.replace(':', '_') + ").txt";
       
        try {
            //Si no existe el directorio Prestamos, lo creamos
            File dirPrestamos = new File("./Devoluciones");

            if (!dirPrestamos.exists()) {
                dirPrestamos.mkdir();
            }
           
            FileWriter fw = new FileWriter(rutaFicheroPrestamo);
            PrintWriter salida = new PrintWriter(new BufferedWriter(fw));
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            
            Calendar c1 = pres.fecha_prestamo;
            Calendar c2 = pres.fecha_devolucion;
            
            //Escribimos la plantilla
            salida.println("-------------------------------- Ticket Devolucion --------------------------------");
            salida.println("\n");
            salida.println("-------------------------------- Fecha: " + fn + " -----------------------");
            salida.println("\n");
            salida.println("Código de publicación: " + pres.getCodigo_Publicacion());
            salida.println("\n");
            salida.println("Codigo de socio: " + pres.getSocio());
            salida.println("---------------------------------------------------------------------------------");
            salida.println("La publicación ha sido devuelta a tiempo");
            salida.println("\n");
            salida.println("---------------------------------------------------------------------------------");
            salida.close();
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin generaTicket
 
     public static void ticketDevolucionSancion(Prestamo pres) throws IOException {
        Date d = new GregorianCalendar().getTime();
        String fn = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT).format(d);        
        String rutaFicheroPrestamo = "./Devoluciones/Devolucion(" + fn.replace(':', '_') + ").txt";
       
        try {
            //Si no existe el directorio Prestamos, lo creamos
            File dirPrestamos = new File("./Devoluciones");

            if (!dirPrestamos.exists()) {
                dirPrestamos.mkdir();
            }
           
            FileWriter fw = new FileWriter(rutaFicheroPrestamo);
            PrintWriter salida = new PrintWriter(new BufferedWriter(fw));
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
             Calendar c1 = Calendar.getInstance();
             Calendar c2 = objpres.fecha_devolucion;
             long inicio = c1.getTimeInMillis();
             long devolucion = c2.getTimeInMillis();
            long resultado = inicio-devolucion;
             double dias = Math.floor(resultado/(1000*60*60*24));
            
            //Escribimos la plantilla
            salida.println("----------------------------- Ticket Devolucion con sancion --------------------");
            salida.println("\n");
            salida.println("-------------------------------- Fecha: " + fn + " -----------------------");
            salida.println("\n");
            salida.println("Código de publicación: " + pres.getCodigo_Publicacion());
            salida.println("\n");
            salida.println("Codigo de socio: " + pres.getSocio());
            salida.println("---------------------------------------------------------------------------------");
            salida.println("El tiempo para la devolución ha excendido en: " + dias +" dias.");
            salida.println("\n");
            salida.println("---------------------------------------------------------------------------------");
            salida.close();
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin generaTicket
    
    /** Carga los datos de Publicaciones del fichero */
    public static void cargarDatos() {
        try {
            //Lectura de los objetos de tipo Publicaciones
            FileInputStream istreampro = new FileInputStream("publicaciones.dat");
            ObjectInputStream oispro = new ObjectInputStream(istreampro);
            publicaciones = (ArrayList) oispro.readObject();
            istreampro.close();
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin cargarDatos

    /** Guarda los datos de Publicaciones en el fichero */
    public static void guardarDatos() {
        try {
            //Si hay datos los guardamos...
            if (!publicaciones.isEmpty()) {
                /****** Serialización de los objetos ******/
                //Serialización de las Publicaciones
                FileOutputStream ostreampro = new FileOutputStream("publicaciones.dat");
                ObjectOutputStream oospro = new ObjectOutputStream(ostreampro);
                //guardamos el array de Publicaciones
                oospro.writeObject(publicaciones);
                ostreampro.close();
            } else {
                System.out.println("Error: No hay datos...");
            }

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin guardarDatos
    
     /** Carga los datos de Prestamo del fichero */
    public static void cargarDatosPrestamo() {
        try {
            //Lectura de los objetos de tipo Publicaciones
            FileInputStream istreampro = new FileInputStream("prestamos.dat");
            ObjectInputStream oispro = new ObjectInputStream(istreampro);
            prestamos = (ArrayList) oispro.readObject();
            istreampro.close();
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin cargarDatos

    /** Guarda los datos de Prestamo en el fichero */
    public static void guardarDatosPrestamo() {
        try {
            //Si hay datos los guardamos...
            if (!publicaciones.isEmpty()) {
                /****** Serialización de los objetos ******/
                //Serialización de las Publicaciones
                FileOutputStream ostreampro = new FileOutputStream("prestamos.dat");
                ObjectOutputStream oospro = new ObjectOutputStream(ostreampro);
                //guardamos el array de Publicaciones
                oospro.writeObject(prestamos);
                ostreampro.close();
            } else {
                System.out.println("Error: No hay datos...");
            }

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin guardarDatos
    
}
