package com.wellsfargo.data_structure.tree;

public class SumOfCoveredAndUncoveredNodesOfBinaryTree {
    Node root;

    int sum(Node t)
    {
        if (t == null)
            return 0;
        return t.data + sum(t.left) + sum(t.right);
    }

    int uncoverSum(Node t)
    {
        /* Initializing with 0 in case we don't have
           left or right boundary  */
        int lb = 0, rb = 0;

        if (t.left != null)
            lb = uncoveredSumLeft(t.left);
        if (t.right != null)
            rb = uncoveredSumRight(t.right);

        /* returning sum of root node, left boundry
           and right boundry*/
        return t.data + lb + rb;
    }
    int uncoveredSumLeft(Node t)
    {
        /*  If left node, then just return its key value   */
        if (t.left == null && t.right == null)
            return t.data;

        /*  If left is available then go left otherwise go right  */
        if (t.left != null)
            return t.data + uncoveredSumLeft(t.left);
        else
            return t.data + uncoveredSumLeft(t.right);
    }

    /* Recursive function to calculate sum of right boundary
       elements  */
    int uncoveredSumRight(Node t)
    {
        /*  If left node, then just return its key value   */
        if (t.left == null && t.right == null)
            return t.data;

        /*  If right is available then go right otherwise go left  */
        if (t.right != null)
            return t.data + uncoveredSumRight(t.right);
        else
            return t.data + uncoveredSumRight(t.left);
    }

    boolean isSumSame(Node root)
    {
        // Sum of uncovered elements
        int sumUC = uncoverSum(root);

        // Sum of all elements
        int sumT = sum(root);

        // Check if sum of covered and uncovered is same
        return (sumUC == (sumT - sumUC));
    }

    static  class Node
    {
        int data;
        Node left, right, nextRight;

        Node(int item)
        {
            data = item;
            left = right = nextRight = null;
        }

        @Override
        public String toString() {
            return "data->"+data;
        }
    }
    public static void main(String[] args)
    {

        SumOfCoveredAndUncoveredNodesOfBinaryTree tree = new SumOfCoveredAndUncoveredNodesOfBinaryTree();

        // Making above given diagram's binary tree
        tree.root = new Node(8);
        tree.root.left = new Node(3);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(6);
        tree.root.left.right.left = new Node(4);
        tree.root.left.right.right = new Node(7);

        tree.root.right = new Node(10);
        tree.root.right.right = new Node(14);
        tree.root.right.right.left = new Node(13);

        if (tree.isSumSame(tree.root))
            System.out.println("Sum of covered and uncovered is same");
        else
            System.out.println("Sum of covered and uncovered is not same");
    }
}
