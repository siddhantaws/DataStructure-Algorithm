/*
package com.wellsfargo.data_structure.matrix;

*/
/**
 * @author Siddhanta Kumar Pattnaik
 *//*

public class FindCommonElementAllRowsGivenRowWiseSortedMatrix {
    private int arr[][];

    public FindCommonElementAllRowsGivenRowWiseSortedMatrix(int[][] arr) {
        this.arr = arr;
    }

    public  int findCommonElement(){
        int tempArr[] = new int[arr.length];
        while(true){
            int minIndex = -1,minValue=Integer.MAX_VALUE;
            for(int i=0;i<tempArr.length;i++){
                tempArr[i]=arr[i][tempArr.length];
                if(minValue<tempArr[i]){
                    minValue =tempArr[i];
                    minIndex = i;
                }
            }
            //Find Ceiling Index
            int ceilingIndex=-1;
            for(int i=0;i<tempArr.length && i!=minIndex ;i++){
                ceilingIndex =
            }

        }
    }

    private int findCeilingIndex(){

    }

}
*/
