/*
 * Esta clase hereda de una superior Publicaciones para agregar unos
 * atributos especificos que contienen los libros
 */
package Biblioteca;


import java.util.Date;

/**
 *
 * @author carlos.luengo
 */
public class Libro extends Publicaciones  {

    /**Constructor de libro, como vemos hereda de la principal */
    
    public Libro(String codigo, String isbn, String titulo, String autores, Date fecha_publicacion, 
                 String fotografia,int paginas, String coleccion, String materia, String observaciones, String editorial, 
                 String localidad, String Contenido, String edicion, String localizacion) {
        super(codigo, isbn, titulo, autores, fecha_publicacion,fotografia, paginas, coleccion, materia, observaciones);
        this.editorial = editorial;
        this.localidad = localidad;
        this.Contenido = Contenido;
        this.edicion = edicion;
        this.localizacion = localizacion;
    }
  
    
    
    /**Indentifica la editorial que ha publicado el libro */
    private String editorial;

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    
    // Indica la localidad de publicacion
    private String localidad;

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    //Pequeño resumen de la obra
    private String Contenido;

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String Contenido) {
        this.Contenido = Contenido;
    }

    //Refleja la edicion de la obra
    private String edicion;

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }
    
    //Ubicación fija del ejemplar
    private String localizacion;

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    @Override
    public String toString() {
        return super.toString() +"\n Editorial: " + editorial + "\n Localidad: " + localidad + "\n Contenido: " + Contenido + "\n Edición: " + edicion + "\n Localizacion: " + localizacion;
    }


}
