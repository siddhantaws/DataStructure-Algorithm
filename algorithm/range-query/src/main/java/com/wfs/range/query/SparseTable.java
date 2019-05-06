package com.wfs.range.query;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class SparseTable {

    private int arr[];

    private int[][]arr1;

    public SparseTable(int[] arr) {
        this.arr = arr;
        this.arr1 =new int[arr.length][(int)Math.log(arr.length)+1];
    }

    private void constructTable(){
        for(int i=0;i<arr1[0].length;i++)
            for(int j=0;i<arr1.length;j++){
                if(i==0)
                    arr1[i][j]=i;
                else{
                        int x = arr1[j][i-1];
                        int y = arr1[j+(int)Math.pow(2, i-1)][i-1];
                        if(arr[x] > arr[y])
                            arr1[i][j]=y;
                        else
                            arr1[i][j]=x;
                }
            }
    }

    public void processQuery(int l, int r){
        int x =(int)Math.log(r -l+1);
        int k  = arr1[l][x];
        int diff = r - (l+(int)Math.pow(2,k));
        int y = arr1[l+diff-1][(int)Math.log(r-l-diff)];
        System.out.println("Minimum "+Math.min(arr[k],arr[y]));
    }
}
