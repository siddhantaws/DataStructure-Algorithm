package com.wellsfargo.data_structure.tree;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class PrintPostorderTraversalFromInorderPreorderTraversals {

    private int inOrder[];

    private int preOrder[];

    private int postOrder[];
    int count =0;

    public PrintPostorderTraversalFromInorderPreorderTraversals(int[] inOrder, int[] preOrder) {
        this.inOrder = inOrder;
        this.preOrder = preOrder;
        this.postOrder =new int[inOrder.length];
    }

    public void populatePostOrder(int inl1, int inr1, int prel1, int prer1){
        if(inr1==inl1){
            postOrder[count++] =inOrder[inr1];
        }else{
            int index = searchinInOrder(preOrder[prel1] ,inl1 ,inr1);
            populatePostOrder(inl1 ,inl1+ index -1,prel1+1 ,prel1+ index );
            populatePostOrder(index+1 , inr1,prel1+ index ,prer1 );
            postOrder[count++] =inOrder[index];
        }
    }

    private int searchinInOrder(int num , int inl1,int inl2){
        for(int i=inl1;i<=inl2;i++)
            if(inOrder[i]==num)
                return i;
        return -1;
    }


}
