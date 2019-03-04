package com.wellsfargo.data_structure.array;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class NumberOfElementsLessThanOrEqualGivenNumberInGivenSubarrayIncludingUpdate {

    private int arr[];

    final int MAX = 10001;

    private int bit[][];

    private int blk_sz;

    private int n ;

    public NumberOfElementsLessThanOrEqualGivenNumberInGivenSubarrayIncludingUpdate(int[] arr) {
        this.arr = arr;
        this. blk_sz = (int) Math.sqrt(arr.length)+1;// size of block size will be equal to square root of n
        this.bit= new int[blk_sz][MAX];
        this.n=arr.length;
        preprocess();
    }

    private void preprocess() {// Preprocessing the array
        for (int i=0; i<n; i++){
            update(arr[i], i/blk_sz, 1);
        }
    }
    // updating the bit array of a valid block
    private void update(int idx, int blk, int val) {
        for (; idx<MAX; idx += (idx&-idx))
            bit[blk][idx] += val;
    }
    void preprocessUpdate(int i, int v) {
        // updating the bit array at the original and new value of array
        update(arr[i], i/blk_sz, -1);
        update(v, i/blk_sz, 1);
        arr[i] = v;
    }

    // answering the query
    public int query(int l, int r, int k){
        int sum = 0;// traversing the first block in range
        while (l<r && l%blk_sz!=0 && l!=0) {
            if (arr[l] <= k)
                sum++;
            l++;
        }
        // Traversing completely overlapped blocks in range for such blocks bit array of that block  is queried
        while (l + blk_sz <= r) {
            int idx = k;
            for (; idx > 0 ; idx -= idx&-idx)
                sum += bit[l/blk_sz][idx];
            l += blk_sz;
        }
        while (l <= r) {// Traversing the last block
            if (arr[l] <= k)
                sum++;
            l++;
        }
        return sum;
    }

    public static void main(String[] args) {
        NumberOfElementsLessThanOrEqualGivenNumberInGivenSubarrayIncludingUpdate  number =new
                NumberOfElementsLessThanOrEqualGivenNumberInGivenSubarrayIncludingUpdate(new int[]{5, 1, 2, 3, 4,7,6,8});
        System.out.println(number.query(1, 6, 1));
        number.preprocessUpdate(3, 10);
        System.out.println(number.query(3, 3, 4));
        number.preprocessUpdate(2, 1);
        number.preprocessUpdate(0, 2);
        System.out.println(number.query (0, 4, 5));
    }

}
