package com.wellsfargo.data_structure.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructTreeFromAncestorMatrix {

    private int [][]arr;
    private int N;
    public static boolean[] used;
    private Node root = null;
    private int[] sum ;
    private Node[] nodes;

    public ConstructTreeFromAncestorMatrix(int[][] arr) {
        this.arr = arr;
        this.N= arr.length;
        this.sum= new int[arr.length];
        this.nodes= new Node[arr.length];
        this.used= new boolean[arr.length];
    }

    public Node ComputeTree(int[] sum, Node[] nodes, int max) {
        used[max] = true;
        int next = -1;
        for(int i=0; i<sum.length; i++) {
            if(arr[max][i]==1 && next == -1 && !used[i])
                next = i;
            else if(arr[max][i]==1 && !used[i] && sum[i]>sum[next])
                next = i;
        }
        if(next != -1) {
            nodes[max].left = ComputeTree(sum, nodes, next);
        }
        next = -1;
        for(int i=0; i<sum.length; i++) {
            if(arr[max][i]==1 && next == -1 && !used[i])
                next = i;
            else if(arr[max][i]==1 && !used[i] && sum[i]>sum[next])
                next = i;
        }
        if(next != -1) {
            nodes[max].right = ComputeTree(sum, nodes, next);
        }
        return nodes[max];
    }


    private void printInorder(Node node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data+" ");
        printInorder(node.right);
    }

    public void levelOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            node = queue.poll();
            if(node != null) {
                System.out.print(node.data+" ");
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        System.out.println();
    }

    public Node AncestorToTree() {
        int max = 0;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                sum[i] += arr[i][j];
                if(sum[i] > sum[max])
                    max = i;
            }
        }
        for(int i=0; i<arr.length; i++)
            nodes[i] = new Node(i);
        root = ComputeTree(sum, nodes, max);
        return root;
    }

    static class  Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        int mat[][] = {{ 0, 0, 0, 0, 0, 0 },
                        { 1, 0, 0, 0, 1, 0 },
                        { 0, 0, 0, 1, 0, 0 },
                        { 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0 },
                        { 1, 1, 1, 1, 1, 0 }
        };
        ConstructTreeFromAncestorMatrix fromAncestorMatrix =new ConstructTreeFromAncestorMatrix(mat);
        fromAncestorMatrix.levelOrder(fromAncestorMatrix.AncestorToTree());
    }
}
