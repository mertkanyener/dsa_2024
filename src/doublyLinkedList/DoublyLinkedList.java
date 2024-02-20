package doublyLinkedList;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }

        public void printNodeValue() {
            System.out.println(value);
        }
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        System.out.println("List: ");
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        length++;
    }

    public Node removeLast() {
        if (head == null) return null;
        Node temp = tail;
        if (head == tail) {
            head = null;
            tail = null;
            length = 0;
            return temp;
        }
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
        length--;

        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
        length ++;
    }

    public Node removeFirst() {
        if (head == null) return null;
        Node temp = head;
        if (head == tail) {
            head = null;
            tail = null;
            length = 0;
            return temp;
        }
        head = temp.next;
        head.prev = null;
        temp.next = null;
        length--;

        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        if (index < length/2 ) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int value, int index) {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node before = get(index - 1);
        Node after = before.next;
        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();
        Node temp = get(index);
        temp.prev.next = temp.prev;
        temp.next.prev = temp.next;
        temp.next = null;
        temp.prev = null;
        length--;
        return temp;
    }


    // Leet code exercises
    // Swap first and last node values in a DLL
    public void swapFirstLast() {
        if (length >= 2) {
            int headValue = head.value;
            head.value = tail.value;
            tail.value = headValue;
        }

    }

    public void reverse() {
        Node current = head;
        Node temp = null;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
    }
}
