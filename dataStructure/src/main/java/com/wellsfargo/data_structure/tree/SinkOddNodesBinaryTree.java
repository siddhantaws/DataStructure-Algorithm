package com.wellsfargo.data_structure.tree;

public class SinkOddNodesBinaryTree {

    private static Node  root;
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "data->" + data;
        }
    }

    static Node newnode(int data) {
        return new Node(data);
    }

    static boolean isLeaf(Node root) {
        return (root.left == null && root.right == null);
    }

    // A recursive method to sink a tree with odd root This method assumes that the subtrees are already
    // sinked. This method is similar to Heapify of Heap-Sort
    static void sink(Node root)
    {
        // If NULL or is a leaf, do nothing
        if (root == null || isLeaf(root))
            return;

        // if left subtree exists and left child is even
        if (root.left!=null && (root.left.data & 1)==0)
        {
            // swap root's data with left child and
            // fix left subtree
            swap(root, root.left);
            sink(root.left);
        }

        // if right subtree exists and right child is even
        else if(root.right!=null && (root.right.data & 1)==0)
        {
            // swap root's data with right child and
            // fix right subtree
            swap(root, root.right);
            sink(root.right);
        }
    }

    // Function to sink all odd nodes to the bottom of binary tree. It does a postorder traversal and calls sink() if any odd node is found
    static void sinkOddNodes(Node root)
    {
        // If NULL or is a leaf, do nothing
        if (root == null || isLeaf(root))
            return;

        // Process left and right subtrees before this node
        sinkOddNodes(root.left);
        sinkOddNodes(root.right);

        // If root is odd, sink it
        if ((root.data & 1)!= 0 )
            sink(root);
    }

    static void swap(Node n1, Node n2){
        int l= n1.data;
        n1.data=n2.data;
        n2.data=l;
    }

    public static void main(String[] args) {
        root = newnode(1);
        root.left = newnode(5);
        root.right    = newnode(8);
        root.left.left = newnode(2);
        root.left.right = newnode(4);
        root.right.left = newnode(9);
        root.right.right = newnode(10);
        sinkOddNodes(root);
    }
}
