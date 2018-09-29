package com.wellsfargo.data_structure.tree;

public class ConstructSpecialBinaryTreeFromInorderTraversal {

    private int inorder[];

    public ConstructSpecialBinaryTreeFromInorderTraversal(int[] inorder) {
        this.inorder = inorder;
    }

    public Node constructTree(int start , int end ){

        if(start==end || start > end)
            return null;
        int max=getMax(start,end);

        Node n = new Node(inorder[max]);

        n.left = constructTree(start , max);
        n.right = constructTree(max+1 , end);

        return n;
    }

    public static void main(String[] args) {

    }

    public int getMax(int start, int end){
        int max=start;
        for(int i=start+1;i<end;i++)
            max= inorder[max] > inorder[start] ? max :start;
        return max;
    }

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }

        @Override
        public String toString() {
            return "data->"+data;
        }
    }

}
