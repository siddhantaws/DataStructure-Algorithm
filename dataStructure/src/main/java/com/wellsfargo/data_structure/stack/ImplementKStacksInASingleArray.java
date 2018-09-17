package com.wellsfargo.data_structure.stack;

public class ImplementKStacksInASingleArray {

    private int[] topOfStack;
    private int[] stackData;
    private int[] nextIndex;
    private int nextAvailable;

    public ImplementKStacksInASingleArray(int stackNo, int stackSize ) {
        this.topOfStack=new int[stackNo];
        this.stackData=new int[stackSize];
        this.nextIndex =new int[stackSize];
        this.nextAvailable =0;

        for(int i=0;i<topOfStack.length-1;i++)
            topOfStack[i]=-1;
        for(int i=0;i<nextIndex.length-1;i++)
            nextIndex[i]=i+1;
        nextIndex[nextIndex.length-1]=-1;
    }

    public void push(int index , int data){
        if(index>topOfStack.length-1 || nextAvailable >stackData.length-1 )
            throw new IndexOutOfBoundsException();

        int currIndex =nextAvailable ;
        stackData[currIndex]=data ;
        nextAvailable =nextIndex[currIndex];
        nextIndex[currIndex]= topOfStack[index];
        topOfStack[index] =currIndex;
    }

    public int pop(int stackIndex){
        int currIndex =topOfStack[stackIndex];
        int element =stackData[currIndex];
        topOfStack[stackIndex] = nextIndex[currIndex];
        nextIndex[currIndex]= nextAvailable;
        nextAvailable = currIndex;
        return element;
    }

    public static void main(String[] args) {
        ImplementKStacksInASingleArray array =new ImplementKStacksInASingleArray(3 ,10);
        array.push(0,10);
        array.push(0,20);
        array.push(0,30);
    }
}