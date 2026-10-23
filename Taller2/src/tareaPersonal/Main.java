package tareaPersonal;

/**
 * @author Laura Camila Achury Castro
 */
public class Main {
    
    public static void main(String[] args) {
        
        //Lista de tareas
        ListaTareas misTareas = new ListaTareas();
        
        //Agregamos tareas:
        misTareas.add(new Tarea(1, "Hacer mercado", 1, 3));
        misTareas.add(new Tarea(2, "Entregar proyecto de programacion", 3, 1));
        misTareas.add(new Tarea(3, "Leer el capitulo del libro", 2, 6));
        misTareas.add(new Tarea(4, "Estudiar para el parcial de calculo", 3, 2));
        misTareas.add(new Tarea(5, "Limpiar el escritorio", 1, 5));
        misTareas.add(new Tarea(6, "Terminar ejercicio de Java", 2, 2));
        
        System.out.println(misTareas);
        
        System.out.println("=====BUSCAR POR ID=====");
        //Creamos variables como tareas para buscarlas:
        Tarea tarea = misTareas.buscarPorId(2);
        Tarea tarea2 = misTareas.buscarPorId(3);
        System.out.println("La tarea de ID 2 es: " + tarea);
        System.out.println("La tarea de ID 3 es: " + tarea2);
        
        System.out.println("\n=====BUSCAR POR NUMERO DE POSICION====");
        System.out.println("Posicion (-5): " + misTareas.buscarPosicion(-5));
        System.out.println("Posicion (4): " + misTareas.buscarPosicion(4));
        System.out.println("Posicion (0): " + misTareas.buscarPosicion(0));
        
        System.out.println("\n======ELIMINAR POR ID=====");
        misTareas.remove(4);
        misTareas.remove(1);
        System.out.println("La lista con las tareas 4 y 1 eliminadas es: " + misTareas);
        
        System.out.println("\n======TAREAS TOTALES======");
        System.out.println("Cantidad de tareas: " + misTareas.cantidadTareas());
        System.out.println("\n=====MOSTRAR CABEZA A COLA=====");
        misTareas.mostrarCabezaCola();
        System.out.println("\n=====MOSTRAR COLA A CABEZA=====");
        misTareas.mostrarColaCabeza();
        
        System.out.println("\n=====TAREA MAS PROXIMA A VENCER=====");
        System.out.println("Tarea: " + misTareas.menosDias());
        
        System.out.println("\n=====TAREAS QUE SUPERAN O IGUALAN NIVEL DE PRIORIDAD=====");
        System.out.println("Tareas con prioridad 1 o mayor: " + misTareas.conteoPrioridad(1));
        System.out.println("Tareas con prioridad 2 o mayor: " + misTareas.conteoPrioridad(2));
        System.out.println("Tareas con prioridad 3 o mayor: " + misTareas.conteoPrioridad(3));
    }
}
