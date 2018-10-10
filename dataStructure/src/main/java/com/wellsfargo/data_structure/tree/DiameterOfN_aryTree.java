package com.wellsfargo.data_structure.tree;

import java.util.ArrayList;
import java.util.List;

public class DiameterOfN_aryTree {
    private static Node root;

    static class Node {
        String key;
        List<Node> child = new ArrayList<>();

        public Node(String key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "data->" + key;
        }
    }

    static Node newNode(String key) {
        Node temp = new Node(key);
        return temp;
    }

    static int depthOfTree(Node ptr) {
        // Base case
        if (ptr == null)
            return 0;

        int maxdepth = 0;

        // Check for all children and find
        // the maximum depth
        for (Node node : ptr.child) {
            maxdepth = Math.max(maxdepth, depthOfTree(node));
        }
        return maxdepth + 1;
    }

    static int diameter(Node ptr)
    {
        // Base case
        if (ptr==null)
            return 0;

        // Find top two highest children
        int max1 = 0, max2 = 0;
        for (Node node : ptr.child) {
            int h = depthOfTree(node);
            if (h > max1){
                max2 = max1; max1 = h;
            }else if (h > max2)
                max2 = h;
        }
        // Iterate over each child for diameter
        int maxChildDia = 0;
        for (Node node : ptr.child) {
            maxChildDia = Math.max(maxChildDia, diameter(ptr));
        }
        return Math.max(maxChildDia, max1 + max2 + 1);
    }

    public static void main(String[] args) {
        root = newNode("A");
        (root.child).add(newNode("B"));
        (root.child).add(newNode("F"));
        (root.child).add(newNode("D"));
        (root.child).add(newNode("E"));
        (root.child.get(0).child).add(newNode("K"));
        (root.child.get(0).child).add(newNode("J"));
        (root.child.get(2).child).add(newNode("G"));
        (root.child.get(3).child).add(newNode("C"));
        (root.child.get(3).child).add(newNode("H"));
        (root.child.get(3).child).add(newNode("I"));
        (root.child.get(0).child.get(0).child).add(newNode("N"));
        (root.child.get(0).child.get(0).child).add(newNode("M"));
        (root.child.get(3).child.get(2).child).add(newNode("L"));
        System.out.println(diameter(root));
    }
}
