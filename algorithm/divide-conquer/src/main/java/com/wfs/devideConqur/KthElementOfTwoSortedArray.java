package com.wfs.devideConqur;

/**
 * Created by Suryasnata on 6/19/2017.
 * Given two sorted arrays of size m and n respectively, you are tasked with finding the element that would be at the k’th position of the final sorted array.
 * Input : Array 1 - 2 3 6 7 9 ,  Array 2 - 1 4 8 10 ,  k = 5
 * Explanation: The final sorted array would be -   1, 2, 3, 4, 6, 7, 8, 9, 10
 * The 5th element of this array is 6.
 */
public class KthElementOfTwoSortedArray {
    private int arr1[];
    private int arr2[];

    private int k;

    public KthElementOfTwoSortedArray(int[] arr1,int[] arr2, int k) {
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.k = k;
    }

    private int getNumber(int start1, int end1 , int start2, int end2, int k ){
        if(end1==arr1.length-1 && end1==start1)
            return arr2[start2+k-2];
        if(end2==arr2.length-1&& end2==start2)
            return arr1[start1+k-2];
        if(k==0){
            if(start1>0 && start2>0)
                return Math.max(arr1[start1-1], arr2[start2-1]);
            else if(start1==0)
                return arr2[start2-1];
            else
                return arr1[start1-1];
        }

        int mid1 = start1 + (end1-start1)/2; int len1= (end1-start1)+1;
        int mid2 = start2 + (end2-start2)/2; int len2= (end2-start2)+1;
        if(len1+len2 < k ){
            if(arr1[mid1] > arr2[mid2])
                return  getNumber(start1 , end1 , start2+(mid2-start2)+1, end2 ,k-(mid2-start2)-1);
            else
                return  getNumber(start1+(mid1-start1)+1 , end1 , start2, end2 ,k-(mid1-start1)-1);
        }else {
            if(arr1[mid1] > arr2[mid2])
                return  getNumber(start1 , end1 , start2+(mid2-start2)+1, end2 ,k-(mid2-start2)-1);
            else
                return  getNumber(start1+(mid1-start1)+1 , end1 , start2, end2 ,k-(mid1-start1)-1);
        }
    }
    //1 2 3 4 6 7 8 9 10
    public static void main(String[] args) {
        KthElementOfTwoSortedArray  element =new KthElementOfTwoSortedArray(new int[]{2 , 3 ,6, 7,9},new int[]{1 ,4 ,8 ,10} , 1);
        System.out.println(element.getNumber(0,element.arr1.length-1, 0 ,element.arr2.length-1 , element.k));
    }
}
