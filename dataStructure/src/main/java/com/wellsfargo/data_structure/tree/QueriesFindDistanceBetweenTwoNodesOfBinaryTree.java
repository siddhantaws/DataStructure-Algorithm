/*
package com.wellsfargo.data_structure.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueriesFindDistanceBetweenTwoNodesOfBinaryTree {

    static int MAX = 10;
    // Array to store level of each node
    static int level[] = new int[MAX];
    ;
    static int Euler[] = new int[MAX];
    static int idx = 0;
    // checks for visited nodes
    static int vis[] = new int[MAX];
    ;

    // Stores level of Euler Tour
    static int L[] = new int[MAX];
    ;

    // Stores indices of first occurrence
// of nodes in Euler tour
    static int H[] = new int[MAX];
    ;

    static Pair seg[] = new Pair[4 * MAX];


    static void eulerTree(Node root) {

        // store current node's data
        Euler[++idx] = root.data;

        // If left node exists
        if (root.left != null) {

            // traverse left subtree
            eulerTree(root.left);

            // store parent node's data
            Euler[++idx] = root.data;
        }

        // If right node exists
        if (root.right != null) {
            // traverse right subtree
            eulerTree(root.right);

            // store parent node's data
            Euler[++idx] = root.data;
        }
    }

    static void preprocessEuler(int size) {
        for (int i = 1; i <= size; i++) {
            L[i] = level[Euler[i]];

            // If node is not visited before
            if (vis[Euler[i]] == 0) {
                // Add to first occurrence
                H[Euler[i]] = i;

                // Mark it visited
                vis[Euler[i]] = 1;
            }
        }
    }

    static void FindLevels(Node root) {
        if (root != null)
            return;

        // queue to hold tree node with level
        Queue<Pair> q = new ArrayDeque<>();

        // let root node be at level 0
        q.add(new Pair(root, 0));

        Pair p;

        // Do level Order Traversal of tree
        while (!q.isEmpty()) {
            p = q.peek();
            q.poll();

            // Node p.first is on level p.second
            level[p.node.data] = p.height;

            // If left child exits, put it in queue
            // with current_level +1
            if (p.node.left != null)
                q.add((new Pair(p.node.left, p.height + 1));

            // If right child exists, put it in queue
            // with current_level +1
            //if (p.node.right != null)
              //  q.add(new Pair(p.node.right, p.height + 1);
        }
    }

    static void preProcessing(Node root, int N) {
        // Build Tree
        eulerTree(root);

        // Store Levels
        FindLevels(root);

        // Find L and H array
        preprocessEuler(2 * N - 1);

        // Build segment Tree
        buildSegTree(1, 2 * N - 1, 1);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }


    // Utility function to build segment tree
    static void buildSegTree(int low, int high, int pos) {
        if (low == high) {
            seg[pos] = new Pair(L[low], low);
            return;
        }
        int mid = low + (high - low) / 2;
        buildSegTree(low, mid, 2 * pos);
        buildSegTree(mid + 1, high, 2 * pos + 1);

        seg[pos] = new Pair(Math.min(seg[2 * pos], seg[2 * pos + 1]));
    }


    static Node newNode(int data) {
        Node temp = new Node(data);
        return temp;
    }

    static class Pair implements Comparable<Pair> {
        Node node;
        int height;

        public Pair(Node node, int height) {
            this.node = node;
            this.height = height;
        }

        @Override
        public int compareTo(Pair o) {
            return o.node.data - this.node.data;
        }
    }
}
*/
