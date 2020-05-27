package com.wfs.dynamicprogramming;

public class LargestIndependentSetProblem {

    private Node root;

    public LargestIndependentSetProblem(Node root) {
        this.root = root;
    }


    public int liss(Node node){
        if(node==null)
            return 0;
        if(node.liss!=0)
            return node.liss;
        if (node.left==null && node.right==null){
            return 1;
        }
        int maxExcluseive = liss(node.left)+ liss(node.right);

        int maxincluseive =1;

        if(node.left!=null)
            maxincluseive+= liss(node.left.right)+ liss(node.left.left);
        if(node.right!=null)
            maxincluseive+= liss(node.right.left)+ liss(node.right.right);
        node.liss =Math.max(maxExcluseive,maxincluseive);
        return node.liss;
    }

    public static void main(String[] args) {
        Node root = newNode(20);
        root.left = newNode(8);
        root.left.left = newNode(4);
        root.left.right = newNode(12);
        root.left.right.left = newNode(10);
        root.left.right.right = newNode(14);
        root.right = newNode(22);
        root.right.right = newNode(25);
    }

    static Node newNode(int data){
        return new Node(data);
    }
    static class Node {
        int data;
        Node left;
        Node right;
        int liss = 0;

        public Node(int data) {
            this.data = data;
        }
    }
}
