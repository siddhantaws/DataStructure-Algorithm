package com.wellsfargo.data_structure.array;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class QueriesLeftRightCircularShiftOnArray {
    private int arr[];

    private int n;

    private int toRotate=0;

    int preSum[];

    public QueriesLeftRightCircularShiftOnArray(int[] arr) {
        this.arr = arr;
        this.n = arr.length;
        this.toRotate = toRotate;
        this.preSum =new int[n+1];
        // Finding Prefix sum
        for (int i = 1; i <= n; i++)
            preSum[i] = preSum[i - 1] + arr[i - 1];
    }

    void querytype1(int times) {// Function to solve query of type 1 x
        // Decreasing the absolute rotation
        toRotate = (toRotate - times) % n;
    }

    void querytype2(int times) {// Function to solve query of type 1 x
        // Decreasing the absolute rotation
        toRotate = (toRotate + times) % n;
    }

    void querytype3(int l, int r){// Function to solve queries of type 3 l r.
        // Finding absolute l and r.
        l = (l + toRotate + n) % n;
        r = (r + toRotate + n) % n;

        if (l <= r)// if l is before r.
            System.out.println(preSum[r + 1] - preSum[l]);
        else// If r is before l.
            System.out.println(preSum[n] + preSum[r + 1] - preSum[l]);
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5 ,6,7};
        QueriesLeftRightCircularShiftOnArray onArray =new QueriesLeftRightCircularShiftOnArray(a);
        onArray.querytype1(4);
        onArray.querytype3(0,4);
    }
}
