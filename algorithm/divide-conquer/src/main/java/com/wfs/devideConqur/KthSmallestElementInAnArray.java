package com.wfs.devideConqur;

public class KthSmallestElementInAnArray {
    private int arr1[];

    private int arr2[];

    private int k ;

    public KthSmallestElementInAnArray(int[] arr1, int[] arr2, int k) {
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.k=k;
    }

    public int getKthSmallest(){
       return getKthSmallestElement(k , 0, arr1.length-1, 0,arr2.length-1);
    }

    private int getKthSmallestElement(int k , int l1, int r1, int l2, int r2){
        int n1= r1-l1+1;
        int n2= r2-l2+1;

        if(n1==0)
            return  arr2[l2+k];
        else if(n2==0)
            return  arr1[l1+k];
        else if(k==0)
            return Math.min(arr1[l1], arr2[l2]);
        else{
            int partitionX= (n1*k/(n1+n2));
            int partitionY= k-1 -partitionX;
            int mid1 = Math.min(l1+partitionX ,r1 );
            int mid2 = Math.min(l2+partitionY ,r2 );
            if(arr1[mid1]>arr2[mid2]){
                k -=mid2-l2+1;
                r1= mid1;
                l2 =mid2;
            }else {
                k -=mid1-l1+1;
                r2= mid2;
                l1 =mid1;
            }
            return getKthSmallestElement(k , l1,r1, l2,r2);
        }
    }

    public static void main(String[] args) {
        KthSmallestElementInAnArray element =new KthSmallestElementInAnArray(new int[]{1,2,5,6,9,10},new int[]{3,4,7,8} , 5);
        System.out.println(element.getKthSmallest());
    }

}
