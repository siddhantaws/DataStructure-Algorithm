package com.wellsfargo.data_structure.tree;

public class ConstructBinaryTreeFromStringWithBracket {

    private String str;

    public ConstructBinaryTreeFromStringWithBracket(String str) {
        this.str = str;
    }

    public Node constructTree(int index , int length){

        if(index>length)
            return null;
        Node n=null;
        if(str.charAt(index) =='(')
            n=new Node(Integer.valueOf((Character)str.charAt(++index)));
        else if(str.charAt(index) ==')')
            return null;
        else
            n=new Node(Integer.valueOf((Character)str.charAt(index)));

        n.left= constructTree(++index ,length );
        n.right= constructTree(++index ,length );
        return n;
    }


    public static void main(String[] args) {
        String str="4(2(3)(1))(6(5))";
        ConstructBinaryTreeFromStringWithBracket tree =new ConstructBinaryTreeFromStringWithBracket(str);
        tree.constructTree(0,str.length() );
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
