/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;
import java.sql.Date;

public class Cliente {
    private int codigo, num_telefono;
    private String email, direccion, nombre_cliente; 
    private Date fecha_nac;

    public Cliente() {
    }

    public Cliente(int codigo, int num_telefono, String email, String direccion, String nombre_cliente, Date fecha_nac) {
        this.codigo = codigo;
        this.num_telefono = num_telefono;
        this.email = email;
        this.direccion = direccion;
        this.nombre_cliente = nombre_cliente;
        this.fecha_nac = fecha_nac;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNum_telefono() {
        return num_telefono;
    }

    public void setNum_telefono(int num_telefono) {
        this.num_telefono = num_telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
    
}
