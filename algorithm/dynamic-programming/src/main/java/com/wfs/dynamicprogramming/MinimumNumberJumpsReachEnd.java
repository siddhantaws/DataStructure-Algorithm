package com.wfs.dynamicprogramming;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MinimumNumberJumpsReachEnd {

    private int arr[];

    private int tempArray[];

    private int backTraceArray[];

    public MinimumNumberJumpsReachEnd(int[] arr) {
        this.arr = arr;
        this.tempArray = new int[arr.length];
        this.backTraceArray = new int[arr.length];
    }

    public int getMinimumNumberOfPath(){
        tempArray[0]=1;backTraceArray[0]=0;
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++)
            {
                if(arr[j]+j<i)
                    continue;

                if(tempArray[i]==0 ||  tempArray[i]> tempArray[j]+1){
                    tempArray[i] = tempArray[j]+1 ;
                    backTraceArray[i] = j;
                }
            }
        }
    for(int i=0;i<backTraceArray.length;i++)
        System.out.print(backTraceArray[i]+"\t");
      return  tempArray[tempArray.length-1];
    }

    public int minJumps()
    {
        if (arr.length <= 1)
            return 0;

        // Return -1 if not possible to jump
        if (arr[0] == 0)
            return -1;

        // initialization
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;


        // Start traversing array
        for (int i = 1; i < arr.length; i++)
        {
            // Check if we have reached the end of the array
            if (i == arr.length - 1)
                return jump;

            // updating maxReach
            maxReach = Math.max(maxReach, i+arr[i]);

            // we use a step to get to the current index
            step--;

            // If no further steps left
            if (step == 0)
            {
                //  we must have used a jump
                jump++;

                //Check if the current index/position  or lesser index
                // is the maximum reach point from the previous indexes
                if(i>=maxReach)
                    return -1;

                // re-initialize the steps to the amount
                // of steps to reach maxReach from position i.
                step = maxReach - i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int array [] ={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        MinimumNumberJumpsReachEnd jumpsReachEnd =new MinimumNumberJumpsReachEnd(array);
        System.out.println(jumpsReachEnd.minJumps());
    }

}
