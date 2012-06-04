/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import java.util.Date;

/**
 *
 * @author carlos.luengo
 */
public class Revistas extends Publicaciones{

    public Revistas( String codigo, String isbn, String titulo, String autores, Date fecha_publicacion,String fotografia, 
                       int paginas, String coleccion, String materia, String observaciones, String periocidad, 
                       int volumen, int numero, int anio_disponible, String localizacion) {
        super(codigo, isbn, titulo, autores, fecha_publicacion,fotografia, paginas, coleccion, materia, observaciones);
        this.periocidad = periocidad;
        this.volumen = volumen;
        this.numero = numero;
        this.anio_disponible = anio_disponible;
        this.localizacion = localizacion;
    }
    
    
    //Indica si es trimesstral, semestras o anual
    private String periocidad;

    public String getPeriocidad() {
        return periocidad;
    }

    public void setPeriocidad(String periocidad) {
        this.periocidad = periocidad;
    }
    // Numnero del volumen
    private int volumen;

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }
    /** Numero, indica el numero de la publicacion */
    
    private int numero;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    
    // Año disponible
    private int anio_disponible;

    public int getAnio_disponible() {
        return anio_disponible;
    }

    public void setAnio_disponible(int anio_disponible) {
        this.anio_disponible = anio_disponible;
    }

    //Regleja la ubicación actual del ejemplar
    private String localizacion;

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    @Override
    public String toString() {
        return super.toString() + "\n Periocidad: " + periocidad + "\n Volumen: " + volumen + "\n Numero: " + numero + "\n Año disponible: " + anio_disponible + "\n Localización: " + localizacion ;
    }



}
