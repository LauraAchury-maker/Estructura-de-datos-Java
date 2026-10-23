package listas;

public class Estudiante {
   //--ATRIBUTOS--
    private String nombre;
    private int edad;
    private String carrera;
    private double promedio;
    
    //--METODOS--

    public Estudiante(String nombre, int edad, String carrera, double promedio) {
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = carrera;
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Datos del Estudiante: " + 
               "\nNombre: " + nombre + 
               "\nEdad: " + edad + 
               "\nCarrera: " + carrera + 
               "\nPromedio: " + promedio;
    }
    //--GETTERS DE TODOS LOS ATRIBUTOS--

    public String getNombre() {return nombre;}
    public int getEdad() {return edad;}
    public String getCarrera() {return carrera;}
    public double getPromedio() {return promedio;}
    
}
