package listadoble;

/**
 *
 * @author Laura Achury
 */
public class ListaPeliculas {

    //Atributos
    private Node2 head;
    private Node2 tail;
    private int size;

    //Constructor
    public ListaPeliculas() {
        this.head = this.tail = null;
        this.size = 0;
    }

    public ListaPeliculas(Pelicula peli) {
        Node2 aux = new Node2(peli);
        this.head = this.tail = aux;
        this.size = 1;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    //Insertar nodos
    public void add(Pelicula peli) {
        //1. crear el nodo nuevo
        Node2 aux = new Node2(peli);
        if (this.isEmpty()) {
            this.head = this.tail = aux;
        } else {
            //2. Enlazar el siguiente de la cola al nuevo

            this.tail.setNext(aux);
            aux.setPrev(this.tail);

            //3. Asignar la nueva cola
            this.tail = aux;
        }

        this.size++;

    }
    
    public Node2 buscarNode(String titulo){
        //Verifia<r si la lista esta vacia
        if(this.isEmpty()){
            System.out.println("La lista está vacía");
            return null;
        }
        Node2<Pelicula> aux = this.head; //Empieza desde la cabeza
        while(aux != null){
            if(aux.getData().getTitulo().equalsIgnoreCase(titulo)){
                return aux;
            }
            //pasar al siguiente nodo
            aux = aux.getNext();
        }
        System.out.println("La pelicula no esta en la lista");
        return null;
    }
    
    public Pelicula buscarTitulo (String titulo){
        Node2<Pelicula> peli = this.buscarNode(titulo);
        return (peli != null ? peli.getData() : null);
    }
    
    public Pelicula remove(String titulo){
        //Caso 1: la lista esta vacia
        if(this.isEmpty()){
            System.out.println("La lista está vacía");
            return null;
        }
        //Buscamos la pelicula con el metodo buscar nodo
        Node2<Pelicula> aux = buscarNode(titulo);
        if (aux == null){
            return null;
        }
        this.size --;
        
            //Caso 2: solo hay una pelicula
            if(this.head == this.tail){
                this.head = this.tail = null;
            }else if (aux == this.head){
                
            //Caso 3: La pelicula está en la cabeza
            
                this.head = this.head.getNext();//Pasa la cabeza al siguiente nodo
                this.head.setPrev(null); //desenlazar el nodo anterior de la cabeza
            }else if(aux == this.tail){
                
                //Caso 4: La pelicula está en la cola
                
                this.tail = this.tail.getPrev(); //Pasa la cola al nodo anterior
                this.tail.setNext(null); //Desenlazar el nodo anterior
                
            }else if (aux != null){
                
                //Caso 5: La pelicula eta en la mitad o dentro de la lista
                //Paso 1: Al anterior del aux le asignamos al siguiente del aux
                aux.getPrev().setNext(aux.getNext());
                //Paso 2: Al siguiente del aux le asignamos el anterior del aux
                aux.getNext().setPrev(aux.getPrev());
            }
            
        return aux.getData();
    }
    
    
    public Pelicula buscar(int index){ //index se refiere a la posicion

        if(index >= this.size || index < this.size*(-1) ){ //Recorre de cola a cabeza si es negativo
            System.out.println("Error: la posición solicitada no existe.");
            return null;
        }
        
        Node2<Pelicula> aux = null;
        if(index < 0){
            System.out.println("reversa");
            //recorrer lista hacia atrás
            aux = this.tail;
            for(int i = -1; i > index; i--){
                aux = aux.getPrev();
            }
        }else{
            //recorrer lista hacia adelante
            aux = this.head;
            for(int j = 1; j < index; j++){
                aux = aux.getNext();
            }
       }
       return aux.getData();
    }

    public int getSize() {
        return size;
    }
    
    public Pelicula calificacionMax(){
        Node2<Pelicula> aux = this.head;
        Pelicula max = aux.getData();
        while(aux != null){
            if(aux.getData().getCalificacion() > max.getCalificacion()){
                //Actualizamos MAX
                max = aux.getData();
            }
        //Pasar al iguiente nodo
        aux = aux.getNext();
        }
        return max;
    }
    
    public void ordenar(){
        for(int j = this.size -1; j > 0; j--){
            Node2<Pelicula> aux = this.head;
            for(int i = 0 ; i < j ; i++){
                Node2<Pelicula> siguiente = aux.getNext();
                if(aux.getData().getCalificacion() > 
                        siguiente.getData().getCalificacion()){
                    Pelicula temp = aux.getData();
                    aux.setData(siguiente.getData());
                    siguiente.setData(temp);
                }
                
                aux = siguiente;
            }
        }
    }
    
    public void ordenarAZ(){
        
        //Paso 1. establecer el numero de repeticiones
        for(int j = this.size -1; j > 0; j--){
            //Paso 2. Recorrer la lista desde la cabeza(por ser menor a mayor)
            Node2<Pelicula> aux = this.head;
            for(int i = 0 ; i < j ; i++){ //Me detengo en el valor de j
                //Paso 3. llamar al nodo siguiente y comparar sus titulos
                Node2<Pelicula> siguiente = aux.getNext();
                if(aux.getData().getTitulo().compareToIgnoreCase(
                        siguiente.getData().getTitulo()) > 0){
                    Pelicula temp = aux.getData(); //Guardo el dato que esta en aux
                    aux.setData(siguiente.getData()); //Cambio del dato de au por el siguiente
                    siguiente.setData(temp); //Cambiamos el dato del siguiente por el aux que se guardo en temp
                }
                //Pasar al siguiente nodo
                aux = siguiente;
            }
        }
    }
    
    public void addAtHead(Pelicula peli) {
        //1. crear el nodo nuevo
        Node2 aux = new Node2(peli);
        if (this.isEmpty()) {
            this.head = this.tail = aux;
        } else //enlazamos el anterior a head al aux
        {
            this.head.setPrev(aux);

            //enlazamos el next del aux a head
            aux.setNext(this.head);
            this.head = aux;

        }
        this.size++;
    }

    @Override
    public String toString() {
        String txt = "ListaPeliculas: {";
        Node2 aux = this.head;

        while (aux != null) {
            txt += aux.toString();
            aux = aux.getNext();
        }

        return txt;
    }

}
