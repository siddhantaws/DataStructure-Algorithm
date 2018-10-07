package com.wellsfargo.data_structure.tree;

public class RemoveEdgesConnectedNodeThreeGivenNodesDifferentTrees {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }

        @Override
        public String toString() {
            return "data->" + data;
        }
    }

    private Node root;

    static Node findNode(Node root, int a, int b, int c) {
        // lca of a, b
        Node x = getLCA(root, a, b);

        // lca of b, c
        Node y = getLCA(root, b, c);

        // lca of c, a
        Node z = getLCA(root, c, a);

        if (x.data == y.data)
            return z;
        else if (x.data == z.data)
            return y;
        else
            return x;
    }


    public static Node getLCA(Node n, int a, int b) {

        if (n == null)
            return null;

        if (n.data == a || n.data == b)
            return n;

        Node left = getLCA(n.left, a, b);
        Node right = getLCA(n.right, a, b);

        if (left != null && right != null)
            return n;
        if (left == null)
            return right;
        else
            return left;
    }

    static Node newNode(int key) {
        Node temp = new Node(key);
        return (temp);
    }

    public static void main(String[] args) {
        // Insert elements in the tree
        Node root = newNode(1);

        root.left = newNode(2);
        root.right = newNode(3);

        root.left.left = newNode(4);
        root.left.right = newNode(5);

        root.left.left.left = newNode(8);
        root.left.left.right = newNode(9);

        root.left.right. left = newNode(10);
        root.left.right. right = newNode(11);

        root.right.left = newNode(6);
        root.right.right = newNode(7);
        root.right.left .left = newNode(12);
        root.right.left .right = newNode(13);
        root.right.right. left = newNode(14);
        root.right.right. right = newNode(15);
        System.out.println(findNode(root, 5, 6, 15));
    }
}
