package com.wellsfargo.data_structure.tree;

public class ConvertGivenBinaryTreeDoublyLinkedList_4 {
    // 'root' - root of binary tree
    Node root=null;

    // 'head' - reference to head node of created
    //double linked list
    Node head;

    void BToDLL(Node root)
    {
        // Base cases
        if (root == null)
            return;

        // Recursively convert right subtree
        BToDLL(root.right);

        // insert root into DLL
        root.right = head;

        // Change left pointer of previous head
        if (head != null)
            (head).left = root;

        // Change head of Doubly linked list
        head = root;

        // Recursively convert left subtree
        BToDLL(root.left);
    }

    public static void main(String[] args) {
        ConvertGivenBinaryTreeDoublyLinkedList_4 tree = new ConvertGivenBinaryTreeDoublyLinkedList_4();
        tree.root = new Node(5);
        tree.root.left = new Node(3);
        tree.root.right = new Node(6);
        tree.root.left.right = new Node(4);
        tree.root.left.left = new Node(1);
        tree.root.right.right = new Node(8);
        tree.root.left.left.right = new Node(2);
        tree.root.left.left.left = new Node(0);
        tree.root.right.right.left = new Node(7);
        tree.root.right.right.right = new Node(9);

        tree.BToDLL(tree.root);
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
