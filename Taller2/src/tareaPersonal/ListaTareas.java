package tareaPersonal;

//Uso de listas dobles para gestionar tareas del día a día

public class ListaTareas {
    //--ATRIBUTOS--
    private NodoDoble head;
    private NodoDoble tail;
    private int size;
    
    
    //--METODOS--
    //--CONSTRUCTORES--
        //--SI LA LISTA ESTÁ VACÍA--
    public ListaTareas(){
        this.head = this.tail = null;
        this.size = 0;
    }
    
        //--SI LA LISTA NO ESTÁ VACÍA--
    public ListaTareas(Tarea tarea){
        NodoDoble aux = new NodoDoble(tarea);
        this.head = this.tail = aux;
        this.size = 1;
    }
    
    //--OVERRIDE DE LA LISTA DE TAREAS--
    @Override
    public String toString(){
        String txt = "Tu lista de tareas: {";
        NodoDoble aux = this.head;
        
        while (aux!= null){
            txt += aux.toString();
            aux = aux.getNext();
        }
        return txt + " }";
    }
    
        //--MÉTODO PARA EL CASO DE QUE LA LISTA ESTÉ VACÍA--
    public boolean isEmpty(){
        return this.size == 0;
    }
    
    /*
    Lista de requerimientos marcada con OK's:
    Inserción flexible: Agregar tareas al inicio (urgentes) o al final de la lista. OK
    Eliminación por identificador: Remover una tarea específica buscando por su idTarea. OK
    Búsqueda directa: Encontrar y retornar una tarea a partir de su idTarea. OK
    Acceso por posición: Consultar los datos de una tarea según su índice numérico dentro de la lista. OK
    
    Métricas generales: Determinacion del número total de tareas almacenadas y mostrar 
    el contenido completo de la lista recorriéndola tanto de inicio a fin como de fin a inicio. OK
    
    Métodos analíticos avanzados:
    Implementar un método que devuelva la tarea con el menor valor en diasRestantes (la más próxima a vencer). OK
    Implementar un método que cuente y devuelva cuántas tareas superan o igualan un nivel de prioridad determinado por parámetro. OK
    */
    
    //1. Inserción flexible
    public void add(Tarea tarea){
        //Creamos el nodo nuevo
        NodoDoble aux = new NodoDoble(tarea);
        
        if(this.isEmpty()){
            this.head = this.tail = aux;
        }else if (tarea.getPrioridad() > 2){
            //Si la lista de tareas no está vacía, primero comprobamos 
            //el nivel de prioridad que en este caso, lo pongo de 1 a 3. 
            
            //Enlazamos a la cabeza, ya que es una tarea de nivel 3:
            this.head.setPrev(aux); //Con esta linea se apunta a aux antes de la cabeza, primer enlace hecho
            aux.setNext(this.head); //Con esta linea apuntamos a la cabeza desde aux, teniendo enlace doble.
            
            //Asignamos la nueva cabeza
            this.head = aux;
            
        }else if (tarea.getPrioridad() < 2){
            //Enlazamos a la cola, es una tarea nivel 1:
            this.tail.setNext(aux);
            aux.setPrev(this.tail);
            
            //Asignamos la nueva cola con la misma lógica de la cabeza:
            this.tail = aux;
           
        }else if (tarea.getPrioridad() == 2){
            //Si la tarea es 2, la ponemos en el medio:
            //Primero, recorremos la lista para comparar si hay prioridad menor a 2, 
            //creamos un nodo que recorra la lista:
            
            NodoDoble<Tarea> actual = this.head; //Empezamos por la cabeza
            while (actual != null &&
                    actual.getData().getPrioridad() >= 2){
                
                actual = actual.getNext(); //Sigue buscando hasta que sea 1, 
                //para insertar el nodo antes de la baja prioridad
            }
            
            //Cuando el while pare, ya podemos saber lo que esta anterior
            NodoDoble<Tarea> anterior = actual.getPrev();
            
            //Caso especial: Si la tarea es igual a null y no hay tareas de prioridad 1
            //Podríamos asignar la tarea como nueva cola:
            if(actual == null){
                this.tail.setNext(aux);
                aux.setPrev(this.tail);
                this.tail = aux;
            }else{
            
                //Ya sabiendo las posiciones, ponemos aux entre los dos:
                aux.setPrev(anterior);
                aux.setNext(actual);
            
                //Enlazamos otra vez de anterior y actual apuntando 
                //a aux para que quede doblemente enlazada
                anterior.setNext(aux);
                actual.setPrev(aux);
            }
        }
        
        //Agregamos cada tarea en la lista
        size ++;
    }
    
