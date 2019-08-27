package com.wfs.orderstatistics;

import java.util.List;

public class KSmallestElementsSameOrderUsingO_1 {
    private int arr[];
    private int k;

    public KSmallestElementsSameOrderUsingO_1(int[] arr, int k) {
        this.arr = arr;
        this.k = k;
    }

    public void getKthSmallest(){
        for(int i=k;i<arr.length;i++){
            int max =arr[k-1];
            int pos =k-1;

            for(int j= k-2;j>0;j--){
                if(max<arr[j]){
                    max=arr[j];
                    pos= j;
                }
            }
            if(max>arr[i]){
                int l= pos;
                while(l<i){
                    arr[l]=arr[l+1];
                    l++;
                }
                arr[i]=arr[l-1];
            }
        }
        for(int i=0;i<k;i++)
            System.out.print(arr[i]+" ");
    }
}
