package com.wellsfargo.algo.bit_algorithm;

/**
 * Created by Suryasnata on 4/26/2017.
 * Given an array where every element occurs three times, except one element which occurs only once.
 * Find the element that occurs once. Expected time complexity is O(n) and O(1) extra space.Examples:
 * Input: arr[] = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3}
    Output: 2
 */
public class ElementThatAppearsOnce
{
    private static int arr[]={12, 1, 15, 3, 12, 1, 1, 2, 3, 3};

    public static void main(String[] args) {
        int uniqueNumber =0 ;
        for(int number :arr)
            uniqueNumber ^= number ;
        System.out.println("Unique Number is "+uniqueNumber);
    }
}
