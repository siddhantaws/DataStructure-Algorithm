package com.wellsfargo.data_structure.tree;

public class ConvertBinaryTreeCircularDoublyLinkList {
    private static Node root;
    private static Node head , tail;

    public void convertToDoublelyLinkedList(){
        convertToDoublelyLinkedList(root);
    }

    public Node convertToDoublelyLinkedList(Node node){
        if(node==null)
            return null;
        Node left= convertToDoublelyLinkedList(node.left);
        if(left!=null){
            node.left=left;
            left.right=node;
        }
        Node right= convertToDoublelyLinkedList(node.right);
        if(right!=null){
            right.left=node;
            node.right=right;
        }
        return node;
    }

    public static void main(String[] args) {
        ConvertBinaryTreeCircularDoublyLinkList tree = new ConvertBinaryTreeCircularDoublyLinkList();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);
        tree.convertToDoublelyLinkedList(root);
    }

    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            left = right = null;
        }

        @Override
        public String toString() {
            return "data->"+val;
        }
    }
}
