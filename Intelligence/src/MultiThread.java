public class MultiThread {
    public static void main(String[] args) {
        for (int trial = 1; trial <= 3; trial++) {
            EvenNumber evenThread = new EvenNumber();
            OddNumber oddThread = new OddNumber();

            long startTime = System.currentTimeMillis();

            evenThread.start();
            oddThread.start();

            try {
                evenThread.join();
                oddThread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Trial " + trial + " execution time with multi-threading: " + (endTime - startTime) + " ms"); // 1575 1697 1724
        }
    }
}
