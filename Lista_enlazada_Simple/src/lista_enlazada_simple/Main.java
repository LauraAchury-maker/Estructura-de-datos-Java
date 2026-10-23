package lista_enlazada_simple;

public class Main {
    public static void main(String[] args) {
        //Creamos una lista de edades
        ListaEdades edades = new ListaEdades();
        System.out.println("Edades: " + edades);
        edades.add(19);
        edades.add(20);
        edades.add(17);
        edades.add(18);
        System.out.println("Edades: " + edades);
    }
    
}
