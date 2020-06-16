package com.wfs.devideConqur;

public class KthSmallestElementinTwoSortedArray {
    private int arrOne[];

    private int arrTwo[];

    private int K;

    public KthSmallestElementinTwoSortedArray(int[] arrOne, int[] arrTwo, int k) {
        this.arrOne = arrOne;
        this.arrTwo = arrTwo;
        K = k;
    }

    public int getKthSmallestElement(){
        return getKthSmallestElement(arrOne,0 , arrOne.length-1 ,arrTwo , 0 ,arrTwo.length-1 , K);
    }

    public int getHeadIndex(int[] arr, int start, int end , int value){
        if(arr[start]>value || start >end)
            return -1;
        if(start ==end)
            return start;
        if(end -start==1)
            return arr[start]<=value ? start : end;
        int mid =start+(end-start)/2;
        if(arr[mid]==value)
            return mid;
        if(mid<end && arr[mid]<=value && value < arr[end])
            return mid;
         if(mid>0 && arr[mid-1]<=value && value < arr[mid])
             return mid-1;
         if (value<arr[mid] )
             return getHeadIndex(arr,start,mid-1,value);
         return getHeadIndex(arr,mid+1,end,value);
    }

    private int getKthSmallestElement(int[] arrOne, int start1, int end1 , int[] arrTwo, int start2, int end2, int k){
        if(start1==-1 || start2==-1)
            return start1==-1 ? arrTwo[start2+k-1] :arrOne[start2+k-1];
        if(start1==end1)
            return k==1 ? Math.min(arrOne[start1] , arrTwo[start2]) : arrTwo[start2+k-1] ;
        if(start2==end2)
            return k==1 ? Math.min(arrOne[start1] , arrTwo[start2]) : arrOne[start1+k-1] ;
        int mid1= start1 + (end1-start1)/2;int mid2= start2 + (end2-start2)/2;
        if(arrOne[mid1] > arrTwo[mid2]){
            int headIndex =getHeadIndex(arrOne ,start1,mid1,arrTwo[mid2] );
            int totalKthElement = headIndex==-1 ? mid2-start2+1 : mid2-start2+1+headIndex-start1+1;
            if(totalKthElement==k)
                return arrTwo[mid2];
            else if(totalKthElement>k)
                return getKthSmallestElement(arrOne ,headIndex==-1 ?  -1 : start1 ,headIndex ,arrTwo ,start2,mid2 ,  k  );
            else
                return getKthSmallestElement(arrOne ,headIndex==-1 ?  -1 : headIndex+1 ,end1 ,arrTwo ,mid2+1,end2 ,  k-totalKthElement  );
        }else{
            int headIndex =getHeadIndex(arrTwo ,start2,mid1,arrOne[mid1] );
            int totalKthElement = headIndex==-1 ? mid1-start1+1 : mid1-start1+1+headIndex-start2+1;
            if(totalKthElement==k)
                return arrOne[mid1];
            else if(totalKthElement>k)
                return getKthSmallestElement(arrOne , start1 ,mid1 ,arrTwo ,headIndex==-1 ? -1 : start2 ,headIndex ,  k  );
            else
                return getKthSmallestElement(arrOne ,mid1+1 ,end1 ,arrTwo ,headIndex==-1 ? -1 :  start2+headIndex-1,end2 ,  k-totalKthElement  );
        }
    }

    public static void main(String[] args) {
        KthSmallestElementinTwoSortedArray sortedArray =new KthSmallestElementinTwoSortedArray(new int[]{10,20,40,50,60,80},new int[]{5,15,35,55,65,90} , 3);
        System.out.println(sortedArray.getKthSmallestElement());
    }
}
