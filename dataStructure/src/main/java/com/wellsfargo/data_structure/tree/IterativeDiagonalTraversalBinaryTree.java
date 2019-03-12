package com.wellsfargo.data_structure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class IterativeDiagonalTraversalBinaryTree {

    private Node root;

    public IterativeDiagonalTraversalBinaryTree(Node root) {
        this.root = root;
    }

    public void diagonalPrint()
    {
        // base case
        if (root == null)
            return;
        // inbuilt queue of Treenode
        Queue<Node> q= new LinkedList<>();
        // add root
        q.add(root);
        // add delimiter
        q.add(null);
        while (q.size()>0) {
            Node temp = q.peek();
            q.remove();
            // if current is delimiter then insert another for next diagonal and cout nextline
            if (temp == null) {
                // if queue is empty return
                if (q.size()==0)
                    return;
                // output nextline
                System.out.println();
                // add delimiter again
                q.add(null);
            }
            else {
                while (temp!=null) {
                    System.out.print( temp.data + " ");
                    // if left child is present  add into queue
                    if (temp.left!=null)
                        q.add(temp.left);
                    // current equals to right child
                    temp = temp.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        IterativeDiagonalTraversalBinaryTree binaryTree =new IterativeDiagonalTraversalBinaryTree(root);
        binaryTree.diagonalPrint();
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
