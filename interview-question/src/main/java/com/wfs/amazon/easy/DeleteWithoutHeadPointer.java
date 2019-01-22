package com.wfs.amazon.easy;

import java.util.Scanner;

/**
 * @author Siddhanta Kumar Pattnaik
 */

public class DeleteWithoutHeadPointer {
    public static void main(String[] args) {
        /*String s ="100100000111111101010010010011010101110110";
        int cpount =0;
        for(char ch :s.toCharArray()){
            if(ch=='1')
                cpount++;
        }
        System.out.println(cpount);*/
        System.out.println(getBinomialCooficient(22,2));
    }
    private static int getBinomialCooficient(int m ,int k){
        int arr[]=new int[m+1];
            for(int i=0;i<=m;i++){
                for(int j=i;j>=0;j--) {
                    if(j==0 || j==i)
                        arr[j]=1;
                    else
                        arr[j] =  arr[j] +arr[j-1]  ;
                }
            }
        return arr[k-1];
    }
}