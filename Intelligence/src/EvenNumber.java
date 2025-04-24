public class EvenNumber extends Thread {
    public void run() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i <= 1_000_000; i += 2) System.err.print(i);
        long endTime = System.currentTimeMillis();
        System.out.println("\nEven number thread execution time: " + (endTime - startTime) + " ms");
    }
}

class OddNumber extends Thread {
    public void run() {
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= 1_000_000; i += 2) System.out.print(i);
        long endTime = System.currentTimeMillis();
        System.out.println("\nEven number thread execution time: " + (endTime - startTime) + " ms");
    }
}