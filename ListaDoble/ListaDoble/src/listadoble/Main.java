package listadoble;

public class Main {

    public static void main(String[] args) {
    
    //Lista de peliculas
    
    ListaPeliculas misPelis = new ListaPeliculas();
    
    //Agregamos peliculas
    
    misPelis.add(new Pelicula("El señor de los Anillos", "Peter Jackson", GenerosPeliculas.FANTASIA, 4));
    misPelis.add(new Pelicula("Harry Potter 2", "Alfonso Quaron", GenerosPeliculas.FANTASIA, 3));
    misPelis.add(new Pelicula("Kill Bill", "Tarantino", GenerosPeliculas.ACCION, 5));
    misPelis.add(new Pelicula("Avengers 4", "Russo Brothers", GenerosPeliculas.ACCION, 4));
    misPelis.add(new Pelicula("Titanic", "James Cameron", GenerosPeliculas.ROMANCE, 3));
    misPelis.addAtHead(new Pelicula("Avatar 3", "James Cameron", GenerosPeliculas.ACCION, 2));
    
        System.out.println(misPelis);
        
        System.out.println("----------Buscar por título-----------");
        Pelicula peli = misPelis.buscarTitulo("avengers 4");
        System.out.println("Datos de la pelicula: " + peli);
        
        System.out.println("----------Eliminar por titulo---------");
        misPelis.remove("avengers 4");
        System.out.println(misPelis);
        
        System.out.println("--------Buscar por posicion--------");
        System.out.println("Posicion (-2): " +  misPelis.buscar(-2));
        System.out.println("Posicion (4): " +  misPelis.buscar(4));
        
        System.out.println("-------La mejor calificacion-------");
        Pelicula peli2 = misPelis.calificacionMax();
        System.out.println("Calificacion mas alta: " + peli2 + ", estrellas: " + peli2.getCalificacion());
        
        System.out.println("----Ordenar-----");
        misPelis.ordenar();
        System.out.println("El orden de las pelis por calificacion es: " + misPelis);
        misPelis.ordenarAZ();
        System.out.println("Orden por abecedario: " + misPelis);
    }
    
}
