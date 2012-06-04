/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author carlos.luengo
 */
public class Persona implements Serializable {

    public Persona(String nombre, String DNI, String codigo_socio, String categoria_socio) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.codigo_socio = codigo_socio;
        this.categoria_socio = categoria_socio;
        this.fecha_alta = fn;
    }
    
    Date d = new GregorianCalendar().getTime();
    String fn = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT).format(d);    
    
    
    //Nombre y apellidos del socio
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    //DNI del socio
    private String DNI;

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    //Codigo del socio (Tiene que estar conformado por 5 cifras + a(alumno) o p (profesor)
    private String codigo_socio;

    public String getCodigo_socio() {
       
        return codigo_socio;
    }

    public void setCodigo_socio(String codigo_socio) {
        this.codigo_socio = codigo_socio;
    }
    
    //Indica si es profesor o alumno
    private String categoria_socio;

    public String getCategoria_socio() {
        return categoria_socio;
    }

    public void setCategoria_socio(String categoria_socio) {
        this.categoria_socio = categoria_socio;
    }
    
    
    //fecha en la que el socio se dio de alta
    private String fecha_alta;

    public String getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(String fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    @Override
    public String toString() {
        return"\n Nombre: " + nombre + "\n DNI: " + DNI + "\n Codigo Socio: " + codigo_socio + "\n Categoria: " + categoria_socio + "\n Fecha de alta: " + fecha_alta ;
    }


}
