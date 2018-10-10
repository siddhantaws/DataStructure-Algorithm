package com.wellsfargo.data_structure.tree;

public class VerticalWidthBinaryTree_1 {

    private static Node root;
    static int maximum = 0;
    static int minimum = 0;

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "data->" + data;
        }
    }

    static Node newNode(int data) {
        return new Node(data);
    }

    static int getLength(Node root) {

        lengthUtil(root, 0);

        // 1 is added to include root in the width
        return (Math.abs(minimum) + maximum) + 1;
    }

    static void lengthUtil(Node root, int curr) {
        if (root == null)
            return;

        // traverse left
        lengthUtil(root.left, curr - 1);

        // if curr is decrease then get value in minimum
        if (minimum > curr)
            minimum = curr;

        // if curr is increase then get
        // value in maximum
        if (maximum < curr)
            maximum = curr;


        // traverse right
        lengthUtil(root.right, curr + 1);

    }

    public static void main(String[] args) {
        root = newNode(7);
        root.left = newNode(6);
        root.right = newNode(5);
        root.left.left = newNode(4);
        root.left.right = newNode(3);
        root.right.left = newNode(2);
        root.right.right = newNode(1);

        System.out.println(getLength(root));
    }
}
