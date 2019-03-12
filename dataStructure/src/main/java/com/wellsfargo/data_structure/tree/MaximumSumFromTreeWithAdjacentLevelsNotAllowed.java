package com.wellsfargo.data_structure.tree;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MaximumSumFromTreeWithAdjacentLevelsNotAllowed {

    private Node root;

    private int calculateAltSum(Node n) {
        if(n ==null)
             return 0;
        int sum =  n.data;
        if(n.left!=null){
            sum =sum + calculateAltSum(n.left.left);
            sum =sum + calculateAltSum(n.left.right);
        }

        if(n.right!=null){
            sum =sum + calculateAltSum(n.right.left);
            sum =sum + calculateAltSum(n.right.right);
        }
        return sum;
    }

    public int CalculateMaxSum() {
        return Math.max(calculateAltSum(root) , calculateAltSum(root.left)+calculateAltSum(root.right));
    }



    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
        }

        @Override
        public String toString() {
            return "data->"+data;
        }
    }
}
