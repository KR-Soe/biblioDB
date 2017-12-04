/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JOptionPane;
import sun.security.util.Length;

/**
 *
 * @author LENOVO L450
 */
public class Libro {
    private int isbn;
    private int anno;
    private String nombre;
    private String autor;
    private String editorial;
    private String tipo;
    private boolean prestamo;
    private int mes;
    
    public Libro() {
    }

    public Libro(int isbn, int anno, String nombre, String autor, String editorial, String tipo, boolean prestamom, int mes) {
        this.isbn = isbn;
        this.anno = anno;
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.tipo = tipo;
        this.prestamo = prestamo;
        this.mes = mes;
    }
    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        if (anno <=2017){
            this.anno = anno;
        }else{
            JOptionPane.showMessageDialog(null, "Año no valido");
        }
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if(mes >= 1 && mes <=12){
            this.mes = mes;
        }else{
            JOptionPane.showMessageDialog(null, "Mes No valido");
        }
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isPrestamo() {
        return prestamo;
    }

    public void setPrestamo(boolean prestamo) {
        this.prestamo = prestamo;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setId(int id) {
            this.isbn = isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) throws Exception {       
            this.autor = autor;        
    }

    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", anno=" + anno + ", nombre=" + nombre + ", autor=" + autor + ", editorial=" + editorial + ", tipo=" + tipo + ", prestamo=" + prestamo + '}';
    } 
}
