package com.wellsfargo.data_structure.tree;

public class ConstructBinaryTreePreorderAndPreorderImageTraversal {

    private int[] preOrder;
    private int[] preOrderImg;
    private static int preIndex =0;

    public ConstructBinaryTreePreorderAndPreorderImageTraversal(int[] preOrder, int[] preOrderImg) {
        this.preOrder = preOrder;
        this.preOrderImg = preOrderImg;
    }
    Node newNode(int data)
    {
        Node temp =new Node(data);
        return temp;
    }

    public Node constructBinaryTreeUtil(int l,int h)
    {
        // Base case
        if (preIndex >= preOrder.length || l > h)
            return null;

        // The first node in preorder traversal is root.
        // So take the node at preIndex from preorder and
        // make it root, and increment preIndex
        Node root = newNode(preOrder[preIndex]);
        ++(preIndex);

        // If the current subarry has only one element,
        // no need to recur
        if (l == h)
            return root;

        // Search the next element of pre[] in preM[]
        int i;
        for (i = l; i <= h; ++i)
            if (preOrder[preIndex] == preOrderImg[i])
                break;

        // construct left and right subtrees recursively
        if (i <= h)
        {
            root.left = constructBinaryTreeUtil ( i, h);
            root.right = constructBinaryTreeUtil (l+1, i-1);
        }
        // return root
        return root;
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
        int preOrder[] = {1,2,4,5,3,6,7};
        int   preOrderMirror[] = {1,3,7,6,2,5,4};
        ConstructBinaryTreePreorderAndPreorderImageTraversal traversal =new ConstructBinaryTreePreorderAndPreorderImageTraversal(preOrder , preOrderMirror);
        traversal.printInorder(traversal.constructBinaryTreeUtil(0, preOrder.length-1));
    }

    static class Node {
        int key;
        Node left, right;

        Node(int item)
        {
            key = item;
            left = right = null;
        }

        @Override
        public String toString() {
            return key+"";
        }
    }

}
