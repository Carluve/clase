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
public class Tesis extends Publicaciones{

    public Tesis(String codigo, String isbn, String titulo, String autores, Date fecha_publicacion, String fotografia,int paginas, String coleccion, String materia, String observaciones,
                 String tribunal, String entidad, String departamento, double calificacion, String fecha_lectura, String programa) {
        super(codigo, isbn, titulo, autores, fecha_publicacion, fotografia, paginas, coleccion, materia, observaciones);
        this.tribunal = tribunal;
        this.entidad = entidad;
        this.departamento = departamento;
        this.calificacion = calificacion;
        this.fecha_lectura = fecha_lectura;
        this.programa = programa;
    }
    
    
      // Se indica el tribunal del proyecto
    private String tribunal;

    public String getTribunal() {
        return tribunal;
    }

    public void setTribunal(String tribunal) {
        this.tribunal = tribunal;
    }
    
    
    //Nombre del organismo o la universidad
    private String entidad;

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }
    
    //Indica el departamento responsable
    
    private String departamento;

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    //Indica la nota sacada
    private double calificacion;

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

     //Indica la fecha de lectura
    private String fecha_lectura;

    public String getFecha_lectura() {
        return fecha_lectura;
    }


    public void setFecha_lectura(String fecha_lectura) {
        this.fecha_lectura = fecha_lectura;
    }
    
    //Programa de doctorado al que se adscribe la tesis
    private String programa;

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    @Override
    public String toString() {
        return super.toString() + "\n Tribunal: " + tribunal + "\n Entidad: " + entidad + "\n Departamento: " + departamento + "\n Calificación: " + calificacion + "\n Fecha lectura: " + fecha_lectura + "\n Programa: " + programa;
    }

    
    
    
}