    //2. Eliminación por identificador
    public Tarea remove(int idTarea){
        //Caso 1. La lista esta vacia
        if(this.isEmpty()){
            System.out.println("La lista esta vacia");
            return null;
        }
        
        //Caso 2. La tarea si esta en la lista
        //Hay que recorrer la lista con su ID
        
        //1. Nombramos la tarea actual y empezamos por la cabeza
        NodoDoble<Tarea> actual = this.head;
        
        //2. Recorremos con while
        while(actual != null){
            if (actual.getData().getIdTarea() == idTarea){ // aplica la logica solo hasta que coincida el ID
                
                //Caso 2.1: La tarea es la cabeza y cola, hay una tarea.
                if(actual.getPrev() == null &&
                        actual.getNext() == null){
                    this.head = this.tail = null;
                }else if(actual.getPrev() == null){
                    //Caso 2.2: La tarea está en la cabeza
                    NodoDoble<Tarea> siguiente = actual.getNext();
                    this.head = siguiente; //Asignamos como cabeza el siguiente de actual
                    this.head.setPrev(null); //Asignamos vacío al anterior de la cabeza
                }else if(actual.getNext() == null){
                    //Caso 2.3: La tarea está en la cola
                    NodoDoble<Tarea> anterior = actual.getPrev();
                    this.tail = anterior;
                    this.tail.setNext(null);
                }else{
                    //Caso 2.4: La tarea está en el medio de la lista:
                    NodoDoble<Tarea> anterior = actual.getPrev();
                    NodoDoble<Tarea> siguiente = actual.getNext();
                
                    //Enlazamos anterior a siguiente
                    anterior.setNext(siguiente);
                
                    //Enlazamos siguiente a anterior
                    siguiente.setPrev(anterior);
                }
                
                //Eliminamos una tarea
                size--;
                
                return actual.getData();
            }
            actual = actual.getNext(); //Si no encuentra el id pasa al siguiente y aplica el while
            //hasta que no sea null.
        }
        
        //El ID no se encontró
        return null;
    }
    
    //3. Búsqueda directa
    public Tarea buscarPorId(int idTarea){
        //Caso 1: La lista está vacía:
        if(this.isEmpty()){
            System.out.println("La lista esta vacia");
            return null;
        }
        
        //Caso 2: El Id coincide
            //1. Creamos el nodo del Id actual empezando por la cabeza
        NodoDoble<Tarea> actual = this.head;
        
            //2. Creamos el while siguiendo la lógica del metodo remove
        while(actual != null){
            if(idTarea == actual.getData().getIdTarea()){
                return actual.getData(); //Retorna la tarea por id que estas buscando.
            }
        
            actual = actual.getNext(); //Sigue buscando hasta que coincida el ID
        
        }
        return null; //Caso en que no encuentre el ID
    }
    
    //4. Acceso por posición
    public Tarea buscarPosicion(int index){ //index = posicion
        
        /*
        NOTA IMPORTANTE DE ESTE METODO:
        Para verificar las posiciones, este metodo selecciona la posicion que
        ordenó en el método add, po lo que no va a coincidir con ID
        */
        
        //1. Definimos las posiciones para que algun numero fuera sea inválido.
        if(index >= this.size || index < this.size*(-1) ){ //Recorre de cola a cabeza si es negativo
            System.out.println("Error: la posición solicitada no existe.");
            return null;
        }
        
        /*
        Nota personal:
        Ejemplo: supongamos que size = 4;
        Las posiciones validas son: 
        positivas desde cabeza: 0, 1, 2, 3 (por eso index no puede ser igual a 4)
        negativas desde cola: -1, -2, -3, -4 (Aqui si se empieza a contar desde 4)
        */
        
        //2. Creamos el nodo siendo null para que luego podamos iniciarlo en la cabeza o en la cola
        NodoDoble<Tarea> aux = null;
        if(index < 0){ //Si index es menor a 0, quiere decir que se recorre la lista de derecha a izquierda
            aux = this.tail;
            for(int i = -1; i > index; i--){
                aux = aux.getPrev();
            }
        }else{
            //Recorrer la lista hacia adelante
            aux = this.head;
            for(int j = 0; j < index; j++){
                aux = aux.getNext();
            }
        }
        return aux.getData();
    }
    
    //5. Determinacion del número total de tareas almacenadas y mostrar contenido completo
    public int cantidadTareas(){
            return this.size;
    }
    
    public void mostrarCabezaCola(){
        NodoDoble<Tarea> actual = this.head;
        
        while (actual != null){
            System.out.println(actual.getData());
            actual = actual.getNext();
        }
    }
    
    public void mostrarColaCabeza(){
        NodoDoble<Tarea> actual = this.tail;
        
        while (actual != null){
            System.out.println(actual.getData());
            actual = actual.getPrev();
        }
    }
    
    //6. Método que devuelva la tarea con el menor valor en diasRestantes (la más próxima a vencer).
    public Tarea menosDias(){
        //Si la lista está vacía:
        if(this.isEmpty()){
            return null;
        }
        //Iniciamos para recorrer la lista desde la cabeza
        NodoDoble<Tarea> aux = this.head;
        
        //Creamos variable min tipo tarea para compararla
        Tarea min = aux.getData();
        while(aux !=  null){
            if(aux.getData().getDiasRestantes() < min.getDiasRestantes()){
                //Actualizamos el minimo
                min = aux.getData();
            }
        //Pasa al siguiente nodo si no es menor al minimo a comparar
        aux = aux.getNext();
        }
        return min;  
    }
    
    //7. Implementar un método que cuente y devuelva cuántas tareas superan o igualan un nivel de prioridad determinado por parámetro.
    public int conteoPrioridad(int prioridad){
        
        //Para este método, necesitamos contar cuantas tareas tienen determinado nivel de prioridad.
        //Querermos saber cuantas hay de dicha prioridad o mayor.
        //Iniciamos una variable tipo entero para que haga el conteo y retorne:
        
        int contador = 0;
        
        //Creamos nodo actual que inicie recorrido por cabeza:
        NodoDoble<Tarea> actual = this.head;
        
        while(actual != null){
            if(actual.getData().getPrioridad() >= prioridad){
                contador ++;
            }
            actual = actual.getNext();
        }
        
        return contador;
    }
}
