package com.wellsfargo.data_structure.tree;

public class FlipBinaryTree {


    public static Node flipBinaryTree(Node root) {
        // Base cases
        if (root == null)
            return root;
        if (root.left == null && root.right == null)
            return root;

        //  recursively call the same method
        Node flippedRoot = flipBinaryTree(root.left);

        //  rearranging main root Node after returning
        // from recursive call
        root.left.left = root.right;
        root.left.right = root;
        root.left = root.right = null;

        return flippedRoot;
    }

    public static void main(String[] args) {
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left =newNode(4);
        root.left.right =newNode(5);
        root.left.left.left = newNode(8);
        root.left.left.right = newNode(9);
        FlipBinaryTree.flipBinaryTree(root);

    }

    public static  Node newNode(int data) {
        Node n = new Node(data);
        return n;
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
        }

        @Override
        public String toString() {
            return "data->"+data;
        }
    }
}
