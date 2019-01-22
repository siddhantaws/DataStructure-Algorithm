package com.wellsfargo.data_structure.array;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MaximumSumNoTwoElementsAreAdjacent {
    private int arr[];



    public int getTotalSum(){
        int inc = arr[0] ,exc =0;

        for(int i=1;i<arr.length-1;i++){
            int exc_New = Math.max(exc ,inc);
            inc = Math.max(exc  , exc+arr[i]);
            exc = exc_New;
        }
        return Math.max(inc,exc);
    }
}
