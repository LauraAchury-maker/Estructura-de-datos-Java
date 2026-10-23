package taller1;

import java.util.Scanner;

/**
 * @author Laura Camila Achury Castro
 */

public class Taller1 {
public static Scanner input = new Scanner(System.in);
    
    //Repaso de clases y objetos de P.O.O (Taller 1er corte 05/08/26)

    public static void main(String[] args) {
        String m = """
                   
                   ===============MENU===============
                   Ingrese un numero del 1 al 3 para
                   navegar por cada programa.
                   Ingrese 0 para salir del programa.
                   ==================================
                   """;
        
    //Iniciamos un bucle infinito para que se ejecute siempre
    //el menu que dirija el usuario a navegar por los puntos
    
        while(true){
            System.out.println(m);
            int u = input.nextInt();
            if (u == 0){
                System.out.println("\nGracias por revisar :D!");
                break;
            }
            switch(u){
                case 1-> punto1();
                case 2-> punto2();
                case 3-> punto3();
                default -> System.out.println("Introduzca un numero valido.");
            }
        }
    }
    
    public static void punto1(){
        //Creamos el objeto apartir de la clase "CuentaBancaria":
        CuentaBancaria usuario = new CuentaBancaria(123456789, "Laura", 5000);
        
        //Ponemos a prueba los métodos con restricciones:
        usuario.depositar(-1000);
        usuario.depositar(400);
        usuario.depositar(600);
        
        usuario.retirar(-300);
        usuario.retirar(300);
        usuario.retirar(6000.45);
        
        usuario.mostrarInformacion();
        
        usuario.consultarSaldo();
    }
    
    public static void punto2(){
        //Creamos el objeto apartir de la clase Videojuego:
        Videojuego v1 = new Videojuego("Fears to Fathom", "Terror psicologico");
        
        //Simulamos acciones con los metodos:
        v1.subirNivel();
        
        v1.ganarPuntos(100);
        v1.ganarPuntos(-100);
        
        //Antes de reiniciar, vemos el avance del videojuego:
        v1.mostrarEstado();
        
        //Reiniciamos y mostramos información:
        v1.reiniciarJuego();
        v1.mostrarEstado();
    }
    
    public static void punto3(){
        //Vamos a crear una mascota a partir de la clase Mascota:
        Mascota m1 = new Mascota("Licenciado Patacon", "Gato");
        
        //Tenemos la energía en 0, así que
        //primero mostramos estado y pongo al maximo la energia descansando:
         m1.mostrarEstado();
         m1.descansar();
         m1.descansar();
         
        //ponemos a la mascota hacer de todo:
         m1.jugar();
         m1.jugar();
         m1.jugar();
         m1.alimentar();
         m1.mostrarEstado();
         m1.jugar();
         m1.jugar();
         m1.jugar();
         m1.alimentar();
         m1.mostrarEstado();
         m1.jugar();
         m1.mostrarEstado();
         m1.descansar();
         m1.mostrarEstado();
    }
}
