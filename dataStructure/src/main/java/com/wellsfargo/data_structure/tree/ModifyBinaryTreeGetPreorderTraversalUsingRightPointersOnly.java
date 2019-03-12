package com.wellsfargo.data_structure.tree;

import java.util.Stack;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class ModifyBinaryTreeGetPreorderTraversalUsingRightPointersOnly {

    private Node root;

    public ModifyBinaryTreeGetPreorderTraversalUsingRightPointersOnly(Node root) {
        this.root = root;
    }

    public void modifyPreOrderTraversal(){
        Node n =root;

        Stack<Node> nodes=new Stack<>();
        nodes.push(n);
        Node prev =null;

        while(!nodes.isEmpty()){
            n =nodes.pop();

            if(n.right!=null)
                nodes.push(n.right);
            if(n.left!=null)
                nodes.push(n.left);

            if(prev!=null){
                prev.right =n;
            }
            prev =n;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        ModifyBinaryTreeGetPreorderTraversalUsingRightPointersOnly traversalUsingRightPointersOnly =new ModifyBinaryTreeGetPreorderTraversalUsingRightPointersOnly(root);

    }

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

}
