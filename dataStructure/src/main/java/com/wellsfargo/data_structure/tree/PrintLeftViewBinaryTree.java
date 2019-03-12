package com.wellsfargo.data_structure.tree;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class PrintLeftViewBinaryTree {

    private Node root;

    private static int maxLevel =0;

    public PrintLeftViewBinaryTree(Node root) {
        this.root = root;
    }


    public void printLeftView(){
        printLeftView(root , 1);
    }


    private void printLeftView(Node n , int level){

        if(n==null)
            return;

        if(level > maxLevel){
            maxLevel = level;
            System.out.print(n.data+" ");
        }
        printLeftView(n.left, level+1);
        printLeftView(n.right, level+1);
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
