public class GenDoubleLinkedList<T> {//generic double linked list

    private GenNodes<T> head, tail; //node

    private int numOfNodes = 0; //stores length of list

    public boolean isEmpty(){ return  head == null;} //tells whether the node is empty

    public boolean hasNext(){return head != null; } //returns if the node points to another node

    public void addToFront(T data){//generic method to add to front
        GenNodes<T> aNode = new GenNodes<>(data);
        aNode.setData(data);
        aNode.setNext(this.head);
        if(head == null){
            head = aNode;
            tail = aNode;


        }else{
            head.setPrev(aNode);
            head = aNode;
            numOfNodes += 1;
        }
    }

    public void addToBack(T data){ //generic method to add to back
        GenNodes<T> aNode = new GenNodes<>(data);
        aNode.setData(data);
        if(head == null){
            tail = aNode;
            head = aNode;
            head.setPrev(null);
            tail.setNext(null);
        }else{
            tail.setNext(aNode);
            aNode.setPrev(tail);
            tail = aNode;
            tail.setNext(null);
            numOfNodes += 1;
        }

    }

    public void printList(){ //prints list
        GenNodes<T> current = head;
        if(current == null){
            System.out.println("The list is empty");
            return;

        }
        while (current != null){
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }

        System.out.println();

    }

    public T getHeadData(){//gets value of head
        if(head == null){
            return null;
        }
        return head.getData();
    }

    public void removeT(){//removes from top
        GenNodes<T> succNode = new GenNodes<>();
        GenNodes<T> preccNode =  new GenNodes<>();
        GenNodes<T> currNode =  new GenNodes<>();

        currNode = head;
        if(currNode == null){
            return;
        }

        succNode = currNode.getNext();
        preccNode = currNode.getPrev();



        if(succNode != null){
            succNode.setPrev(preccNode);
        }
        if(preccNode != null){
            preccNode.setNext(succNode);
        }

        if(currNode == head){
            head = succNode;
        }
        if(currNode == tail){
            tail = preccNode;
        }

    }












}
