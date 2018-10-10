package com.wellsfargo.data_structure.tree;

public class VerticalWidthBinaryTree_2 {
    private static Node root;

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
}
