package com.wellsfargo.data_structure.tree;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MaximumDifferenceBetweenNodeItsAncestorBinaryTree {

    private Node root;

    public MaximumDifferenceBetweenNodeItsAncestorBinaryTree(Node root) {
        this.root = root;
    }

    class Res {
        int r = Integer.MIN_VALUE;

        @Override
        public String toString() {
            return "res->"+r;
        }
    }

    /* Recursive function to calculate maximum ancestor-node difference in  binary tree. It updates value at 'res'
      to store the result.  The returned value of this function is minimum value in subtree rooted with 't' */
    int maxDiffUtil(Node t, Res res) {
        /* Returning Maximum int value if node is not there (one child case)  */
        if (t == null)
            return Integer.MAX_VALUE;
        /* If leaf node then just return node's value  */
        if (t.left == null && t.right == null)
            return t.data;
        /* Recursively calling left and right subtree for minimum value  */
        int val = Math.min(maxDiffUtil(t.left, res), maxDiffUtil(t.right, res));
        /* Updating res if (node value - minimum value from subtree) is bigger than res  */
        res.r = Math.max(res.r, t.data - val);
        /* Returning minimum value got so far */
        return Math.min(val, t.data);
    }

    public int maxDiff(){
        return maxDiff(root);
    }
    /* This function mainly calls maxDiffUtil() */
    private int maxDiff(Node root) {
        // Initialising result with minimum int value
        Res res = new Res();
        maxDiffUtil(root, res);
        return res.r;
    }

    public static void main(String[] args) {

        Node root = new Node(8);
        root.left = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        root.right = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        MaximumDifferenceBetweenNodeItsAncestorBinaryTree nodeItsAncestorBinaryTree =new MaximumDifferenceBetweenNodeItsAncestorBinaryTree(root);
        System.out.println(nodeItsAncestorBinaryTree.maxDiff());
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
        }

        @Override
        public String toString() {
            return "data->"+data;
        }
    }
}
