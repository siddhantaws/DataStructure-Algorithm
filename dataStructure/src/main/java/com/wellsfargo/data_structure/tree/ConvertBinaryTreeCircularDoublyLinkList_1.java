package com.wellsfargo.data_structure.tree;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class ConvertBinaryTreeCircularDoublyLinkList_1 {

    private Node root;

    public ConvertBinaryTreeCircularDoublyLinkList_1(Node root) {
        this.root = root;
    }

    // concatenate both the lists and returns the head of the List
    public Node concatenate(Node leftList,Node rightList)
    {
        // If either of the list is empty, then return the other list
        if (leftList == null)
            return rightList;
        if (rightList == null)
            return leftList;

        // Store the last Node of left List
        Node leftLast = leftList.left;
        // Store the last Node of right List
        Node rightLast = rightList.left;
        // Connect the last node of Left List with the first Node of the right List
        leftLast.right = rightList;
        rightList.left = leftLast;
        // left of first node refers to the last node in the list
        leftList.left = rightLast;
        // Right of last node refers to the first node of the List
        rightLast.right = leftList;
        // Return the Head of the List
        return leftList;
    }
    private Node  bTreeToCList(){
        return bTreeToCList(root);
    }
    // Method converts a tree to a circular Link List and then returns the head  of the Link List
    public Node bTreeToCList(Node root) {
        if (root == null)
            return null;
        // Recursively convert left and right subtrees
        Node left = bTreeToCList(root.left);
        Node right = bTreeToCList(root.right);
        // Make a circular linked list of single node  (or root). To do so, make the right and
        // left pointers of this node point to itself
        root.left = root.right = root;
        // Step 1 (concatenate the left list with the list  with single node, i.e., current node)
        // Step 2 (concatenate the returned list with the right List)
        return concatenate(concatenate(left, root), right);
    }

    public static void main(String[] args) {
        Node tree = new Node(10);
       tree.left = new Node(12);
        tree.right = new Node(15);
        ConvertBinaryTreeCircularDoublyLinkList_1  circularDoublyLinkList1 =new ConvertBinaryTreeCircularDoublyLinkList_1(tree);
        circularDoublyLinkList1.bTreeToCList();
    }
    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            left = right = null;
        }

        @Override
        public String toString() {
            return "data->"+val;
        }
    }
}
