package com.wellsfargo.data_structure.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class NumberOfElementsLessThanOrEqualGivenNumberInSubarray {
    private Query queries[];
    private ArrayElement arr[];
    private int[] bit;
    private int n;

    public NumberOfElementsLessThanOrEqualGivenNumberInSubarray(Query[] queries, ArrayElement[] arr) {
        this.queries = queries;
        this.arr = arr;
        this.bit =new int[arr.length+1];
        this.n =arr.length;
    }

    static class Query {
        int l, r, x, idx;

        public Query(int l, int r, int x, int idx) {
            this.l = l;
            this.r = r;
            this.x = x;
            this.idx = idx;
        }
    }
    // structure to hold array
    static class ArrayElement {
        int val, idx;

        public ArrayElement(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    private Comparator QueryComparator(){
        return new Comparator<Query>() {
            @Override
            public int compare(Query q1, Query q2) {
                return q1.x - q2.x;
            }
        };
    }
    private Comparator ArrayComparator(){
        return new Comparator<ArrayElement>(){
            @Override
            public int compare(ArrayElement o1, ArrayElement o2) {
                return o1.val - o2.val;
            }
        };
    }
    // updating the bit array
    void update(int idx, int val) {
        for (; idx<=n; idx +=idx&-idx)
            bit[idx] += val;
    }
    // querying the bit array
    int query( int idx) {
        int sum = 0;
        for (; idx > 0; idx -= idx&-idx)
            sum += bit[idx];
        return sum;
    }

    public void answerQuery(){
        // current index of array
        int curr = 0;
        // array to hold answer of each Query
        int ans[] =new int[queries.length];
        // looping through each Query
        Arrays.sort(queries ,QueryComparator() );
        Arrays.sort(arr ,ArrayComparator() );
        for (int i=0; i<queries.length; i++) {
            // traversing the array values till it is less than equal to Query number
            while ( curr<n && arr[curr].val <= queries[i].x ) {
                // updating the bit array for the array index
                update( arr[curr].idx+1, 1);
                curr++;
            }
            // Answer for each Query will be number of  values less than equal to x upto r minus
            // number of values less than equal to x  upto l-1
            ans[queries[i].idx] = query(queries[i].r+1) -
                    query( queries[i].l);
        }
        // printing answer for each Query
        for (int i=0 ; i<queries.length; i++)
            System.out.println("Query "+i+" "+ ans[i]);
    }

    public static void main(String[] args) {
        // size of array
        // initialising array value and index
        ArrayElement arr[] =new ArrayElement[8];
        arr[0] = new ArrayElement(1,0);
        arr[1] = new ArrayElement(7,1);
        arr[2] = new ArrayElement(8,2);
        arr[3] = new ArrayElement(5,3);
        arr[4] = new ArrayElement(6,4);
        arr[5] = new ArrayElement(2,5);
        arr[6] = new ArrayElement(15,6);
        arr[7] = new ArrayElement(4,7);
        Query queries[] =new Query[3];
        queries[0] = new Query(0,4,5,0);
        queries[1] = new Query(0,2,7,1);
        queries[2] = new Query(2,6,8,2);

        NumberOfElementsLessThanOrEqualGivenNumberInSubarray inSubarray =new NumberOfElementsLessThanOrEqualGivenNumberInSubarray(queries,arr);
        inSubarray.answerQuery();
    }

}
