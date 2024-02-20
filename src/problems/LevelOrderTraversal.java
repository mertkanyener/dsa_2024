package problems;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    Node root;
    void printLevelOrder() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // poll  removes the present head
            Node tempNode = queue.poll();
            System.out.println(tempNode.data + " ");

            //Enqueue left child
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    // a utility function swap left-node and right node
    // of tree of every k'th level
    static void swapEveryKLevel(Node root, int k)
    {
        int level = 1;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node temp = q.remove();
                if ((level + 1) % k == 0) {
                    Node tmp = temp.left;
                    temp.left = temp.right;
                    temp.right = tmp;
                }
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            level++;
        }
    }

    // function to print inorder traversal
    static void inorder(Node root)
    {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }


    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = null;
            right = null;
        }
    }



}
