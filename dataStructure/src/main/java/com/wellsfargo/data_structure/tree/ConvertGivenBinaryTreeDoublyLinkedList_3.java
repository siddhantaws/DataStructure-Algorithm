package com.wellsfargo.data_structure.tree;

public class ConvertGivenBinaryTreeDoublyLinkedList_3 {

    Node root;

    // head --> Pointer to head node of created doubly linked list
    Node head;

    // Initialize previously visited node as NULL. This is
    // static so that the same value is accessible in all recursive
    // calls
    static Node prev = null;

    public void binaryTree2DoubleLinkedList(Node root)
    {
        // Base case
        if (root == null)
            return;

        // Recursively convert left subtree
        binaryTree2DoubleLinkedList(root.left);

        // Now convert this node
        if (prev == null)
            head = root;
        else
        {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        // Finally convert right subtree
        binaryTree2DoubleLinkedList(root.right);
    }

    public static void main(String[] args) {
        // Let us create the tree as shown in above diagram
        ConvertGivenBinaryTreeDoublyLinkedList_3 tree = new ConvertGivenBinaryTreeDoublyLinkedList_3();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);

        // convert to DLL
        tree.binaryTree2DoubleLinkedList(tree.root);
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
