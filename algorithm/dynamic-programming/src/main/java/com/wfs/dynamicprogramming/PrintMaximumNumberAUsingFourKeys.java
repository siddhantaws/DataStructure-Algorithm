package com.wfs.dynamicprogramming;

/**
 * Created by Suryasnata on 7/6/2017.
 */
public class PrintMaximumNumberAUsingFourKeys {
    private int numberOfKeys;
    private int arr[];
    public PrintMaximumNumberAUsingFourKeys(int numberOfKeys) {
        this.numberOfKeys = numberOfKeys;
        this.arr=new int[numberOfKeys+1];
    }

    public int getNumberOfKeys()
    {
        return getNumberOfKeys(numberOfKeys);
    }

    private int getNumberOfKeys(int n)
    {
        if(n<6)
            return n;

        int max=0;
        for(int i=1;i<=6;i++)
            arr[i]=i;

        for(int i=7;i<=n;i++)
        {
            int b=2;
            for(int j=i-3;j>=1;j--)
                arr[i] = Math.max( arr[i] , b ++* arr[j]);
        }
        return arr[n];
    }

    public static void main(String[] args) {
        PrintMaximumNumberAUsingFourKeys  printMaximumNumberAUsingFourKeys=new PrintMaximumNumberAUsingFourKeys(11);
        printMaximumNumberAUsingFourKeys.getNumberOfKeys();
    }
}
