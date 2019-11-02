package com.amazon.question;

import java.util.Arrays;

public class NextGreaterElementII {
    private int arrr[];

    public NextGreaterElementII(int[] arrr) {
        this.arrr = arrr;
    }

    public int[] nextGreaterElements() {
        int arr1[] =new int[2*arrr.length];
        System.arraycopy(arrr,0,arr1,0, arrr.length);
        System.arraycopy(arrr,0,arr1,arrr.length, arrr.length);
        int lastValue =arr1[arr1.length-1];
        arr1[arr1.length-1]=arrr[arrr.length-1];
        for(int i=arr1.length-2;i>=0;i--){
            if(arr1[i]<lastValue){
                int temp =  lastValue;
                lastValue = arr1[i];
                arr1[i]=temp;
            }else{
                if(arr1[i]<arr1[i+1]){
                    lastValue =arr1[i];
                    arr1[i] =arr1[i+1];
                }else{
                    lastValue =arr1[i];
                    arr1[i]=-1;
                    for(int j=i+1;j<arr1.length;j++)
                        if(arr1[j]>lastValue){
                            arr1[i]=arr1[j];
                            break;
                        }
                }
            }
        }
        System.arraycopy(arr1,0,arrr,0, arrr.length);
        return arrr;
    }

    public static void main(String[] args) {
        NextGreaterElementII elementII =new NextGreaterElementII(new int[]{1,2,3,4,3});
        for(int i :elementII.nextGreaterElements())
            System.out.print(i+" ");
    }
}
