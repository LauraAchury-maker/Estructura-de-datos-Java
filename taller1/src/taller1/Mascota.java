package taller1;

public class Mascota {
    //==ATRIBUTOS==
    private String nombre, especie;
    private int energia = 0, felicidad = 0;
    
    //==CONSTRUCTOR==
    public Mascota(String nombre, String especie) {
        this.nombre = nombre;
        this.especie = especie;
    }
    
    //==OVERRIDE==
    @Override
    public String toString() {
        return "\n=====Info de tu mascota=====" +
                "\nNombre: " + nombre +
                "\nEspecie: " + especie + 
                "\nEnergia: " + energia + "/100" +
                "\nQue tan feliz esta?: " + felicidad + "/100" +
                "\n=============================" +
                '\n';
    }
    
    //==METODOS GENERALES==
        //Primero, creamos el método de valida el minimo y el maximo de la energía y felicidad:
    public void validarLimites(){
        if (energia > 100){
            energia = 100;
        }else if(energia < 0){
            energia = 0;
        }
        
        if (felicidad > 100){
            felicidad = 100;
        }else if(felicidad < 0){
            felicidad = 0;
        }
    }
    
    public void alimentar(){
        //Validamos los limites:
        validarLimites();
        
        if(energia == 100){
            System.out.println("\n" + this.nombre + " no necesita alimentarse, tiene energia maxima!");
        }else{
            System.out.println("\n" + this.nombre + " se esta alimentado...");
            try {
                Thread.sleep(2000); // //Espera 2 segundos en lo que descansa la mascota.
            } catch (InterruptedException e) {
                e.printStackTrace(); //Si no se usa catch, java lanza error.
            }      
            System.out.println("La energia de " + this.nombre + " ha aumentado!"
                    + "\n" + this.nombre + " ha quedado muy feliz!!");     
        }
        energia += 16;
    }
    
    public void jugar(){
        //Validamos limites:
        validarLimites();
        
        if(energia <= 5){
            System.out.println("\n" + this.nombre + " no puede jugar, no tiene suficiente energia.");
        }else{
            System.out.println("\n" + this.nombre + " esta jugando..." +
                    "\nLa felicidad ha aumentado!, pero la energia ha disminuido...");
        }
        energia -= 23;
        felicidad += 15;
    }
    
    public void descansar(){
        validarLimites();
        
        if(energia == 0 || energia < 10){
            System.out.println("\n" + this.nombre + " esta descansando y recuperando energia...");
            try {
                Thread.sleep(4000); // //Espera 4 segundos en lo que descansa la mascota.
            } catch (InterruptedException e) {
                e.printStackTrace(); //Si no se usa catch, java lanza error.
            }
            System.out.println("\n" + this.nombre + " ha recuperado energia!!");
            energia = 100;
        }else{
            System.out.println(this. nombre + " no necesita recuperar energia, tiene ganas de jugar!!");
        }
    }
    
    public void mostrarEstado(){
        validarLimites();
        System.out.println(this);
    }
}
