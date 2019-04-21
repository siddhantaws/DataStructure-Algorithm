package com.wellsfargo.algo.bit_algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class CountPairsArrayLeastOneDigitCommon {

    private int arr[];
    private Map<Integer , Integer > freq =new HashMap<>();
    public CountPairsArrayLeastOneDigitCommon(int[] arr) {
        this.arr = arr;
    }

    private void calculateMaskFrequency(){
        for(int i=0;i<arr.length;i++){

            int num =arr[i];
            //creating an empty mask
            int mask=0;
            //Extracting every digit of Number and updating corresponding bit in the mask
            while(num>0){
                mask = mask | (1<< (num%10));
                num /=10;
            }
            if(freq.containsKey(mask))
                freq.put(mask ,freq.get(mask)+1 );
            freq.put(mask ,1 );
        }
    }
    //Function return the number of valid pairs
    public int countPairs(){
        calculateMaskFrequency();
        long numberOfPairs =0;

    }
}
