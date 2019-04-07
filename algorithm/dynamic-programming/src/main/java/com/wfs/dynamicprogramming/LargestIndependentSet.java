package com.wfs.dynamicprogramming;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class LargestIndependentSet {

    private Node root;

    public LargestIndependentSet(Node root) {
        this.root = root;
    }

    public int getLargestIndependentSet(Node node){
        if(node ==null)
            return 0;
        if(node .left==null && node .right==null)
            return node.liss=1;
        else{

            int lissLeft = getLargestIndependentSet(node.left);
            int lissRight = getLargestIndependentSet(node.right);
            int lissLeft1 =0;int lissRight1 =0;
            if(node.left!=null){
                lissLeft1 = getLargestIndependentSet(node.left.left) + getLargestIndependentSet(node.left.right);
            }if(node.right!=null){
                lissRight1 = getLargestIndependentSet(node.right.left) + getLargestIndependentSet(node.right.right);
            }
            return node.liss =(Math.max(1+ lissLeft1+lissRight1 , lissLeft +lissRight));
        }
    }

    static class Node {
        int data;Node left;Node right;
        int liss;
        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);
    }
}
