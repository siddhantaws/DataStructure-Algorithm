/*
package com.wellsfargo.data_structure.matrix;

import java.util.HashMap;
import java.util.PriorityQueue;

*/
/**
 * @author Siddhanta Kumar Pattnaik
 *//*

public class MedianOfMatrix {

    private final int[][]matrix;
    PriorityQueue<Element> elements =new PriorityQueue<>();
    HashMap<Integer ,Element> hashMap =new HashMap<>();
    private int K ;
    public MedianOfMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.K= matrix.length*matrix[0].length/2;
        populateInHeap();
    }

    public void populateInHeap(){
        for(int i=0;i<matrix.length;i++){
            Element element =new Element(i, 0 ,matrix[0].length-1, (0+ matrix[0].length-1)/2);
            elements.add(element);
            hashMap.put(i,element);
        }
    }

    public int getMedian(){
        while(true){
            Element pop= elements.poll();

        }
    }

    public int countOfCeiling(int minRowIndex , int index ){
        int count =0;
         for(int i=0;i<matrix.length && i!=minRowIndex;i++)
             count += FindCeilingCount(i,);
    }

    public int ceilingIndex(int row ,int number){
        Element element = hashMap.get(row);
        int low =element.low , high =element.high;
        while(low>high){
            int mid = low+(high-low)/2;
            if(matrix[row][mid] == number)
                return low;
            else if(matrix[row][mid] > number)
                high =mid-1;
            else
                low = mid+1;
        }
        return low - element.low +1;
    }


    class Element implements Comparable<Element>{
        int rowIndex , low , high , mid;
        public Element(int rowIndex, int low, int high, int mid) {
            this.rowIndex = rowIndex;
            this.low = low;
            this.high = high;
            this.mid = mid;
        }
        @Override
        public int compareTo(Element o) {
            return matrix[this.rowIndex][this.mid]- matrix[o.rowIndex][o.mid];
        }
    }

}
*/
