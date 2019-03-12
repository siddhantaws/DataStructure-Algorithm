package com.wellsfargo.data_structure.tree;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class CreateDoublyLinkedListFromTernaryTree {

    private Node root;

    public CreateDoublyLinkedListFromTernaryTree(Node root) {
        this.root = root;
    }

    public void printPreOrder(Node n){
        if(n==null)
            return;
        else {
            System.out.print(n.data+" ");
            printPreOrder(n.left);
            printPreOrder(n.middle);
            printPreOrder(n.right);
        }
    }

    public static void main(String[] args) {
        // Construting ternary tree as shown
        // in above figure
        Node root = new Node(30);
        root.left = new Node(5);
        root.middle = new Node(11);
        root.right = new Node(63);
        root.left.left = new Node(1);
        root.left.middle = new Node(4);
        root.left.right = new Node(8);
        root.middle.left = new Node(6);
        root.middle.middle = new Node(7);
        root.middle.right = new Node(15);
        root.right.left = new Node(31);
        root.right.middle = new Node(55);
        root.right.right = new Node(65);

        CreateDoublyLinkedListFromTernaryTree  ternaryTree =new CreateDoublyLinkedListFromTernaryTree(root);
        ternaryTree.printPreOrder(root);
    }
    static class Node {
        int data;

        Node left, right , middle;

        Node(int item) {
            data = item;
        }
        public void setMiddle(Node middle) {
            this.middle = middle;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
