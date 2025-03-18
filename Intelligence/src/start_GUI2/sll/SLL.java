package start_GUI2.sll;

public class SLL {

    private Node head;

    public void addToFront(int data){

        head = new Node(data, head);

        /*if(head == null){
            head = new Node(data);
            return;
        }

        Node temp = new Node(data, head);
        head = temp;*/
    }

    public void addToBack(int data){

        if(head == null){
            head = new Node(data);
            return;
        }

        if(head.getNext() == null){
            head.setNext(new Node(data));
            return;
        }

        Node temp = head.getNext();
        while (temp.getNext() != null){
            temp = temp.getNext();
        }

        temp.setNext(new Node(data));
    }

    public void printSLL(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }
}
