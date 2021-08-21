public class GenStack<T> {//generic stack class
    private GenDoubleLinkedList<T> aStack;



    public void OperatorStack(){ //creates an empty stack
      aStack = new GenDoubleLinkedList<>();

    }





    public void push(T c){ //pushes onto the stack
        aStack.addToFront( c);

    }

    public T pop(){ //return value on top and deletes it from stack
        T x = aStack.getHeadData();

        aStack.removeT();
        return x;
    }

    public void viewStack(){ //prints stack
        aStack.printList();

    }

    public T peakTop(){ //returns what is on top of stack
        return aStack.getHeadData();

    }

    public boolean isEmpty(){
        return aStack.isEmpty();
    } //tells if the stack is empty




}
