package lista_enlazada_simple;

public class Node <T>{
    //==ATRIBUTOS==
    private T data; //T es el tipo de dato que va adentro del diamante <>
    private Node next; //Next apunta al siguiete nodo
    //==METODOS==
        //==CONSTRUCTOR==
    
    public Node(T data){
        this.data = data;
        this.next = null;
    }
    
    public void enlazar(Node<T> newNode){
        this.next = newNode;
    }

    public T getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" + data + "} ->";
    }
    
    
}
