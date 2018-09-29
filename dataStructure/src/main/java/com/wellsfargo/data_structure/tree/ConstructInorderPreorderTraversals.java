package com.wellsfargo.data_structure.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructInorderPreorderTraversals {

    private char[] inOrder ;
    private char[] preOrder ;
    static int preIndex = 0;
    public ConstructInorderPreorderTraversals(char[] inOrder, char[] preOrder) {
        this.inOrder = inOrder;
        this.preOrder = preOrder;
    }

    Node buildTree (int inStrt, int inEnd, Map<Character ,  Integer> mp)
    {


        if (inStrt > inEnd)
            return null;

        char curr = preOrder[preIndex++];
        Node tNode = new Node(curr);

        /* If this node has no children then return */
        if (inStrt == inEnd)
            return tNode;

        /* Else find the index of this node in Inorder traversal */
        int inIndex = mp.get(curr);

        /* Using index in Inorder traversal, construct left and
        right subtress */
        tNode.left = buildTree( inStrt, inIndex - 1, mp);
        tNode.right = buildTree( inIndex + 1, inEnd, mp);

        return tNode;
    }

    Node buldTreeWrap()
    {
        // Store indexes of all items so that we
        // we can quickly find later
        Map<Character ,  Integer> map= new HashMap<>();
        for (int i = 0; i < inOrder.length-1; i++)
            map.put(inOrder[i], i);
        return buildTree(0, inOrder.length-1, map);
    }

    void printInorder(Node node)
    {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.println(node);
        printInorder(node.right);
    }

    public static void main(String[] args) {
        char in[] = {'1','2','3','4','5','6','7'};
        char pre[] = { '4','2','1','3','6','5','7'};
        ConstructInorderPreorderTraversals constructInorderPreorderTraversals=new ConstructInorderPreorderTraversals(in , pre);
        constructInorderPreorderTraversals.printInorder(constructInorderPreorderTraversals.buldTreeWrap());
    }
}

class Node {
    char data;
    Node left, right;

    Node(char item)
    {
        data = item;
        left = right = null;
    }

    @Override
    public String toString() {
        return data+"";
    }
}