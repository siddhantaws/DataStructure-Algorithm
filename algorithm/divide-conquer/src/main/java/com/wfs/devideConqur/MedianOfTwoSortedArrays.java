package com.wfs.devideConqur;

/**
 * Created by Suryasnata on 5/24/2017.
 * Question: There are 2 sorted arrays A and B of size n each.
 * Write an algorithm to find the median of the array obtained after merging the above 2 arrays(i.e. array of length 2n). The complexity should be O(log(n))
 *
 */
public class MedianOfTwoSortedArrays {
    private int arrOne[];
    private int arrTwo[];

    public MedianOfTwoSortedArrays(int[] arrOne, int[] arrTwo) {
        this.arrOne = arrOne;
        this.arrTwo = arrTwo;
    }

    public int getMedian()
    {
        return  getMedian(arrOne  ,0,arrOne.length-1 ,arrTwo, 0 ,arrTwo.length-1);
    }

    private int getMedian(int[] arrOne, int i, int i1, int[] arrTwo, int i2 , int i3)
    {
        if(Math.abs(i-i1)== 1 && Math.abs(i2 -i3)==1)
        {
            return ( Math.max(arrOne[i] , arrTwo[i2]) + Math.min(arrOne[i1] , arrTwo[i3]) )/2;
        }
        int median1 =getMedain(arrOne , i , i1);
        int median2 =getMedain(arrTwo , i2 , i3);
        if(median1> median2)
             return   getMedian(arrOne , i , i+((i1-i)/2) , arrTwo , i2+((i3-i2)/2) ,  i3   );
        else if(median1< median2)
            return    getMedian(arrOne , i+ ((i1-i)/2) , i1 , arrTwo , i2 ,  i2+((i3-i2)/2)   );
        else
            return median1 ;
    }

    private int getMedain(int[] arrOne, int i, int i1)
    {
        int med= (i1-i)/2;
        if(med%2==0)
            return (arrOne[med+i] +arrOne[med+i+1])/2 ;
        else
            return arrOne[med+i];
    }

    public static void main(String[] args) {
        int arrOne[]={1, 12, 15, 26, 38} ; int arrTwo[]={2, 13, 17, 30, 45} ;
        MedianOfTwoSortedArrays medianOfTwoSortedArrays=new MedianOfTwoSortedArrays( arrOne ,arrTwo);
        System.out.printf("getMedian: "+medianOfTwoSortedArrays.getMedian());

    }

}
