package problems;

public class HeightOfBinaryTree {

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    class BinaryTree {
        Node root;

        int maxDepth(Node node) {
            if (node == null) {
                return 0;
            } else {
                int leftDepth = maxDepth(node.left);
                int rightDepth = maxDepth(node.right);

                if (leftDepth > rightDepth) {
                    return leftDepth + 1;
                } else {
                    return rightDepth + 1;
                }
            }
        }
    }

}
