package queue;

public class Queue {

    private Node first;
    private Node last;
    private int length;
    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public void printQueue() {
        Node temp = first;
        System.out.println("Queue: ");
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (first == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        length++;
    }

    public Node dequeue() {
        if (first == null) return null;
        Node temp = first;
        if (first.next == null) {
            first = null;
            last = null;
            return temp;
        }
        first = first.next;
        temp.next = null;
        length--;
        return temp;
    }





}
