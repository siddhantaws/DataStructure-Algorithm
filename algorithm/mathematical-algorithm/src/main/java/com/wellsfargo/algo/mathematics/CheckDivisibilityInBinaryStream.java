package com.wellsfargo.algo.mathematics;

import java.io.BufferedReader;
import java.util.Scanner;


public class CheckDivisibilityInBinaryStream {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n =5;
        int remainder =0 , num =0;
        while (true)
        {
            System.out.println("Enter 1 or 0");
            int incomingBit =s.nextInt();
            if (incomingBit == 1)
            {
                num = num* 2 + 1;
                remainder = (remainder * 2 + 1) % n;
            }
            else if (incomingBit == 0)
            {
                num = num* 2 ;
                remainder = (remainder * 2) % n;
            }
            // If remainder is 0.
            if (remainder % n == 0)
                System.out.println("Number :"+num +" divisible by :"+n);
            else
                System.out.println("Number :"+num +" not divisible by :"+n);
        }
    }
}
