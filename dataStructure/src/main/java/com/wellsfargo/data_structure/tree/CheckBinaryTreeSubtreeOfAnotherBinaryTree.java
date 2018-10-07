package com.wellsfargo.data_structure.tree;

public class CheckBinaryTreeSubtreeOfAnotherBinaryTree {

    static Node root;
    Passing p = new Passing();


    static class Node {

        String data;
        Node left, right;

        Node(String item) {
            data = item;
            left = right = null;
        }

        @Override
        public String toString() {
            return "data->"+data;
        }
    }
    static class Passing {

        int i;
        int m = 0;
        int n = 0;
    }
}
