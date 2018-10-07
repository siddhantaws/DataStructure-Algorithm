package com.wellsfargo.data_structure.tree;

public class LowestCommonAncestor {
    private Node root;


    public Node getLCA(Node n , int a , int b){

        if(n==null)
            return null;

        if(n.data == a || n.data == b)
            return n;

        Node left= getLCA(n.left , a ,b);
        Node right= getLCA(n.right , a ,b);

        if(left!=null && right!=null )
            return n;
        if(left==null )
            return right;
        else
            return left;
    }

    public static void main(String[] args) {
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        lowestCommonAncestor.root = new Node(1);
        lowestCommonAncestor.root.left = new Node(2);
        lowestCommonAncestor.root.right = new Node(3);
        lowestCommonAncestor.root.left.left = new Node(4);
        lowestCommonAncestor.root.left.right = new Node(5);
        lowestCommonAncestor.root.right.left = new Node(6);
        lowestCommonAncestor.root.right.right = new Node(7);
        System.out.println(lowestCommonAncestor.getLCA(lowestCommonAncestor.root , 4 ,7));

    }

    static class Node
    {
        int data;
        Node left, right;

        public Node(int data)
        {
            this.data = data;
            left = right = null;
        }

        @Override
        public String toString() {
            return "data->"+data;
        }
    }
}
