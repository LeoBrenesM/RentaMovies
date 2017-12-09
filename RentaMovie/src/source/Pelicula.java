package source;

import java.sql.Date;

public class Pelicula {
    
    private int id, id_director;
    private String nombre_pelicula;
    private Date fecha_salida;
    
    public Pelicula(){}

    public Pelicula(int id, int id_director, String nombre_pelicula, Date fecha_salida) {
        this.id = id;
        this.id_director = id_director;
        this.nombre_pelicula = nombre_pelicula;
        this.fecha_salida = fecha_salida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_director() {
        return id_director;
    }

    public void setId_director(int id_director) {
        this.id_director = id_director;
    }

    public String getNombre_pelicula() {
        return nombre_pelicula;
    }

    public void setNombre_pelicula(String nombre_pelicula) {
        this.nombre_pelicula = nombre_pelicula;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }
    
}
