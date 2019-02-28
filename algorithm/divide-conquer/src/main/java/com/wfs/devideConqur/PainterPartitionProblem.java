package com.wfs.devideConqur;

public class PainterPartitionProblem {

    private int arr[];
    private int k ;

    public PainterPartitionProblem(int[] arr , int k ) {
        this.arr = arr;
        this.k=k;
    }

    private int getMax()
    {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }
    private int getSum()
    {
        int total = 0;
        for (int i = 0; i < arr.length; i++)
            total += arr[i];
        return total;
    }

    // find minimum required painters for given maxlen
    // which is the maximum length a painter can paint
    int numberOfPainters(int maxLen)
    {
        int total = 0, numPainters = 1;

        for (int i = 0; i < arr.length; i++) {
            total += arr[i];

            if (total > maxLen) {

                // for next count
                total = arr[i];
                numPainters++;
            }
        }

        return numPainters;
    }

    public int partition()
    {
        int lo = getMax();
        int hi = getSum();

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int requiredPainters = numberOfPainters(mid);

            // find better optimum in lower half here mid is included because we may not get anything better
            if (requiredPainters <= k)
                hi = mid;
            else// find better optimum in upper half here mid is excluded because it gives required Painters > k, which is invalid
                lo = mid + 1;
        }
        // required
        return lo;
    }

    public static void main(String[] args) {
        PainterPartitionProblem problem =new PainterPartitionProblem(new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9 } , 3);
        System.out.println(problem.partition());
    }
}
