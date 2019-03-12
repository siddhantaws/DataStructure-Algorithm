package com.wellsfargo.data_structure.tree;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class ConstructSpecialTreeFromPreorderTraversal {

    private int pre[];

    private char[] preLN;

    private Node root;


    public ConstructSpecialTreeFromPreorderTraversal(int[] pre, char[] preLN) {
        this.pre = pre;
        this.preLN = preLN;
    }

    public Node  construct(int l ){
        Node n =new Node(pre[l]);
        if(preLN[l]=='N'){
            n.setLeft(construct(l+1));
            n.setRight(construct(l+2));
        }
        return n;
    }


    public static void main(String[] args) {
        int pre[] = {10, 30, 20, 5, 15}; char  preLN[] = {'N', 'N', 'L', 'L', 'L'};
        ConstructSpecialTreeFromPreorderTraversal treeFromPreorderTraversal = new ConstructSpecialTreeFromPreorderTraversal(pre, preLN);

    }
    static class Node {
        int data;
        Node left, right;
        Node(int item) {
            data = item;
        }
        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
