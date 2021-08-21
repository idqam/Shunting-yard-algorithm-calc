public class GenNodes<T> { //generic double-linked nodes

    private T data;
    private GenNodes<T> next; //points to next node [A] -> [B]
    private GenNodes<T> prev;  //points to prev node [A] <- [B]


    public GenNodes(){ //below are three constructors of the generic nodes
        next = null;
        prev = null;
        data = null;

    }

    public GenNodes(T data){
        this.data = data;
        this.prev = null;
        this.next = null;

    }

    public GenNodes(T data, GenNodes<T> next, GenNodes<T> prev){
        this.data = data;
        this.next = next;
        this.prev = prev;


    }

    public void setNext(GenNodes<T> next){ //sets next pointer
        this.next = next;


    }

    public void setPrev(GenNodes<T> prev){ //sets prev pointer
        this.prev = prev;

    }



    public void setData(T data){
        this.data = data;
    } //sets value of node

    public GenNodes<T> getNext() {
        return next;
    } //returns the next node

    public GenNodes<T> getPrev() {
        return prev;
    } //returns the prev node

    public T getData() {
        return data;
    } //returns value of node



}
