package com.wellsfargo.data_structure.array;

public class MergeSortTree {

    private int tempArr[];
    private int arr[];

    public MergeSortTree(int[] arr) {
        this.arr = arr;
        this.tempArr =new int[2*arr.length-1];
    }


    void construct(int n, int ll, int rl) {
        if (ll == rl) {
            tempArr[n]=arr[ll];
            return;
        }
        construct(2*n+1, ll, (ll+rl)/2);
        construct(2*n+2, (ll+rl)/2+1, rl);
      /*  st[n].resize(rl-ll+1);
        merge(n, 2*n+1, 2*n+2);*/
    }

}
