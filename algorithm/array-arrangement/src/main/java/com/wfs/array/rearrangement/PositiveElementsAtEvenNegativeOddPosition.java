package com.wfs.array.rearrangement;

public class PositiveElementsAtEvenNegativeOddPosition {

    private int [] arr;

    public PositiveElementsAtEvenNegativeOddPosition(int[] arr) {
        this.arr = arr;
    }

    public void rearrange(){
        int pos=0; int neg=1;
        int size=arr.length;
        while (true){
            while(pos<size && arr[pos]>0)
                pos+=2;
            while(neg<size && arr[neg]<0)
                neg+=2;

            if(pos<size && neg<size)
                swap(pos,neg);
            else
                break;
        }
    }

    private void swap(int i, int j){
        arr[i]=arr[i]^ arr[j];
        arr[j]=arr[i]^ arr[j];
        arr[i]=arr[j]^ arr[i];
    }
}
