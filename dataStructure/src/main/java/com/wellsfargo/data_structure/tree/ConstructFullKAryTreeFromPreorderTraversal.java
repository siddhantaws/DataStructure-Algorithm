package com.wellsfargo.data_structure.tree;

import java.util.ArrayList;
import java.util.List;

public class ConstructFullKAryTreeFromPreorderTraversal {

    private int preOrder[];
    private int k;
    private static int ind;

    public ConstructFullKAryTreeFromPreorderTraversal(int[] preOrder, int k) {
        this.preOrder = preOrder;
        this.k = k;
    }

    Node newNode(int value) {
        Node nNode = new Node(value);
        return nNode;
    }

    void postord(Node root, int k) {
        if (root == null)
            return;
        for (int i = 0; i < k; i++)
            postord(root.child.get(i), k);
        System.out.println(root.key);
    }

    public Node buildKaryTree(int n, int k) {
        int height = (int) Math.ceil(Math.log((double) n * (k - 1) + 1)
                / Math.log((double) k));
        return buildKaryTree(n, k, height);
    }

    public Node buildKaryTree(int n, int k, int h) {
        // For null tree
        if (n <= 0)
            return null;

        Node nNode = newNode(preOrder[ind]);
        if (nNode == null) {
            return null;
        }
        for (int i = 0; i < k; i++) {
            // Check if ind is in range of array  Check if height of the tree is greater than 1
            if (ind < n - 1 && h > 1) {
                ind++;
                // Recursively add each child
                nNode.child.add(buildKaryTree(n, k, h - 1));
            }
        }
        return nNode;
    }

    public static void main(String[] args) {
        int preorder[] = {1, 2, 5, 6, 7, 3, 8, 9, 10, 4};
        int k = 3;
        ConstructFullKAryTreeFromPreorderTraversal tree = new ConstructFullKAryTreeFromPreorderTraversal(preorder, k);
        Node n =tree.buildKaryTree(preorder.length, k);
    }

    static class Node {
        int key;
        List<Node> child = new ArrayList<>();

        public Node(int key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "key->" + key;
        }
    }
}
