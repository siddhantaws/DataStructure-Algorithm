package com.wfs.searching_sorting;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MajorityElementMooreVotingAlgorithm {
    private int arr[];

    public MajorityElementMooreVotingAlgorithm(int[] arr) {
        this.arr = arr;
    }

    public int getMajorityElement(){
        int count =1;
        int majorityElement =arr[0];
        for(int i=1;i<arr.length-1;i++){
            if(arr[i] ==majorityElement)
                count++;
            else
                count --;
            if(count==0){
                count=1;
                majorityElement= arr[i];
            }
        }
        return checkForMajority(majorityElement) ? majorityElement : -1;
    }
    private boolean checkForMajority(int num){
        int count =0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==num)
                count++;
        }
        return count >=(arr.length/2);
    }
}
