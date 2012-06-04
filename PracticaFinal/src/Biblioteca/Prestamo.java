/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Carlos.Luengo
 */
public class Prestamo implements Serializable {

     public Prestamo(){

    }
    
    public Prestamo(String codigo_socio, String codigo_publicacion, Calendar fecha_prestamo, Calendar fecha_devolucion) {
        this.socio = codigo_socio;
        this.codigo_publicacion = codigo_publicacion;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
    }
    
    /**
     * Método set y get para socio
     */
    private String socio;

    public String getSocio() {
        return socio;
    }

    public void setSocio(String codigo_socio) {
        this.socio = codigo_socio;
    }
    /**
     * Metodo set y get para publicaciones
     */
    private String codigo_publicacion;

    public String getCodigo_Publicacion() {
        return codigo_publicacion;
    }

    public void setCodigo_Publicacion(String codigo_publicacion) {
        this.codigo_publicacion = codigo_publicacion;
    }

/** Método set y get fecha prestamo*/
    public Calendar fecha_prestamo;
    
    public Calendar getFecha_prestamo(){
        return fecha_prestamo;
    }
    
    public void setFecha_prestamo(Calendar fecha_prestamo){
        this.fecha_prestamo = fecha_prestamo;
    }
    
/** Método y get Fecha devolución*/
    
    public Calendar fecha_devolucion;
    
    public Calendar getFecha_devolucion(){
        return fecha_devolucion;
    }
    
    public void setFecha_devolucion(Calendar fecha_devolucion){
        this.fecha_devolucion = fecha_devolucion;
    }

    
    /**Método toString para mostrar los datos del prestamo */
    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return "Prestamo: " + "\n Nº de socio: " + socio+ "\n Titulo publicación: " + codigo_publicacion + "\n Fecha prestamo: "
               + formato.format(fecha_prestamo.getTime()) + "\n Fecha devolucion: " + formato.format(fecha_devolucion.getTime());
    }
    
    
    
}
