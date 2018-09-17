package com.wellsfargo.data_structure.queue;

public class DequeUsingCircularArray {

    private int arr[] ;
    private int  front;
    private int  rear;
    private int  size;
    public DequeUsingCircularArray(int[] arr) {
        this.arr = arr;
        this.front=-1;
        this.rear=0;
        this.size=this.arr.length;
    }

    public boolean isFull(){
       return  ((front==0 && rear==size-1 )|| (front==rear+1) );
    }

    public void push(int element){
        if(isFull())
            System.err.println("Queue is full");

        if(front ==-1){
            front =0;rear=0;
        }
        
    }
}

