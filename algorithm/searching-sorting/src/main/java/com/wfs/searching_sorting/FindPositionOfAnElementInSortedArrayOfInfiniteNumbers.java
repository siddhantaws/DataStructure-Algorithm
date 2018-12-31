package com.wfs.searching_sorting;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class FindPositionOfAnElementInSortedArrayOfInfiniteNumbers {
    private int arr[];
    private int num ;
    int low , high;


    public FindPositionOfAnElementInSortedArrayOfInfiniteNumbers(int[] arr, int num) {
        this.arr = arr;
        this.num = num;
        this.low=0;
        this.high =low+1;
    }

    public int getPosition(){
        while(arr[high]<num){
            low =high ;
            high =high<<1;
        }
        return getbinarySearch();
    }

    private int getbinarySearch(){
        while(high>low){
            int mid = low + ((high-low)>>1);
            if(arr[mid] == num)
                return mid;
            else if(arr[mid] > num)
                high =mid;
            else
                low =mid+1;
        }
        return -1 ;
    }
}
