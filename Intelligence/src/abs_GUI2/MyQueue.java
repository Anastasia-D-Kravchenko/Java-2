package abs_GUI2;
//import java.util.LinkedList;
//import java.util.List;
//
//public class MyQueue<parameter> {
//    private LinkedList<parameter> queue = new LinkedList<>();
//
//    public void put(parameter element) {
//        queue.add(element);
//    }
//    public parameter get() {
//        if (isEmpty()) {
//            return null;
//        }
//        return queue.removeFirst();
//    }
//    public boolean isEmpty() {
//        return queue.isEmpty();
//    }
//}
//
//
//
//class testMyQueue {
//    public static void main(String[] args) {
//        List<String> basketA = List.of("PSG", "Atletico Madrid", "Sporting CP", "Inter", "Benfica", "Villarreal", "RB Salzburg", "Chelsea");
//        List<String> basketB = List.of("Manchester City", "Liverpool", "Ajax Amsterdam", "Real Madrid", "Bayern Munich", "Manchester United", "Lille", "Juventus");
//        MyQueue<String> queue = new MyQueue<String>();
//        int indexA = 0;
//        int indexB = 0;
//        while (indexA < basketA.size() || indexB < basketB.size()) {
//            if (indexA < basketA.size()) {
//                queue.put(basketA.get(indexA++));
//            }
//            if (indexB < basketB.size()) {
//                queue.put(basketB.get(indexB++));
//            }
//        }
//        while (!queue.isEmpty()) {
//            String element1 = queue.get();
//            String element2 = queue.get();
//            if (element1 != null && element2 != null) {
//                System.out.println(element1 + ", " + element2);
//            } else if (element1 != null){
//                System.out.println(element1);
//            }
//        }
//    }
//}


import java.util.LinkedList;
import java.util.Queue;

class MyQueue {
    private Queue<String> queue = new LinkedList<>();

    public void put(String element) {
        queue.add(element);
    }

    public String get() {
        return queue.poll();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }
}

class Task1 {

    public static void main(String[] args) {
        String[] basketA = {"PSG", "Atletico Madrid", "Sporting CP", "Inter", "Benfica", "Villarreal", "RB Salzburg", "Chelsea"};
        String[] basketB = {"Manchester City", "Liverpool", "Ajax Amsterdam", "Real Madrid", "Bayern Munich", "Manchester United", "Lille", "Juventus"};

        MyQueue queue = new MyQueue();

        int indexA = 0;
        int indexB = 0;

        while (indexA < basketA.length || indexB < basketB.length) {
            if (indexA < basketA.length) {
                queue.put(basketA[indexA]);
                indexA++;
            }
            if (indexB < basketB.length) {
                queue.put(basketB[indexB]);
                indexB++;
            }
        }

        while (!queue.isEmpty()) {
            String element1 = queue.get();
            String element2 = queue.get();
            if (element1 != null && element2 != null) {
                System.out.println("(" + element1 + ", " + element2 + ")");
            } else if (element1 != null) {
                System.out.println("(" + element1 + ", null)");
            }
        }
    }
}