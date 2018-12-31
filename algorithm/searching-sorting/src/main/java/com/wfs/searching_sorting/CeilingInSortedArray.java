package com.wfs.searching_sorting;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class CeilingInSortedArray {

    private int arr[];

    private int num;

    public CeilingInSortedArray(int[] arr, int num) {
        this.arr = arr;
        this.num=num;
    }

    public int ceil(){
        int low = 0;int high =arr.length-1;
        int mid =-1;
        while(low<high){
            mid =low+(high-low)/2;
            if(arr[mid]==num)
                return mid;
            else if(arr[mid]>num)
                high =mid;
            else
                low=mid +1;
        }
        return low;
    }

    public static void main(String[] args) {
        int arr[]={1, 2, 8, 10, 10, 12, 19};
        CeilingInSortedArray ceiling =new CeilingInSortedArray(arr, 15);
        System.out.println(ceiling.ceil());
    }
}
