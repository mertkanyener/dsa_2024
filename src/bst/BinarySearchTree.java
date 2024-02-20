package bst;

public class BinarySearchTree {
    public Node root;

    public class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public void printBST() {
        Node temp = root;
        while (temp != null) {

        }
    }

    /*
    INSERT Steps
    create new node
    if root null then root = newNode
    temp = root
    while loop
     if newNode == temp return false (no duplicates in bst)
     if less than left if more than right
     if null insert newNode else move to next
    loop end
     */

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (temp == newNode) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        if (root == null) return false;
        Node temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

}
