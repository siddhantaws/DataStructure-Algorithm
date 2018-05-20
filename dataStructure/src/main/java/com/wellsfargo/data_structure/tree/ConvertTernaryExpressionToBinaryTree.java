package com.wellsfargo.data_structure.tree;

public class ConvertTernaryExpressionToBinaryTree {

    private String ternaryString ;

    private AbstractTree.Entry entry;

    public ConvertTernaryExpressionToBinaryTree(String ternaryString) {
        this.ternaryString = ternaryString;
        this.entry=new AbstractTree.Entry();
    }

    public AbstractTree.Entry getBinaryTree(){
        entry=new AbstractTree.Entry(ternaryString.charAt(0));
        return getBinaryTree(entry , 1);
    }

    private AbstractTree.Entry getBinaryTree(AbstractTree.Entry entry ,int i){
        if(i+1>=ternaryString.length())
            return null;
        if(ternaryString.charAt(i)=='?'){
            entry.setLeft(new AbstractTree.Entry(ternaryString.charAt(i+1)));
            getBinaryTree(entry.getLeft() , i+2);
            entry.setRight(new AbstractTree.Entry(ternaryString.charAt(i+3)));
            getBinaryTree(entry.getRight() , i+4);
        }
        return entry;
    }

    public static void main(String[] args) {
        ConvertTernaryExpressionToBinaryTree convertTernaryExpressionToBinaryTree =new ConvertTernaryExpressionToBinaryTree("a?b?c:d:e");
        convertTernaryExpressionToBinaryTree.getBinaryTree();
    }
}
