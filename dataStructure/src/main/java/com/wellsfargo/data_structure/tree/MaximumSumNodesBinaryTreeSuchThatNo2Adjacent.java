package com.wellsfargo.data_structure.tree;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MaximumSumNodesBinaryTreeSuchThatNo2Adjacent {

    private Node root;

    public MaximumSumNodesBinaryTreeSuchThatNo2Adjacent(Node root) {
        this.root = root;
    }

    public Pair getSum(Node n){

        if(n==null){
            return new Pair(0,0);
        }
        Pair left = getSum(n.left);
        Pair right = getSum(n.left);

        Pair p =new Pair(0,0);

        p.first = left.second +right.second + n.data;
        p.second = Math.max(left.first ,left.second ) +Math.max(right.first ,right.second );
        return p;
    }


    public static void main(String[] args) {
        Node root= new Node(10);
        root.left= new Node(1);
        root.left.left= new Node(2);
        root.left.left.left= new Node(1);
        root.left.right= new Node(3);
        root.left.right.left= new Node(4);
        root.left.right.right= new Node(5);
        MaximumSumNodesBinaryTreeSuchThatNo2Adjacent suchThatNo2Adjacent =new MaximumSumNodesBinaryTreeSuchThatNo2Adjacent(root);
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

    static class Pair{
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
