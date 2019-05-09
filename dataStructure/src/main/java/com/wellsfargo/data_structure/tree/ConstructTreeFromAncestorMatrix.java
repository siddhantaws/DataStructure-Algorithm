package com.wellsfargo.data_structure.tree;

import java.util.ArrayList;
import java.util.TreeMap;

public class ConstructTreeFromAncestorMatrix {

    private int [][]matrix;
    private int N ;
    private Node root;
    public ConstructTreeFromAncestorMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.N =matrix.length;
    }
    static class Node {
        int data ;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node newNode(int data) {
        Node node = new Node(data);
        return (node);
    }

    Node constructTreeFromAncestorMatrix() {
        // parent[i] = true means parent of i is set
        boolean[] parent = new boolean[N];

        Node root = null;

        // TreeMap is used to keep the array sorted according to key
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer,ArrayList<Integer>>();

        // get sum of all rows and put sum and corresponding list of row-numbers in the TreeMap
        for(int i=0;i<N;i++) {
            int sum = 0;
            for(int j=0;j<N;j++)
                sum += matrix[i][j];

            if(map.get(sum) == null) {
                ArrayList<Integer> arr = new ArrayList<Integer>();
                arr.add(i);
                map.put(sum,arr);
            }
            else
                map.get(sum).add(i);
        }

        // nodes[i] stores ith node
        Node[] nodes = new Node[N];

        // iterate over TreeMap
        for(Integer key : map.keySet()) {
            ArrayList<Integer> arr = map.get(key);

            for(Integer row : arr) {
                nodes[row] = new Node(row);
                root = nodes[row];
                // non-leaf node
                if(key != 0) {// traverse row "row"
                    for(int i=0;i<N;i++) {// If parent doesn't exist and ancestor exists
                        if(!parent[i] && matrix[row][i]==1) {
                            if(nodes[row].left == null)
                                nodes[row].left = nodes[i];
                            else
                                nodes[row].right = nodes[i];
                            parent[i] = true;
                        }
                    }
                }
            }
        }
        printInorder(root);
        return root;
    }

    /* Given a binary tree, print its nodes in inorder */
    void printInorder(Node node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.println(node.data);
        printInorder(node.right);
    }

    public static void main(String[] args) {

        int mat[][] = {{ 0, 0, 0, 0, 0, 0 },
            { 1, 0, 0, 0, 1, 0 },
            { 0, 0, 0, 1, 0, 0 },
            { 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0 },
            { 1, 1, 1, 1, 1, 0 }
        };
        ConstructTreeFromAncestorMatrix treeFrom =new ConstructTreeFromAncestorMatrix(mat);
        treeFrom.constructTreeFromAncestorMatrix();
    }
}
