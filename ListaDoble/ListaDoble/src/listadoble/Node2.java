package listadoble;

/**
 * Node 2 -> implementa un nodo doble
 *
 */
public class Node2<T> {

    //Atributos
    private T data;
    private Node2 next;
    private Node2 prev;

    //Contructor 
    public Node2(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return "{" + data.toString() + '}';
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node2 getNext() {
        return next;
    }

    public void setNext(Node2 next) {
        this.next = next;
    }

    public Node2 getPrev() {
        return prev;
    }

    public void setPrev(Node2 prev) {
        this.prev = prev;
    }

}
