package listadoble;

public class Pelicula {

    private String titulo;
    private String director;
    private GenerosPeliculas genero;
    private int calificacion;

//Metodos//
    public Pelicula(String titulo, String director, GenerosPeliculas genero, int calificacion) {
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return titulo + " : " + director;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public GenerosPeliculas getGenero() {
        return genero;
    }

    public void setGenero(GenerosPeliculas genero) {
        this.genero = genero;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

}
