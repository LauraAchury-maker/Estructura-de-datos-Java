package lista_enlazada_simple;

public class ListaEdades {
    //==ATRIBUTOS==
    Node<Integer> head;
    
    //==METODOS==
        //==CONSTRUCTORES==
        //Constructor vacío:
    public ListaEdades(){
        this.head = null; //Se crea la lista vacía
    }
    
    public boolean isEmpty(){
        return this.head == null;
    }
        //Constructor con dato tipo nodo adentro:
    public ListaEdades(Integer edad){
        this.head = new Node<>(edad);
    }
    //==MI LISTA==
        //Pasos para enlazar la lista con otra cosa:
            //1. Crear Nodo Nuevo
            //1.5. Si no hay cabeza se asigna como la cabeza
            //2. Buscar la cola
            //3. Enalazar la cola cola con el nodo nuevo a agregar
    
    
        //Método par buscar la cola (tail)
    
    public Node getTail(){
        Node aux = this.head;
        
        while(aux.getNext() != null){ //Repite mientras ue Next es diferente de null
            aux = aux.getNext();
        }
        return aux;
    }
    
    public void add(Integer edad){
        Node nodoNuevo = new Node<>(edad); //Paso 1: Crear el nodo con la edad nueva
        if (this.isEmpty()){
            this.head = nodoNuevo; //Paso 1.5: Si no hay cabeza, el nodo nuevo pasa a ser la cabeza de la lista.
            return;
        }
        Node cola = getTail(); //Paso 2: Buscar la cola
        cola.enlazar(nodoNuevo); //Paso 3: Enalazar NodoNuevo a cola
        
    }

    @Override
    public String toString() {
        String txt = "";
        
        if(this.isEmpty()){
            return "La lista esta vacia.";
        }
        
        Node aux = this.head;
        while (aux.getNext() != null){
            txt += aux.toString();
            aux = aux.getNext();
        }
        
        return txt += aux.toString();
    }
    
    public Integer remove(int edad){
        //Caso 1. Cuando la lista está vacía
        if(this.isEmpty()){
            System.out.println("Error: Lista vacía");
            return null;
        }
        //Caso 2. El dato esta en la cabeza
        if(this.head.getData() == edad){
            this.head = this.head.getNext();
            return this.head.getData();
        }
        //Caso 3. El dato esta dentro de la lista
            //Paso 1. Encontrar el nodo anterior al dato
        Node<Integer> aux = this.head; //Empezamos a buscar por la cabeza
        while(aux.getNext() != null){
            if( (int) aux.getNext().getData() == edad){
                //Si encuentra el dato vamos al paso 2
                //Paso 2. Enlazar el aux con el siguiente del siguiente
                int edadEliminada = (int) aux.getNext().getData();
                aux.enlazar(aux.getNext().getNext());
                return edadEliminada;
            }
            //Si no encontramos el dato, pasamos al siguiente
            aux = aux.getNext();
        }
        //Caso 4. El dato no está en la lista
        System.out.println(edad + " no está en la lista.");
        return null;
    }
    
    
}
