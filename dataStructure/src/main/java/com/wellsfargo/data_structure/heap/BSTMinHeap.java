package com.wellsfargo.data_structure.heap;

import java.util.ArrayList;
import java.util.List;

public class BSTMinHeap {

    private Node root;

    private List<Integer> nodeList =new ArrayList<>();

    public BSTMinHeap(Node root) {
        this.root = root;
    }
    public BSTMinHeap(){}

    private  Node getNode(int data){
        return new Node(data);
    }

    private void inOrderTraversal(Node node ){
        if(node==null)
            return;
        else{
            inOrderTraversal(node.left);
            nodeList.add(node.data);
            inOrderTraversal(node.right);
        }
    }

    private void preOrderTraversal(Node node , int i){
        if(node ==null)
            return;
        else{
            node.data = nodeList.get(i);
            preOrderTraversal(node.left, i+1);
            preOrderTraversal(node.right, i+2);
        }
    }

    public void convertToHeap(){
        inOrderTraversal(root);

    }

    public static void main(String[] args) {

        BSTMinHeap bstMinHeap =new BSTMinHeap();
        Node root = bstMinHeap.getNode(4);
        root.left = bstMinHeap.getNode(2);
        root.right = bstMinHeap.getNode(6);
        root.left.left = bstMinHeap.getNode(1);
        root.left.right = bstMinHeap.getNode(3);
        root.right.left = bstMinHeap.getNode(5);
        root.right.right = bstMinHeap. getNode(7);
        bstMinHeap.root = root;

    }


    class Node {
        int data ;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

    }
}
