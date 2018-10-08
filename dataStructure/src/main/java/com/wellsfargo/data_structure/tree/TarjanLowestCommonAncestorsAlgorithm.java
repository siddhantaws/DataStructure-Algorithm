package com.wellsfargo.data_structure.tree;

public class TarjanLowestCommonAncestorsAlgorithm {

    private static int WHITE = 1;
    private static int BLACK = 2;
    private static int V = 5;

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    static class Query {
        int L, R;

        public Query(int l, int r) {
            L = l;
            R = r;
        }
    }

    static class Subset {
        int parent, rank, ancestor, child, sibling, color;

        Subset(int color) {
            this.color = color;
        }
    }

    static Node newNode(int data) {
        Node node = new Node(data);
        return (node);
    }

    //A utility function to make set
    static void makeSet(Subset subsets[], int i) {
        if (i < 1 || i > V)
            return;

        subsets[i].color = WHITE;
        subsets[i].parent = i;
        subsets[i].rank = 0;

        return;
    }

    // A utility function to find set of an element i
    // (uses path compression technique)
    static int findSet(Subset subsets[], int i) {
        // find root and make root as parent of i (path compression)
        if (subsets[i].parent != i)
            subsets[i].parent = findSet(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    // A function that does union of two sets of x and y
    // (uses union by rank)
    static void unionSet(Subset subsets[], int x, int y) {
        int xroot = findSet(subsets, x);
        int yroot = findSet(subsets, y);

        // Attach smaller rank tree under root of high rank tree
        // (Union by Rank)
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;

            // If ranks are same, then make one as root and increment
            // its rank by one
        else {
            subsets[yroot].parent = xroot;
            (subsets[xroot].rank)++;
        }
    }

    // This is basically an inorder traversal and we preprocess the arrays-> child[]
    // and sibling[] in "struct subset" with the tree structure using this function.
    static void preprocess(Node node, Subset subsets[]) {

        if (node == null)
            return;

        // Recur on left child
        preprocess(node.left, subsets);

        if (node.left != null && node.right != null) {
        /* Note that the below two lines can also be this-
        subsets[node->data].child = node->right->data;
        subsets[node->right->data].sibling =
                                         node->left->data;

        This is because if both left and right children of
        node-'i' are present then we can store any of them
        in subsets[i].child and correspondingly its sibling*/
            subsets[node.data].child = node.left.data;
            subsets[node.left.data].sibling =
                    node.right.data;

        } else if ((node.left != null && node.right == null)
                || (node.left == null && node.right != null)) {
            if (node.left != null && node.right == null)
                subsets[node.data].child = node.left.data;
            else
                subsets[node.data].child = node.right.data;
        }
        //Recur on right child
        preprocess(node.right, subsets);
    }

    public static void main(String[] args) {
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(25);

        // LCA Queries to answer
        Query q[] = {new Query(5, 4), new Query(1, 3), new Query(2, 3)};

        printLCAs(root, q, q.length);
    }

    static void initialise(Subset subsets[]) {
        // We colour all nodes WHITE before LCA Walk.
        for (int i = 1; i < subsets.length; i++)
            subsets[i] = new Subset(WHITE);

        return;
    }

    // Prints LCAs for given queries q[0..m-1] in a tree with given root
    static void printLCAs(Node root, Query q[], int m) {
        // Allocate memory for V subsets and nodes
        Subset subsets[] = new Subset[V + 1];

        // Creates subsets and colors them WHITE
        initialise(subsets);

        // Preprocess the tree
        preprocess(root, subsets);

        // Perform a tree walk to process the LCA queries
        // offline
        lcaWalk(root.data, q, m, subsets);
    }

    // The main function that prints LCAs. u is root's data. m is size of q[]
    static void lcaWalk(int u, Query q[], int m, Subset subsets[]) {
        // Make Sets
        makeSet(subsets, u);

        // Initially, each node's ancestor is the node
        // itself.
        subsets[findSet(subsets, u)].ancestor = u;

        int child = subsets[u].child;

        // This while loop doesn't run for more than 2 times
        // as there can be at max. two children of a node
        while (child != 0) {
            lcaWalk(child, q, m, subsets);
            unionSet(subsets, u, child);
            subsets[findSet(subsets, u)].ancestor = u;
            child = subsets[child].sibling;
        }

        subsets[u].color = BLACK;

        for (int i = 0; i < m; i++) {
            if (q[i].L == u) {
                if (subsets[q[i].R].color == BLACK) {
                    System.out.println("LCA " + q[i].L + "\t" + q[i].R + "\t" + subsets[findSet(subsets, q[i].R)].ancestor);
                }
            } else if (q[i].R == u) {
                if (subsets[q[i].L].color == BLACK) {
                    System.out.println("LCA " + q[i].L + "\t" + q[i].R + "\t" + subsets[findSet(subsets, q[i].L)].ancestor);
                }
            }
        }

        return;
    }
}
