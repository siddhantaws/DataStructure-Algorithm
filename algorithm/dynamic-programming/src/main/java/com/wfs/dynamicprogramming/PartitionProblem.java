package com.wfs.dynamicprogramming;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class PartitionProblem {

    private int arr[];

    private int sum = 0;

    private boolean [][] part;

    private int n;

    public PartitionProblem(int[] arr) {
        this.arr = arr;
        for( int i :arr)
            this.sum+=i;
        if((this.sum%2)!=0)
            throw new UnsupportedOperationException();
        this.n = arr.length;
        this.part = new boolean[this.sum/2+1][n+1];
    }

    public boolean findPartition(){
        for (int i = 0; i <= n; i++)
            part[0][i] = true;

        // initialize leftmost column, except part[0][0], as 0
        for (int i = 1; i <= sum/2; i++)
            part[i][0] = false;
        // Fill the partition table in botton up manner
        for (int i = 1; i <= sum/2; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                part[i][j] = part[i][j-1];
                if (i >= arr[j-1])
                    part[i][j] = part[i][j] ||
                            part[i - arr[j-1]][j-1];
            }
        }
        for (int i=0;i<part.length;i++){
            System.out.println( );
            for (int j=0;j<part[i].length;j++){
                System.out.print(part[i][j]+"\t");
            }
        }

        return part[sum/2][n];
    }

    public static void main(String[] args) {
        PartitionProblem problem =new PartitionProblem(new int[]{3, 1, 1, 2, 2,1});
        problem.findPartition();
    }
}
