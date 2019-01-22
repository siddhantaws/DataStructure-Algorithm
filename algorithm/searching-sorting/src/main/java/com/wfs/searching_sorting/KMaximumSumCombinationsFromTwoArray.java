package com.wfs.searching_sorting;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class KMaximumSumCombinationsFromTwoArray {

    private int arr1[];

    private int arr2[];

    private int K ;

    public KMaximumSumCombinationsFromTwoArray(int[] arr1, int[] arr2, int K ) {
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.K =K;
    }

    public void getKCombination() {
        Arrays.sort(arr1);Arrays.sort(arr2);
        int N = arr1.length;
        PriorityQueue<Pair> pairs = new PriorityQueue<>();
        Set<Pair> pairSet = new HashSet<>();
        pairs.add(new Pair(N - 1, N - 1, arr1[N - 1] + arr2[N - 1]));
        pairSet.add(new Pair(N - 1, N - 1));
        // iterate upto K
        for (int count = 0; count < K; count++) {
            // tuple format (sum, (i, j)).
            Pair temp = pairs.poll();
            System.out.println(arr1[temp.x] + " "+arr2[temp.y] + " "+temp.sum);
            Pair one = new Pair(temp .x-1 ,temp.y ,arr1[temp .x-1]+arr2[temp .y]);
            if(!pairSet.contains(one)){
                pairs.add(one);
                pairSet.add(one);
            }
            Pair two = new Pair(temp .x ,temp.y-1 ,arr1[temp .x]+arr2[temp .y-1]);
            if(!pairSet.contains(two)){
                pairs.add(two);
                pairSet.add(two);
            }
        }
    }
    static class Pair implements Comparable<Pair>{
        int x ;
        int y ;

        int sum ;
        public Pair(int x, int y ){
            this.x = x;
            this.y = y;
        }
        public Pair(int x, int y , int sum) {
            this.x = x;
            this.y = y;
            this.sum =sum;
        }

        @Override
        public String toString() {
            return "x-> "+x+" y-> "+y +" sum->"+sum;
        }

        @Override
        public int compareTo(Pair o) {
            return o.sum-this.sum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x &&
                    y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        int arr1[]={ 1, 4, 2, 3 };int arr2[]={ 2, 5, 1, 6 };
        KMaximumSumCombinationsFromTwoArray combinations =new KMaximumSumCombinationsFromTwoArray(arr1,arr2, 4);
        combinations.getKCombination();
    }
}
