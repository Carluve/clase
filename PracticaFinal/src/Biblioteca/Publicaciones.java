/*
 * Clase principal de publicación de aqui heredaran todas las
 * publicaciones que se añadan a la biblioteca
 */
package Biblioteca;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author carlos.luengo
 */
public class Publicaciones implements Serializable {
      
    public Publicaciones() {
    
    }
    
    public Publicaciones(String codigo, String isbn, String titulo, String autores, Date fecha_publicacion, String fotografia, int paginas, 
                         String coleccion, String materia, String observaciones) {
        this.codigo = codigo;
        this.isbn = isbn;
        this.titulo = titulo;
        this.autores = autores;
        this.fecha_publicacion = fecha_publicacion;
        this.fotografia = fotografia;
        this.paginas = paginas;
        this.coleccion = coleccion;
        this.materia = materia;
        this.observaciones = observaciones;
    }

    
  
    
    // Codigo de la publicación : código de control interno de la publicación
    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    // ISBN: es la identificación única para una publicación
    private String isbn;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    //Titulo: titulo de las publicaciones.
    private String titulo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Autores: nombre y apellido de los autores
    private String autores;

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }
    
    // La fecha en la que fue publicada
    private Date fecha_publicacion;

    public Date getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(Date fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }
    
    // Foto: portada de la caratula de la publicación 
    private String fotografia;

    
    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }
//Numero de páginas de la publicación
    private int paginas;

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
    
    //Indica si pertenece a una colección o no (true/false)
    private String coleccion;

    public String getColeccion() {
        return coleccion;
    }
    
    public void setColeccion(String coleccion) {
        this.coleccion = coleccion;
    }
   
    
    //Indica la materia de la publicación
    
    private String materia;

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
    
    // Texto libre para indicar cualquier dato interesante 
    private String observaciones;

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Publicacion: " + "\n Codigo: " + codigo + "\n ISBN: " + isbn + "\n Titulo: " + titulo + "\n Autores: " + autores + "\n Fecha publicación: " + fecha_publicacion + "\n Paginas: " + paginas + "\n Coleccion: " + coleccion + "\n Materia: " + materia + "\n Observaciones: " + observaciones;
    }

    
    
}
