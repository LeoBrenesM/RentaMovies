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
public class Formato {
    private int codigo, precio;
    private String nombre_formato;
    
    public Formato(){}

    public Formato(int codigo, int precio, String nombre_formato) {
        this.codigo = codigo;
        this.precio = precio;
        this.nombre_formato = nombre_formato;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre_formato() {
        return nombre_formato;
    }

    public void setNombre_formato(String nombre_formato) {
        this.nombre_formato = nombre_formato;
    }
    
    
    
}
