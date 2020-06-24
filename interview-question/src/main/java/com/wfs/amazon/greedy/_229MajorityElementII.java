package com.wfs.amazon.greedy;

import java.util.ArrayList;
import java.util.List;

public class _229MajorityElementII {
    private int arr[];

    public _229MajorityElementII(int[] arr) {
        this.arr = arr;
    }

    private List<Integer> majorityElement() {
        List<Integer> listOfMajorityElement =new ArrayList<>();
        int count_1=0;int count_2=0;int candidate_1=0;int candidate_2=0;
        for(int i=0;i<arr.length;i++){
            if(count_1==0){
                count_1++;
                candidate_1=arr[i];
            }else if(count_2==0){
                count_2++;
                candidate_2=arr[i];
            }else{
                count_1--;
                count_2--;
            }
        }
        count_1=0;count_2=0;
        for(int i=0;i<arr.length;i++){
            if(candidate_1==arr[i]){
                count_1++;
            }else if(candidate_2==arr[i]){
                count_2++;
            }
        }
        if(count_1>=arr.length/3)
            listOfMajorityElement.add(candidate_1);
        if(count_2>=arr.length/3)
            listOfMajorityElement.add(candidate_2);
        return listOfMajorityElement;
    }
}
