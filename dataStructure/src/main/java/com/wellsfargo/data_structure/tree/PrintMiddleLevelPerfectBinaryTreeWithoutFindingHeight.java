package com.wellsfargo.data_structure.tree;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class PrintMiddleLevelPerfectBinaryTreeWithoutFindingHeight {

    private Node root;

    public PrintMiddleLevelPerfectBinaryTreeWithoutFindingHeight(Node root) {
        this.root = root;
    }

    public void printMiddle(Node n1  , Node n2){

        if(n1==null || n2==null)
            return;
        if(n2.left==null && n2.right==null){
            System.out.print(n1.data+" ");
            return;
        }else
            printMiddle(n1.left, n2.left.left);
            printMiddle(n1.right, n2.left.left);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n1.left = n2;
        n1.right = n3;
        PrintMiddleLevelPerfectBinaryTreeWithoutFindingHeight levelPerfectBinaryTreeWithoutFindingHeight =new PrintMiddleLevelPerfectBinaryTreeWithoutFindingHeight(n1);
        levelPerfectBinaryTreeWithoutFindingHeight.printMiddle(n1,n1);
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
