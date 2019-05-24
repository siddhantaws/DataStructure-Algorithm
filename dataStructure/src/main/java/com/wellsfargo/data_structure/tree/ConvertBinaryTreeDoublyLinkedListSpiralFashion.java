/*
package com.wellsfargo.data_structure.tree;

import java.util.Stack;

*/
/**
 * @author Siddhanta Kumar Pattnaik
 *//*

public class ConvertBinaryTreeDoublyLinkedListSpiralFashion {

    private Node root, head , tail;

    public ConvertBinaryTreeDoublyLinkedListSpiralFashion(Node root) {
        this.root = root;
    }

    static class Node {
        int data ;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node convertToDLL(){

        Stack<Node> stack1 =new Stack<>();
        Stack<Node> stack2 =new Stack<>();

        stack1.push(root);

        while(!stack1.isEmpty() || !stack2.isEmpty()){
            while(!stack1.isEmpty()){
                Node n =stack1.peek();
                stack1.pop();
                if(n.left!=null)
                    stack2.push(n.left);
                if(n.right!=null)
                    stack2.push(n.right);
                addLast(n.data);
            }
            while (!stack2.isEmpty()){
                Node n =stack2.peek();
                stack2.pop();
                if(n.right!=null)
                    stack1.push(n.right);
                if(n.left!=null)
                    stack1.push(n.left);
                addLast(n.data);
            }
        }
        printList(head);
        return head;
    }

    void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    public void addLast(int n){
        Node n1 =new Node(n);

        if(head ==null){
            head =tail =lon1;
        }else{
            tail.right=n1;
            n1.left =tail ;
            tail =n1;
        }
    }

    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.left = new Node(6);
        tree.right.right = new Node(7);

        tree.left.left.left = new Node(8);
        tree.left.left.right = new Node(9);
        tree.left.right.left = new Node(10);
        tree.left.right.right = new Node(11);
        // trot.right.left.left = new Node(12);
        tree.right.left.right = new Node(13);
        tree.right.right.left = new Node(14);
        ConvertBinaryTreeDoublyLinkedListSpiralFashion spiralFashion =new ConvertBinaryTreeDoublyLinkedListSpiralFashion(tree);
        spiralFashion.convertToDLL();
    }
}

*/
