package listas;
//IMPORTAMOS LAS LIBRERIAS SIEMPRE DEBAJO DEL PAQUETE 
import java.util.ArrayList; //Libreria para usar listas enlazadas 

public class Principal {

    public static void main(String[] args) {
        //creamos la lista de estudiantes 
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
        listaEstudiantes.add( new Estudiante("Juan",  19, "Sistemas",85) );
        listaEstudiantes.add( new Estudiante("Maria", 21, "Ciencia Datos", 90) );
        listaEstudiantes.add( new Estudiante("Laura", 18, "Comunicaciones", 75) );
        listaEstudiantes.add( new Estudiante("David", 20, "Sistemas", 53) );
        listaEstudiantes.add( new Estudiante("Sofia", 19, "Administracion", 65) );
        listaEstudiantes.add( new Estudiante("Camilo",22, "Mecatronica", 78) );
        //Imprimimos la lista
        System.out.println(listaEstudiantes);
        
    }
    public static void apuntesListas(){
        // Crearmos una instancia de Arraylist para guardar nombres 
        ArrayList<String> listaNombres = new ArrayList<>();
        listaNombres.add("Juan");
        listaNombres.add("Maria");
        listaNombres.add("Ana");
        listaNombres.add("David");
        listaNombres.add("Sofia");
        listaNombres.add("Camilo");
        //imprimimos cuantos elementos hay en la lista con .size()
        System.out.println("Nombres en la lista: " + listaNombres.size());
        //Imprimimos la lista de nombres
        System.out.println(listaNombres);
        
        //eliminamos a ana de la lista 
        listaNombres.remove(2);
        System.out.println("eliminamos el nombre en la poscion 2");
        System.out.println(listaNombres);
        //agregamos a laura en la posicion 2
        listaNombres.add(2, "Laura");
        System.out.println(listaNombres);
        
        //Cuantas letras tiene el nombre en la pos 3
        int numLetras = listaNombres.get(3).length(); //.length() para saber el numero de letras 
        System.out.println(listaNombres.get(3) + " tiene " + 
                numLetras + " letras");
    }
    
}
