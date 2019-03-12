package com.wellsfargo.data_structure.tree;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class CalculateDepthFullBinaryTreeFromPreorder {

    private char[] preOrder ;

    private int N ;

    public CalculateDepthFullBinaryTreeFromPreorder(String preOrder) {
        this.preOrder = preOrder.toCharArray();
        this.N= preOrder.length();
    }

    public int getDepth(){
        return getDepth(0);
    }

    private int getDepth(int index ){
        if(index >N  || preOrder[index]=='l')
            return 0;
        index ++;
        int left =1+ getDepth(index);
        index ++;
        int right =1+ getDepth(index);
        return Math.max(left , right);
    }

}
