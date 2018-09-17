package com.wellsfargo.data_structure.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MOsAlgorithm {

    private int arr[];

    private List<Query> queries;

    public MOsAlgorithm(int arr[], List<Query> queries) {
        this.arr = arr;
        this.queries = queries;
    }

    public void queryResult() {
        Collections.sort(queries);
        int currL = 0, currR = 0;
        int currSum = 0;

        // Traverse through all queries
        for (int i = 0; i < queries.size(); i++) {
            // L and R values of current range
            int L = queries.get(i).L, R = queries.get(i).R;

            // Remove extra elements of previous range. For
            // example if previous range is [0, 3] and current
            // range is [2, 5], then a[0] and a[1] are subtracted
            while (currL < L) {
                currSum -= arr[currL];
                currL++;
            }

            // Add Elements of current Range
            while (currL > L) {
                currSum += arr[currL - 1];
                currL--;
            }
            while (currR <= R) {
                currSum += arr[currR];
                currR++;
            }

            // Remove elements of previous range.  For example
            // when previous range is [0, 10] and current range
            // is [3, 8], then a[9] and a[10] are subtracted
            while (currR > R + 1) {
                currSum -= arr[currR - 1];
                currR--;
            }
            System.out.println("Sum of [" + L + " ," + R + "] is " + currSum);
        }
    }


    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 1, 3, 4, 5, 2, 8};
        int block = (int) Math.sqrt(arr.length);
        List<Query> queries = new ArrayList<>();
        queries.add(new Query(1, 4, block));
        queries.add(new Query(5, 8, block));
        //queries.add(new Query(2, 4, block));
        MOsAlgorithm algorithm = new MOsAlgorithm(arr, queries);
        algorithm.queryResult();
    }

}

class Query implements Comparable<Query> {

    public int L;
    public int R;
    private int block;


    public Query(int l, int r, int block) {
        L = l;
        R = r;
        this.block = block;
    }

    @Override
    public String toString() {
        return "L->"+L+",R->"+R;
    }

    @Override
    public int compareTo(Query o) {
        if (o.L / block != this.L / block)
            return o.L / block - this.L / block;
        return o.R / block - this.R / block;
    }

}
