package taller1;

public class Videojuego {
    //==ATRIBUTOS==
    private String nombre, genero;
    private int nivel = 1, puntos = 0;
    
    //==CONSTRUCTOR==
    public Videojuego(String nombre, String genero) {
        this.nombre = nombre;
        this.genero = genero;
    }
    
    //==OVERRIDE==
    @Override
    public String toString() {
        return "\n===Info de tu videojuego===" +
                "\nNombre: " + nombre + 
                "\nGenero: " + genero + 
                "\nNivel: " + nivel + 
                "\nPuntos: " + puntos + 
                "\n==========================";
    }
    
    //==METODOS GENERALES==
    public void subirNivel(){
        nivel++;
        System.out.println("\nSu nivel actual es: " + nivel);
    }
    
    public void ganarPuntos(int cantidad){
        if(cantidad <= 0){
            System.out.println("\nNo puede en el juego de " + this.nombre + " quitar puntos.");
        }else{
            puntos += cantidad;
            System.out.println("\nPuntos adquiridos: " + this.puntos);
        }
    }
    
    public void reiniciarJuego(){
        nivel = 1;
        puntos = 0;
    }
    
    public void mostrarEstado(){
        System.out.println(this);
    }
}
