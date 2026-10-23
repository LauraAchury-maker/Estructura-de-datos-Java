package tareaPersonal;

public class NodoDoble<D> {
    //--ATRIBUTOS--
    private D data;
    private NodoDoble next;
    private NodoDoble prev;
    
    //--CONSTRUCTOR--
    public NodoDoble (D data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    
    //--OVERRIDE QUE MUESTRE EL DATO DE LA LISTA--
    @Override
    public String toString(){
        return " {" + data.toString() + "}\n ";
    }
    
    //--SETTERS Y GETTERS--
    public D getData(){
        return data;
    }
    
    public void setData(D data){
        this.data = data;
    }

    public NodoDoble getNext() {
        return next;
    }

    public void setNext(NodoDoble next) {
        this.next = next;
    }

    public NodoDoble getPrev() {
        return prev;
    }

    public void setPrev(NodoDoble prev) {
        this.prev = prev;
    }
    
    
}
