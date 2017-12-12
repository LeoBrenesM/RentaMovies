/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

/**
 *
 * @author lbren
 */
public class ejemplar_pelicula {
    
    private int codigo_ejemplar;
    private String nombre_peli;
    
    public ejemplar_pelicula(){ }

    public ejemplar_pelicula(int codigo_ejemplar, String nombre_peli) {
        this.codigo_ejemplar = codigo_ejemplar;
        this.nombre_peli = nombre_peli;
    }

    public int getCodigo_ejemplar() {
        return codigo_ejemplar;
    }

    public void setCodigo_ejemplar(int codigo_ejemplar) {
        this.codigo_ejemplar = codigo_ejemplar;
    }

    public String getNombre_peli() {
        return nombre_peli;
    }

    public void setNombre_peli(String nombre_peli) {
        this.nombre_peli = nombre_peli;
    }
    
    
    
}
