package source;

public class Ejemplar {
    
    private int id_ejemplar, id_pelicula, id_formato;
    
    public Ejemplar(){ }

    public Ejemplar(int id_ejemplar, int id_pelicula, int id_formato) {
        this.id_ejemplar = id_ejemplar;
        this.id_pelicula = id_pelicula;
        this.id_formato = id_formato;
    }

    public int getId_ejemplar() {
        return id_ejemplar;
    }

    public void setId_ejemplar(int id_ejemplar) {
        this.id_ejemplar = id_ejemplar;
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public int getId_formato() {
        return id_formato;
    }

    public void setId_formato(int id_formato) {
        this.id_formato = id_formato;
    }
    
    
}
