import bst.BinarySearchTree;
import doublyLinkedList.DoublyLinkedList;
import linkedList.LinkedList;
import queue.Queue;
import stack.Stack;

public class Main {
    public static void main(String[] args) {

        //LinkedList linkedList = new LinkedList(1);
//        linkedList.append(2);
//        linkedList.append(3);
//        linkedList.append(4);
//        linkedList.printList();
//
//        System.out.println(linkedList.removeLast().value);
//        System.out.println(linkedList.removeLast().value);


        //linkedList.reverse();

/*        DoublyLinkedList dll = new DoublyLinkedList(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);

        dll.printList();

        System.out.println(dll.removeLast());

        dll.printList();

        dll.prepend(-1);
        dll.prepend(-2);

        dll.printList();

        dll.removeFirst();
        dll.removeFirst();

        dll.printList();*/


/*        Stack stack = new Stack(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.printStack();
        System.out.println("------------");
        stack.pop();
        stack.printStack();*/
/*
        Queue queue = new Queue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        queue.printQueue();

        queue.dequeue();

        queue.printQueue();*/

        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(47);
        bst.insert(21);
        bst.insert(76);
        bst.insert(18);
        bst.insert(52);
        bst.insert(82);

        bst.insert(27);

        System.out.println(bst.root.left.right.value);

        System.out.println(bst.contains(47));
        System.out.println(bst.contains(21));
        System.out.println(bst.contains(11));

    }
}