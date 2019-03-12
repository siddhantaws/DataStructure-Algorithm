package com.wellsfargo.data_structure.tree;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class FindMaximumPathSumTwoLeavesBinaryTree {
    private Node root;

    public FindMaximumPathSumTwoLeavesBinaryTree(Node root) {
        this.root = root;
    }

    private int calculateMaxSum(Node n){
        if(n==null)
            return 0;
       if(n.left==null && n.right==null)
           return n.data;

       int left =calculateMaxSum(n.left);
       int right =calculateMaxSum(n.right);

       if(n.left!=null && n.right!=null) {
           return Math.max(left,right) + n.data;
       }
       return n.left==null ? n.data +right :n.data +left;
    }

    public int calculateMaxSum(){
        return calculateMaxSum(root);
    }

    public static void main(String[] args) {

        Node root    = new Node(-15);
        root.left = new Node(5);
        root.right = new Node(6);
        root.left.left = new Node(-8);
        root.left.right = new Node(1);
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(6);
        root.right.left = new Node(3);
        root.right.right = new Node(9);
        root.right.right.right = new Node(0);
        root.right.right.right.left = new Node(4);
        root.right.right.right.right = new Node(-1);
        root.right.right.right.right.left = new Node(10);
        FindMaximumPathSumTwoLeavesBinaryTree binaryTree =new FindMaximumPathSumTwoLeavesBinaryTree(root);

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
