public class GenQueue<T> { //generic queue class
    private GenDoubleLinkedList<T> aQueue;

    public void OperandsQueue(){ //creates an empty queue
        aQueue = new GenDoubleLinkedList<>();

    }

    public void push(T x){//adds to back of queue
        aQueue.addToBack(x);
    }

    public T pop(){//returns what is in front of queue then removes it from the queue
        T x = aQueue.getHeadData();
        aQueue.removeT();
        return x;
    }

    public void viewQueue(){//shows the queue
        aQueue.printList();
    } //prints queue

    public T peakFirst(){//returns what is at the front of the queue
        return aQueue.getHeadData();
    } //returns what is at the head of queue

    public boolean isEmpty(){ return  aQueue.isEmpty();} //tells if the queue is empty



}
