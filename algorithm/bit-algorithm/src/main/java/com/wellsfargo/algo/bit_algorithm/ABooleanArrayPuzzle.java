package com.wellsfargo.algo.bit_algorithm;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class ABooleanArrayPuzzle {
    private int arr[];

    public ABooleanArrayPuzzle(int[] arr) {
        this.arr = arr;
    }

    public void change(){
        arr[0] =arr[arr[1]];
        arr[1]=arr[0];
    }
}
