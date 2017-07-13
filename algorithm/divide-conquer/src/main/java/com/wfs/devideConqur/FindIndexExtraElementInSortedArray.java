package com.wfs.devideConqur;

/**
 * Created by Suryasnata on 6/19/2017.
 * Given two sorted arrays. There is only 1 difference between the arrays. First array has one element extra added in between. Find the index of the extra element.
 * Input : {2, 4, 6, 8, 9, 10, 12}; {2, 4, 6, 8, 10, 12};Output : 4 The first array has an extra element 9.The extra element is present at index 4.
 */
public class FindIndexExtraElementInSortedArray {
    private int[] firstArray;
    private int[] secondArray;

    public FindIndexExtraElementInSortedArray(int[] firstArray ,int[] secondArray )
    {
        this.firstArray = firstArray;
        this.secondArray = secondArray;
    }

    public int getIndex()
    {
        int left = 0, right =firstArray.length-1, index=0;
        while(left<=right)
        {
            int mid =(left+right)/2;

            if(firstArray[mid]==secondArray[mid])
                left =mid +1;
            else
            {
                right =mid-1;
                index =mid;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        FindIndexExtraElementInSortedArray findIndexExtraElementInSortedArray=new FindIndexExtraElementInSortedArray(new int[]{3, 5, 7, 9, 11, 13} , new int[]{3, 5, 7, 11, 13});
        System.out.println(findIndexExtraElementInSortedArray.getIndex());
    }
}
