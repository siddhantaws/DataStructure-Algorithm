package com.wellsfargo.data_structure.tree;

public class TreeIsomorphismProblem {


    public static boolean Isomorphism(Node n1 ,Node n2 ){
        if(n1==null && n2==null)
            return true;

        if(n1==null || n2==null)
            return false;

        if(n1.data != n2.data)
            return false;

        return (Isomorphism(n1.left , n2.left) && Isomorphism(n1.right, n2.right) ) ||
                (Isomorphism(n1.left , n2.right) && Isomorphism(n1.right, n2.left) );
    }

    public static void main(String[] args) {
        Node n1 = newNode(1);
        n1.left = newNode(2);
        n1.right = newNode(3);
        n1.left.left = newNode(4);
        n1.left.right = newNode(5);
        n1.right.left = newNode(6);
        n1.left.right.left = newNode(7);
        n1.left.right.right = newNode(8);
        Node n2 = newNode(1);
        n2.left = newNode(3);
        n2.right = newNode(2);
        n2.right.left = newNode(4);
        n2.right.right = newNode(5);
        n2.left.right = newNode(6);
        n2.right.right.left = newNode(8);
        n2.right.right.right = newNode(7);
        System.out.println(Isomorphism(n1, n2));

    }

    static Node newNode(int data) {
        Node temp = new Node(data);
        return (temp);
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }

        @Override
        public String toString() {
            return "data->" + data;
        }

    }
}