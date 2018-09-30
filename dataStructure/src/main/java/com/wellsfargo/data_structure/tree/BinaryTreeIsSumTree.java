package com.wellsfargo.data_structure.tree;

public class BinaryTreeIsSumTree {

    Node root;

    boolean isLeaf(Node node)
    {
        if (node == null)
            return false;
        if (node.left == null && node.right == null)
            return true;
        return false;
    }

    public boolean isSumTree(Node node)
    {
        int ls; // for sum of nodes in left subtree
        int rs; // for sum of nodes in right subtree

        /* If node is NULL or it's a leaf node then
         return true */
        if (node == null || isLeaf(node))
            return true;

        if (isSumTree(node.left)  && isSumTree(node.right))
        {
            // Get the sum of nodes in left subtree
            if (node.left == null)
                ls = 0;
            else if (isLeaf(node.left))
                ls = node.left.data;
            else
                ls = 2 * (node.left.data);

            // Get the sum of nodes in right subtree
            if (node.right == null)
                rs = 0;
            else if (isLeaf(node.right))
                rs = node.right.data;
            else
                rs = 2 * (node.right.data);

            /* If root's data is equal to sum of nodes in left
               and right subtrees then return 1 else return 0*/
            if ((node.data == rs + ls))
                return true;
            else
                return false;
        }

        return false;
    }

    public static void main(String args[])
    {
        BinaryTreeIsSumTree tree = new BinaryTreeIsSumTree();
        tree.root = new Node(26);
        tree.root.left = new Node(10);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.right.right = new Node(3);

        if (tree.isSumTree(tree.root))
            System.out.println("The given tree is a sum tree");
        else
            System.out.println("The given tree is not a sum tree");
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
}
