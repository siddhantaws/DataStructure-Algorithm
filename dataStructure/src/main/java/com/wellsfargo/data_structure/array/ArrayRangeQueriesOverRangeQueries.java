package com.wellsfargo.data_structure.array;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class ArrayRangeQueriesOverRangeQueries {
    private int N;
    private int M;
    private int[][]command;
    private int[] arr;
    private int blockSize;
    private int []block;
    private int[] record ;

    public ArrayRangeQueriesOverRangeQueries(int n, int[][] command) {
        N = n;
        this.command = command;
        this.arr=new int[N];
        this.blockSize =(int)Math.sqrt(arr.length);
        this.M= command.length;
        this.block= new int[100000];
        this.record=new int[M];
    }

    // For prefix sum array
    private void update(int arr[], int l) {
        arr[l] += arr[l - 1];
    }

    public void processQuery(){
        for (int i = M - 1; i >= 0; i--) {

            if (command[i][0] == 2) {// If query is of type 2 then function call to record_func
                int x = i / (blockSize);
                record_func( command[i][1] - 1, command[i][2] - 1, (block[x] + record[i] + 1));
            }   else {// If query is of type 1 then simply add 1 to the record array
                record[i]++;
            }
        }
        // Merging the value of the block in the record array
        for (int i = 0; i < M; i++) {
            int check = (i / blockSize);
            record[i] += block[check];
        }
        for (int i = 0; i < M; i++) {
            // If query is of type 1 then the array elements are over-written by the record array
            if (command[i][0] == 1) {
                arr[command[i][1] - 1] += record[i];
                if ((command[i][2] - 1) < N - 1) {
                    arr[(command[i][2])] -= record[i];
                }
            }
        }
        // The prefix sum of the array
        for (int i = 1; i < N; i++) {
            update(arr, i);
        }
        print();
    }

    //Function to print the resultant array
    private void print() {
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private void record_func(int l, int r, int value) {
        while (l < r && l % blockSize != 0 && l != 0) {// traversing first block in range
            record[l] += value;
            l++;
        }
        while (l + blockSize <= r + 1) {// traversing completely overlapped blocks in range
            block[l / blockSize] += value;
            l += blockSize;
        }
        while (l <= r) {// traversing last block in range
            record[l] += value;
            l++;
        }
    }

    public static void main(String[] args) {
        int query[][] = { { 1, 1, 2 },
                          { 1, 4, 5 },
                          { 2, 1, 2 },
                          { 2, 1, 3 },
                          { 2, 3, 4 } };
        ArrayRangeQueriesOverRangeQueries  rangeQueries =new ArrayRangeQueriesOverRangeQueries(5,query);
        rangeQueries.processQuery();
    }

}
