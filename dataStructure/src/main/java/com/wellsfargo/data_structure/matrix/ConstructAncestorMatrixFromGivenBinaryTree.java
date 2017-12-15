package com.wellsfargo.data_structure.matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConstructAncestorMatrixFromGivenBinaryTree {

    private Node root;


    public ConstructAncestorMatrixFromGivenBinaryTree(Node root) {
        this.root = root;
    }

    static class Node{
        int data ;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public int[][] getMatrixFromTree() {

        //Do a preOrder traversal
        Stack<Node> list=new Stack<>();
        list.push(root);
        int maxrow=0;
        while(list.size()>0){
            Node n =list.peek();
            List<Node> l=new ArrayList<>();
            l.add(n);
            while(n.getLeft()!=null){
                list.push(n.getLeft());
            }
        }


        return null;
    }

    public static void main(String[] args) {
        Node root=new Node(5);
        root.setLeft(new Node(1));
        root.setLeft(new Node(2));
        root.getLeft().setLeft(new Node(0));
        root.getLeft().setRight(new Node(4));
        root.getRight().setLeft(new Node(3));

        ConstructAncestorMatrixFromGivenBinaryTree constructAncestorMatrixFromGivenBinaryTree=new ConstructAncestorMatrixFromGivenBinaryTree(root);

    }

}
