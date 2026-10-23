package tareaPersonal;

public class Tarea {
    //--ATRIBUTOS--
    private int idTarea;
    private String descripcion;
    private int prioridad;
    private int diasRestantes;
    
    //--METODOS--
        //--CONSTRUCTOR--
    public Tarea(int idTarea, String descripcion, int prioridad, int diasRestantes) {
        this.idTarea = idTarea;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.diasRestantes = diasRestantes;
    }
    
        //--OVERRIDE QUE MUESTRA LA TAREA, DESCRIPCION Y SUS DIAS RESTANTES--
    @Override
    public String toString(){
        return idTarea + ". " + descripcion + "; Dias restantes: " + diasRestantes;
    }
    
        //--GETTERS Y SETTERS
    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getDiasRestantes() {
        return diasRestantes;
    }

    public void setDiasRestantes(int diasRestantes) {
        this.diasRestantes = diasRestantes;
    }
    
    
}
