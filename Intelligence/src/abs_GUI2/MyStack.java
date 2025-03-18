package abs_GUI2;

// Array-based
class MyStackArray {
    final Student[] stack;
    int head;
    private final int capacity;
    public MyStackArray(int capacity) {
        this.capacity = capacity;
        this.stack = new Student[capacity];
        this.head = -1; // -1 (~null) 0 1 2 ...
    }

    public void push(Student item) {
        if (head == capacity - 1) { // -1 0 1 |2| == 3 - 1
            System.out.println("Stack Overflow. Cannot push: " + item + ". Stack is full.");
        } else {
            stack[++head] = item; // -1++ => 0
            System.out.println("Pushed: " + item);
        }
    }
    public Object pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow. Cannot pop. Stack is empty.");
            return null;
        } else {
            Object item = stack[head--];
            System.out.println("Popped: " + item);
            return item;
        }
    }
    public boolean isEmpty() {
        return head == -1;
    }
}

// Singly Linked List-based => Node
class MyStackNode {
    Node head;
    private int size;
    int capacity;
    static class Node {
        public Object data;
        public Node next;
        Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }
    public MyStackNode(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.size = 0;
    }

    public void push(Object item) { // Student extends Object
        if (size == capacity) { // 0 1 2 |3| == 3
            System.out.println("Stack Overflow. Cannot push. Stack is full.");
        } else {
            Node newNode = new Node(item);
            newNode.next = head; // Set 'next' to 'head' of the linked list
            head = newNode; // i'll come back null => ... : next <= next <= next
            size++;
            System.out.println("Pushed: " + item);
        }
    }
    public Object pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow. Cannot pop. Stack is empty.");
            return null;
        } else {
            Object item = head.data;
            head = head.next; // next => next => next
            size--;
            System.out.println("Popped: " + item);
            return item;
        }
    }
    public boolean isEmpty() {
        return head == null;
    }
}




class Student {
    private final int sNumber;
    private final String name;
    public Student(int sNumber, String name) {
        this.sNumber = sNumber;
        this.name = name;
    }

    public void show() {
        System.out.println("Student Number: " + sNumber + ", Name: " + name);
    }

    @Override
    public String toString(){
        return "Student(sNumber=" + sNumber + ", name=" + name + ")";
    }
}




public class MyStack {
    public static void main(String[] args) {
        System.out.println("--- Array-based Stack Test ---");
        System.out.println();
        MyStackArray arrayStack = new MyStackArray(3);
        arrayStack.push(new Student(32280, "Alice"));
        arrayStack.push(new Student(33456, "Bob"));
        arrayStack.push(new Student(32335, "Charlie"));
        arrayStack.push(new Student(35678, "David")); // Ooops
        System.out.println();
        for (int i = 0; i <= arrayStack.head; i++) {arrayStack.stack[i].show();}
        System.out.println();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop(); // Ooops

        System.out.println();
        System.out.println("\n--- Linked List-based Stack Test ---");
        MyStackNode nodeStack = new MyStackNode(3);
        nodeStack.push(new Student(34678, "Eve"));
        nodeStack.push(new Student(32456, "Frank"));
        nodeStack.push(new Student(36754, "Grace"));
        nodeStack.push(new Student(31567, "Henry")); // Ooops
        System.out.println();
        MyStackNode.Node show = nodeStack.head;
        while (show != null) {
            if (show.data instanceof Student student) {
                student.show();
            }
            show = show.next;
        }
        System.out.println();
        nodeStack.pop();
        nodeStack.pop();
        nodeStack.pop();
        nodeStack.pop(); // Ooops
    }
}
