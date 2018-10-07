package com.wellsfargo.data_structure.tree;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeContainsDuplicateSubtreesSize2OrMore {

    private static char  MARKER = '$';
    private static Map<String,String > subTree =new HashMap();

    static String dupSubUtil(Node root)
    {
        String s = "";

        // If current node is NULL, return marker
        if (root == null)
            return s + MARKER;

        // If left subtree has a duplicate subtree.
        String lStr = dupSubUtil(root.left);
        if (lStr.compareTo(s) == 0)
            return s;

        // Do same for right subtree
        String rStr = dupSubUtil(root.right);
        if (rStr.compareTo(s) == 0)
            return s;

        // Serialize current subtree
        s = s + root.data + lStr + rStr;

        // If current subtree already exists in hash
        // table. [Note that size of a serialized tree
        // with single node is 3 as it has two marker
        // nodes.
        if (s.length() > 3 &&
                subTree.containsKey(s))
            return "";

        subTree.put(s,s);

        return s;
    }

    public static void main(String[] args) {
        Node root = newNode("A");
        root.left = newNode("B");
        root.right = newNode("C");
        root.left.left = newNode("D");
        root.left.right = newNode("E");
        root.right.right = newNode("B");
        root.right.right.right = newNode("E");
        root.right.right.left= newNode("D");

        String str = dupSubUtil(root);

        if(str.compareTo("") == 0)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
    public static Node newNode(String key)
    {
        Node node = new Node(key);
        return node;
    }

    static  class Node
    {
        String data;
        Node left, right;

        Node(String item)
        {
            data = item;
            left = right  = null;
        }

        @Override
        public String toString() {
            return "data->"+data;
        }
    }
}
