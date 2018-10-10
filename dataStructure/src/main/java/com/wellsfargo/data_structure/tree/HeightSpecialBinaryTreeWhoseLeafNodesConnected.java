package com.wellsfargo.data_structure.tree;

public class HeightSpecialBinaryTreeWhoseLeafNodesConnected {

    private static Node root;

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "data->" + data;
        }
    }

    static Node newNode(int data) {
        Node node = new Node(data);
        return node;
    }

    static boolean isLeaf(Node node)
    {
        // If given node's left's right is pointing to given node
        // and its right's left is pointing to the node itself
        // then it's a leaf
        return node.left!=null  && node.left.right == node &&
                node.right!=null && node.right.left == node;
    }
    static int maxDepth(Node node)
    {
        // if node is NULL, return 0
        if (node == null)
            return 0;

        // if node is a leaf node, return 1
        if (isLeaf(node))
            return 1;

        // compute the depth of each subtree and take maximum
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

    public static void main(String[] args) {
        HeightSpecialBinaryTreeWhoseLeafNodesConnected nodesConnected =new HeightSpecialBinaryTreeWhoseLeafNodesConnected();
        root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.left.left.left = newNode(6);

        // Given tree contains 3 leaf nodes
        Node L1 = root.left.left.left;
        Node L2 = root.left.right;
        Node L3 = root.right;
        // set next pointer of linked list
        L1.right = L2; L2.right = L3; L3.right = L1;
        L3.left = L2; L2.left = L1; L1.left = L3;
        System.out.println(maxDepth(root));

    }
}
