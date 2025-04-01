package GUI5_HW;
import java.io.Serializable;

enum Mode {
    ARCHIVE,
    CURRENT
}

class Storage<T extends Comparable<T> & Serializable, U> {
    private T key;
    private U content;
    private U archivedContent;
    private Mode mode;

    public Storage(T key, U content) {
        this.key = key;
        this.content = content;
        this.mode = Mode.CURRENT;
    }

    public void setContent(U newContent) {
        this.archivedContent = this.content;
        this.content = newContent;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public U getContent() {
        if (mode == Mode.ARCHIVE) {
            return archivedContent != null ? archivedContent : content;
        } else {
            return content;
        }
    }

    public T getKey() {
        return key;
    }

    public static void main(String[] args) {
        Storage<String, String> stringStorage = new Storage<>("file1.txt", "Current content of file1");
        System.out.println("Initial Key: " + stringStorage.getKey());
        System.out.println("Current Mode: " + stringStorage.mode);
        System.out.println("Current Content: " + stringStorage.getContent());

        stringStorage.setContent("Updated content of file1");
        System.out.println("\nAfter setContent:");
        System.out.println("Current Content: " + stringStorage.getContent());

        stringStorage.setMode(Mode.ARCHIVE);
        System.out.println("\nAfter setting mode to ARCHIVE:");
        System.out.println("Current Mode: " + stringStorage.mode);
        System.out.println("Archived Content: " + stringStorage.getContent());

        stringStorage.setMode(Mode.CURRENT);
        System.out.println("\nAfter setting mode back to CURRENT:");
        System.out.println("Current Mode: " + stringStorage.mode);
        System.out.println("Current Content: " + stringStorage.getContent());

        Storage<Integer, Integer> intStorage = new Storage<>(100, 50);
        System.out.println("\nInitial Key (intStorage): " + intStorage.getKey());
        System.out.println("Initial Content (intStorage): " + intStorage.getContent());
        intStorage.setContent(100);
        System.out.println("Current Content (intStorage) after update: " + intStorage.getContent());
        intStorage.setMode(Mode.ARCHIVE);
        System.out.println("Archived Content (intStorage): " + intStorage.getContent());
    }
}
