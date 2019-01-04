package com.wellsfargo.data_structure.array;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class SquareRootDecomposition {
    private int arr[];
    private int blockSize;                      // block size
    int blockArray[];          // decomposed array

    public SquareRootDecomposition(int[] arr) {
        this.arr = arr;
        this.blockSize =(int)Math.sqrt(arr.length);
        this.blockArray =new int[blockSize];
        preProcess();
    }

    private void preProcess(){
        // initiating block pointer
        int blockIndex = -1;
        // building the decomposed array
        for (int i=0; i<arr.length; i++) {
            if (i%blockSize == 0)
                blockIndex++;// entering next block incementing block pointer
            blockArray[blockIndex] += arr[i];
        }
    }
    public void update(int idx, int val)  {// Time Complexity : O(1)
        int blockNumber = idx / blockSize;
        blockArray[blockNumber] += val - arr[idx];
        arr[idx] = val;
    }

    public int query(int l ,int r){
        int sum = 0;
        while(l<r && l%blockSize!=0 && l!=0){ // for first block which is partiallyOverlap
            sum +=arr[l++];
        }
        //second blocks which is completely overlap
        while(l+blockSize<r){
            sum +=blockArray[l/blockSize];
            l+=blockSize;
        }
        while (l<=r) {
            // traversing last block in range
            sum += arr[l];
            l++;
        }
        return sum;
    }
}
