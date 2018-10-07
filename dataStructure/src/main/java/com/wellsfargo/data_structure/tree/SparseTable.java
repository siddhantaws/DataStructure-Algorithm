package com.wellsfargo.data_structure.tree;

public class SparseTable<K extends Comparable> {

    private K[] arr;
    private K[][] tempArry ;

    public SparseTable(K[] arr) {
        this.arr = arr;
        int col = ( (int)Math.sqrt(arr.length))+1;
        tempArry =(K[][] ) new Comparable[arr.length][col];
        constructSparsematrix();
    }

    private void constructSparsematrix()    {
        for(int i=0;i<arr.length;i++)
            tempArry[i][0]=arr[i];
        for(int i=1;i<tempArry[0].length;i++)
            for(int j=0;j<tempArry.length-i;j++)
                tempArry[j][i] =tempArry[j][i-1].compareTo(tempArry[j+1][i-1])> 0  ? tempArry[j+1][i-1] : tempArry[j][i-1];
    }


    private K getMinimum(int start, int end){
        int k =(int)Math.floor(Math.sqrt(end-start+1));
        int diff = (end-start+1)-(int)Math.pow(2 , k);
        return tempArry[start][k].compareTo(tempArry[start+diff][k]) > 0 ? tempArry[start+diff][k] :  tempArry[start][k];
    }

    public static void main(String[] args) {
        Integer  arr []={4,6,1,5,7,3};
        SparseTable<Integer> sparseTable =new SparseTable((Integer[])arr);
        System.out.println(sparseTable.getMinimum(0,3));

    }
}
