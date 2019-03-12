package com.wellsfargo.data_structure.tree;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class ChangeBinaryTreeEveryNodeStoresSumAllNodesLeftSubtree {

    private Node root;

    public int getSum(Node node){
        if(node==null)
            return 0;

        if(node.left==null || node.right==null)
            return node.data;
        int leftSum =getSum(node.left);
        int rightSum =getSum(node.right);

        return node.data+ leftSum+ rightSum;
    }

    static class Node {
        int data;

        Node left, right ;

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
