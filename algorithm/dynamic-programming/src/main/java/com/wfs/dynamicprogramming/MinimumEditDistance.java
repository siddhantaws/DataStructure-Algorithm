package com.wfs.dynamicprogramming;

/**
 * Created by Suryasnata on 5/16/2017.
 * Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 * Insert Remove Replace
 * Input:   str1 = geek, str2 = gesek
 * Output:  1   We can convert str1 into str2 by inserting a 's'.
 * Input:   str1 = "cat", str2 = "cut"
 * Output:  1   We can convert str1 into str2 by replacing 'a' with 'u'.
 * Input:   str1 = "sunday", str2 = "saturday"
 * Output:  3   Last three and first characters are same.  We basically need to convert "un" to "atur".  This can be done using below three operations.
 * Replace 'n' with 'r', insert t, insert a
 */
public class MinimumEditDistance
{
    private String sourceString;

    private String destiString;

    private int tempArr[][];

    public MinimumEditDistance(String sourceString , String destiString)
    {
        this.sourceString = sourceString;
        this.destiString = destiString;
        tempArr =new int[destiString.length()+1][sourceString.length()+1];
    }

    public void getMinEditDistance()
    {
        for(int i=0;i<tempArr.length;i++)
            tempArr[i][0] =i;
        for(int i=0;i<tempArr[0].length;i++)
            tempArr[0][i] =i;

        for(int i=1;i<tempArr.length;i++)
            for(int j=1;j<tempArr[i].length;j++)
                if(destiString.charAt(i-1) == sourceString.charAt(j-1))
                    tempArr[i][j] = tempArr[i-1][j-1];
                else
                    tempArr[i][j] = 1 + min(tempArr[i][j-1], // Insert
                            tempArr[i-1][j], // Remove
                            tempArr[i-1][j-1]); // Replace
        System.out.println(tempArr[tempArr.length-1][tempArr[0].length-1]);
    }

    int min(int x,int y,int z)
    {
        if (x <= y && x <= z) return x;
        if (y <= x && y <= z) return y;
        else return z;
    }


    public static void main(String[] args)
    {
        MinimumEditDistance  minimumEditDistance =new MinimumEditDistance("geek" , "gesek");
        minimumEditDistance.getMinEditDistance();
    }
}