package com.wellsfargo.data_structure.tree;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class BoundaryTraversalBinaryTree {

    private Node root;

    public BoundaryTraversalBinaryTree(Node root) {
        this.root = root;
    }

    public void printBoundary(){
        System.out.print(root.data+"    ");
        printLeftTree(root.left);
        printLeaf(root.left);
        printLeaf(root.right);
        printLeftTree(root.right);
    }

    private void printLeftTree(Node n){
        if(n.left!=null){
            System.out.print(n.data+" ");
            printLeftTree(n.left);
        }else if(n.right!=null){
            System.out.print(n.data+" ");
            printLeftTree(n.right);
        }
    }

    private void printRightTree(Node n){
        if(n.right!=null){
            System.out.print(n.data+" ");
            printRightTree(n.right);
        }else if(n.left!=null){
            System.out.print(n.data+" ");
            printRightTree(n.left);
        }
    }

    private void printLeaf(Node n){
        if(n.left !=null){
            printLeaf(n.left);
        }
        if(n.right!=null){
            printLeaf(n.right);
        }
        if(n.left==null && n.right==null){
            System.out.print(n.data+" ");
        }

    }


    public static void main(String[] args) {
        Node root1 = new Node(20);
        root1.left = new Node(8);
        root1.left.left = new Node(4);
        root1.left.right = new Node(12);
        root1.left.right.left = new Node(10);
        root1.left.right.right = new Node(14);
        root1.right = new Node(22);
        root1.right.right = new Node(25);
        BoundaryTraversalBinaryTree binaryTree = new BoundaryTraversalBinaryTree(root1);
        binaryTree.printBoundary();
    }
    static class Node {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

}
