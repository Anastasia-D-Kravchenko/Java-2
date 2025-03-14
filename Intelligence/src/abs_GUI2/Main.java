package abs_GUI2;

class Student {
    private int sNumber;
    private String name;

    public Student(int sNumber, String name) {
        this.sNumber = sNumber;
        this.name = name;
    }

    public void show() {
        System.out.println("Student Number: " + sNumber + ", Name: " + name);
    }
}

class MyStackArray<T> {
    private T[] stack;
    private int top;

    @SuppressWarnings("unchecked")
    public MyStackArray(int size) {
        stack = (T[]) new Object[size];
        top = -1;
    }

    public void push(T element) {
        if (top == stack.length - 1) {
            System.out.println("Stack overflow!");
            return;
        }
        stack[++top] = element;
    }

    public T pop() {
        if (top == -1) {
            System.out.println("Stack underflow!");
            return null;
        }
        return stack[top--];
    }

    public boolean isEmpty(){
        return top == -1;
    }
}

class MyStackLinkedList<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> top;
    private int size;
    private int capacity;

    public MyStackLinkedList(int capacity) {
        this.capacity = capacity;
        this.top = null;
        this.size = 0;
    }

    public void push(T element) {
        if (size == capacity) {
            System.out.println("Stack overflow!");
            return;
        }
        Node<T> newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (top == null) {
            System.out.println("Stack underflow!");
            return null;
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public boolean isEmpty(){
        return top == null;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Array Implementation ---");
        MyStackArray<Student> stackArray = new MyStackArray<>(3);
        stackArray.push(new Student(1, "Alice"));
        stackArray.push(new Student(2, "Bob"));
        stackArray.push(new Student(3, "Charlie"));
        stackArray.push(new Student(4, "David"));
        while (!stackArray.isEmpty()) {
            Student student = stackArray.pop();
            if (student != null) {
                student.show();
            }
        }
        stackArray.pop();

        System.out.println("\n--- Linked List Implementation ---");
        MyStackLinkedList<Student> stackList = new MyStackLinkedList<>(3);
        stackList.push(new Student(1, "Eve"));
        stackList.push(new Student(2, "Frank"));
        stackList.push(new Student(3, "Grace"));
        stackList.push(new Student(4, "Heidi"));
        while (!stackList.isEmpty()) {
            Student student = stackList.pop();
            if (student != null) {
                student.show();
            }
        }
        stackList.pop();
    }
}