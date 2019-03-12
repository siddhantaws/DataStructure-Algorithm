package com.wellsfargo.data_structure.tree;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class ConstructTreeFromInorderLevelOrderTraversals {

    private int inOrder[];

    private int levelOrder[];

    public ConstructTreeFromInorderLevelOrderTraversals(int[] inOrder, int[] levelOrder) {
        this.inOrder = inOrder;
        this.levelOrder = levelOrder;
    }



    public Node constructBinaryTree(int inL,int inR){
        if(inL>inR)
            return null;
        if(inL==inR)
            return new Node(inOrder[inL]);
        int i1=-1;
        for(int i=0;i<levelOrder.length;i++){
            for(i1=inL;i1<=inR;i1++)
                if(levelOrder[i]==inOrder[i1])
                    break;
        }

        Node n =new Node(inOrder[i1]);
        n.setLeft(constructBinaryTree(inL , i1-1));
        n.setRight(constructBinaryTree(i1+1,inR));
        return n;
    }


    public static void main(String[] args) {
        int in[]    = {4, 8, 10, 12, 14, 20, 22};
        int level[] = {20, 8, 22, 4, 12, 10, 14};
        ConstructTreeFromInorderLevelOrderTraversals tree =new ConstructTreeFromInorderLevelOrderTraversals(in,level);

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
