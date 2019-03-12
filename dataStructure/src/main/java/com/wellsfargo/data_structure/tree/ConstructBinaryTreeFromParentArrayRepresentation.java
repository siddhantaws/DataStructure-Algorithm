package com.wellsfargo.data_structure.tree;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class ConstructBinaryTreeFromParentArrayRepresentation {

    private int parent[] =null;

    private Node root;

    private Node[] tree;

    public ConstructBinaryTreeFromParentArrayRepresentation(int[] parent) {
        this.parent = parent;
        this.tree =new Node[parent.length];
    }

    public void constructTree(int i ){
        if(tree[i]!=null)
            return;

        if(parent[i]==-1){
            tree[i] =new Node(i);
            return;
        }

        Node n =new Node(i);
        tree[i] =n;

        constructTree(parent[i]);
        int pare = parent[i];
        Node parent = tree[pare];

        if(parent.left!=null)
            parent.setLeft(n);
        else
            parent.setRight(n);
    }

    public void constructTree(){
        for(int i=0;i<parent.length;i++)
            constructTree(i);
    }


    static class Node {
        int data;
        Node left, right;
        Node(int item) {
            data = item;
        }
        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
