package com.wellsfargo.data_structure.tree;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class ConvertLeftRightRepresentationBinaryTreeDownRight {
    private Node root;


    private Node convert(Node n){

        if(n==null)
            return null;

        convert(n.left);
        convert(n.right);

        if(n.left==null)
            n.left =n.right;
        else
            n.left.right =n.right;

            n.right=null;
        return n;
    }

    public Node convert(){
        return convert(root);
    }

    static class Node {
        int data;

        Node left, right , middle;

        Node(int item) {
            data = item;
        }
        public void setMiddle(Node middle) {
            this.middle = middle;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
