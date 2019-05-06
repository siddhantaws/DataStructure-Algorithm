package com.wellsfargo.data_structure.array;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class FindSubarrayInFormOfMountainOrNot {
    private int[] arr;

    private int[] leftSubArray;

    private int[] rightSubArray;

    private int N;

    public FindSubarrayInFormOfMountainOrNot(int[] arr) {
        this.arr = arr;
        this.N =arr.length;
        this.leftSubArray=new int[arr.length];
        this.rightSubArray=new int[arr.length];
        preProcess();
    }

    public void preProcess(){
        // initialize first left index as that index only
        leftSubArray[0] = 0;
        int lastIncr = 0;
        for (int i = 1; i < N; i++) {
            // if current value is greater than previous,
            // update last increasing
            if (arr[i] > arr[i - 1])
                lastIncr = i;
            leftSubArray[i] = lastIncr;
        }
        // initialize last right index as that index only
        rightSubArray[N - 1] = N - 1;
        int firstDecr = N - 1;
        for (int i = N - 2; i >= 0; i--) {
            // if current value is greater than next, update first decreasing
            if (arr[i] > arr[i + 1])
                firstDecr = i;
            rightSubArray[i] = firstDecr;
        }
    }

    // method returns true if arr[L..R] is in mountain form
    public boolean isSubarrayMountainForm(int L, int R) {
        // return true only if right at starting range is greater than left at ending range
        return (rightSubArray[L] >= leftSubArray[R]);
    }

    public static void main(String[] args) {
        FindSubarrayInFormOfMountainOrNot subarray =new FindSubarrayInFormOfMountainOrNot(new int[]{2, 3, 2, 4, 4, 6, 3, 2});
        System.out.println(subarray.isSubarrayMountainForm(0,2));
        System.out.println(subarray.isSubarrayMountainForm(1,3));
    }
}
