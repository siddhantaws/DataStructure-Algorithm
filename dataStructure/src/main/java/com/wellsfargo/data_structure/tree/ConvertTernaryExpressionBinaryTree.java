package com.wellsfargo.data_structure.tree;

public class ConvertTernaryExpressionBinaryTree {
    private String expression;

    public ConvertTernaryExpressionBinaryTree(String expression) {
        this.expression = expression;
    }

    public Node convertTobinaryTree(int start,int end ){

        if(start>end)
            return null;

        Node N=new Node(expression.charAt(start));

        if(expression.charAt(start)=='?')
            N.left =convertTobinaryTree(start++,end );
        if(expression.charAt(start)==':')
            N.right =convertTobinaryTree(start++,end );

        return N;
    }

    static class Node
    {
        char data;
        Node left, right;

        public Node(char item)
        {
            data = item;
            left = null;
            right = null;
        }
    }
}
