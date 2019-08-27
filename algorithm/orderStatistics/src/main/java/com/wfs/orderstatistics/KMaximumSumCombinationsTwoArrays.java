package com.wfs.orderstatistics;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KMaximumSumCombinationsTwoArrays {

    private int arr1[];

    private int arr2[];

    private int k;

    private PriorityQueue<Combination> combinations;


    public KMaximumSumCombinationsTwoArrays(int[] arr1, int[] arr2, int k) {
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.k = k;
        this.combinations =new PriorityQueue<>(k );
    }

    public int kthLargestSumCombination(){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        combinations.add(new Combination(arr1[arr1.length-1]+ arr2[arr2.length-1] ,arr1.length-1,arr2.length-1 ));
        Combination combination =null;
        while(k>0){
            combination = combinations.poll();
            combinations.add(new Combination(arr1[combination.num1]+arr2[combination.num2-1] , combination.num1 , combination.num2-1 ));
            combinations.add(new Combination(arr1[combination.num1-1]+arr2[combination.num2] , combination.num1-1 , combination.num2 ));
            k--;
        }
        return combination.sum;
    }


    class Combination implements Comparable<Combination>{
        int sum ;
        int num1;
        int num2;

        public Combination(int sum, int num1, int num2) {
            this.sum = sum;
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public int compareTo(Combination o) {
            return o.sum-this.sum;
        }
    }



}
