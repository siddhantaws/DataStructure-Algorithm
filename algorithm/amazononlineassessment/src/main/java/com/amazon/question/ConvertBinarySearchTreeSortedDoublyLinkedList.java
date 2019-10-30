package com.amazon.question;

public class ConvertBinarySearchTreeSortedDoublyLinkedList {

    private Node root;

    public ConvertBinarySearchTreeSortedDoublyLinkedList(Node root) {
        this.root = root;
    }

    private Node prev;

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }
    }

    public Node treeToDoublyList(){
        Node right = treeToDoublyList(root);
        Node prev=null;
        while(right!=null){
            prev =right;
            System.out.print(right.val+" ");
            right =right.right;
        }
        return right;
    }

    private Node treeToDoublyList(Node root) {
        if(root==null)
            return null;
        else{
            treeToDoublyList(root.right);
            if(prev==null)
                prev=root;
            else {
                root.right=prev;
                prev.left=root;
                prev= root;
            }
            treeToDoublyList(root.left);
            return prev;
        }
    }


    public static void main(String[] args) {
        Node root =new Node(5);
        root.left = new Node(6);root.left.left = new Node(8);root.left.right =new Node(9);
        root.right =new Node(7);root.right.left =new Node(10);root.right.right =new Node(11);
        ConvertBinarySearchTreeSortedDoublyLinkedList linkedList =new ConvertBinarySearchTreeSortedDoublyLinkedList(root);
        linkedList.treeToDoublyList();
    }
}
