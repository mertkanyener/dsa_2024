package linkedList.exercises;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    public class Node {
        public int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        length++;
    }

    public Node removeLast() {
        if (length == 0) return null;
        Node pre = head;
        Node temp = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        pre.next = null;
        tail = pre;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            tail = newNode;
        } else {
            newNode.next = head;
        }
        head = newNode;
        length++;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node node = get(index);
        if (node != null) {
            node.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length -1) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node prev = get(index - 1);
        newNode.next = prev.next;
        prev.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) {
            return removeFirst();
        }
        if (index == length - 1) {
            return removeLast();
        }
        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    //Floyd's tortoise and hare algorithm (or cycle-algorithm)

    // FIND MIDDLE NODE

    public Node findMiddleNode() {
        if (head == null) return null;
        Node slow = head;
        Node fast = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next == null) break;
            fast = fast.next;
        }
        return slow;
    }

    public boolean hasLoop() {
        if (head == null) return false;
        Node slow = head;
        Node fast = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next == null) return false;
            if (fast.next == slow) return true;
            fast = fast.next;
        }
        return false;
    }

    // Two pointer approach
    public Node findKthFromEnd(int k) {
        if (head == null) return null;
        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
            if (fast == null) return null;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }









}
