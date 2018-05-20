package com.wfs.devideConqur;

import java.util.ArrayList;
import java.util.List;

public class MultiplyLargeNumbersRepresentedAsStrings {

    private String num1;

    private String num2;

    public MultiplyLargeNumbersRepresentedAsStrings(String num1, String num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public String multiply(){
        return multiply(num1 ,  num2);
    }

    private String multiply (String s1, String s2 ) {
        char[] num1 = s1.toCharArray();
        char[] num2 = s2.toCharArray();

        int carry=0;
        int product=0;
        int sum=0;

        char[] result = new char[num1.length+num2.length];

        for (int i=0; i < result.length; i++) {
            result[i] = '0';
        }

        int currPostion=0;
        for (int i=num1.length-1; i >=0; i--) {
            currPostion =  result.length-(num1.length-i);
            carry=0;
            for (int j = num2.length-1; j >=0 ; j--) {
                product = (num1[i]-'0') *(num2[j]-'0');
                sum =  carry+ product + ((result[currPostion]- '0')) ;
                result[currPostion] =  (char)(sum%10+'0');
                carry = sum/10;
                currPostion--;
            }

            if (carry>0) {
                result[currPostion] = (char)(carry+'0');
            }
        }

        return String.valueOf(result) ;
    }

    public static void main(String[] args) {
        MultiplyLargeNumbersRepresentedAsStrings multiplyLargeNumbersRepresentedAsStrings=new MultiplyLargeNumbersRepresentedAsStrings("99" ,"12");
        System.out.println(multiplyLargeNumbersRepresentedAsStrings.multiply());
    }
}
