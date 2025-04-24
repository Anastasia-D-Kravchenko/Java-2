public class toMillion {
    public static void main(String[] args) {
        for (int trial = 1; trial <= 3; trial++) {
            long startTime = System.currentTimeMillis();

            for (int i = 0; i <= 1_000_000; i++) System.out.println(i);

            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            System.out.println("Trial " + trial + " execution time: " + duration + " ms"); // 1482 1563 1357
        }
    }
}