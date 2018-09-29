package com.wellsfargo.data_structure.tree;

public class ConstructSpecialTreeGivenPreorderTraversal {


    private int[] pre ;
    private char[] preLN ;
    Node root;

    public ConstructSpecialTreeGivenPreorderTraversal(int[] pre , char[] preLN) {
        this.pre = pre;
        this.preLN = preLN;
        this.myindex =new Index();
    }

    Index myindex ;

    // A wrapper over constructTreeUtil()
    Node constructTree(int n, Node node) {
        // Initialize index as 0. Value of index is used in recursion to
        // maintain the current index in pre[] and preLN[] arrays.
        int index = 0;

        return constructTreeUtil(myindex, n, node);
    }

    Node constructTreeUtil(Index index_ptr, int n, Node temp) {
        // store the current value of index in pre[]
        int index = index_ptr.index;

        // Base Case: All nodes are constructed
        if (index == n)
            return null;

        // Allocate memory for this node and increment index for
        // subsequent recursive calls
        temp = new Node(pre[index]);
        (index_ptr.index)++;

        // If this is an internal node, construct left and right subtrees
        // and link the subtrees
        if (preLN[index] == 'N') {
            temp.left = constructTreeUtil( index_ptr, n,
                    temp.left);
            temp.right = constructTreeUtil( index_ptr, n,
                    temp.right);
        }

        return temp;
    }

    /* This function is used only for testing */
    void printInorder(Node node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.data + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    public static void main(String[] args) {
        int pre[] = new int[]{10, 30, 20, 5, 15};
        char preLN[] = new char[]{'N', 'N', 'L', 'L', 'L'};
        ConstructSpecialTreeGivenPreorderTraversal traversal =new ConstructSpecialTreeGivenPreorderTraversal(pre , preLN);
        traversal.printInorder(traversal.constructTree(pre.length, traversal.root));
    }

    static class Index {
        int index = 0;

        @Override
        public String toString() {
            return "Index->"+index;
        }
    }

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }

        @Override
        public String toString() {
            return "data->"+data;
        }
    }
}
