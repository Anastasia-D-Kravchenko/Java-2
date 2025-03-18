package start_GUI2.sll;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        SLL backSLL = new SLL();

        backSLL.addToBack(1);
        backSLL.addToBack(2);
        backSLL.addToBack(3);

        backSLL.printSLL();

        System.out.println("-----------------");

        SLL frontSLL = new SLL();
        frontSLL.addToFront(1);
        frontSLL.addToFront(2);
        frontSLL.addToFront(3);

        frontSLL.printSLL();

        System.out.println("@@@@@@@@@@@@@@@@@@");

        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        System.out.println("linkedList = " + linkedList);

        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        System.out.println("arrayList = " + arrayList);

    }
}
