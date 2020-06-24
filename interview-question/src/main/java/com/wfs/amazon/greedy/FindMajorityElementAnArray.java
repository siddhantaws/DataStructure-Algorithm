package com.wfs.amazon.greedy;

public class FindMajorityElementAnArray {
    private int arr[];

    public FindMajorityElementAnArray(int[] arr) {
        this.arr = arr;
    }

    public int getMajorityElement(){
        int majorityElement =-1;int count=0 ; int candidate =0;
        for(int i=0;i<arr.length;i++){
            if(count==0){
                candidate=arr[i];
                count++;
            }else{
                if(candidate==arr[i])
                    count++;
                else
                    count--;
            }
        }
        if(count==0)
            return majorityElement;
        count =0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]==candidate)
                count++;
        }
        return count > arr.length/2 ? candidate : majorityElement;
    }

    public static void main(String[] args) {
        FindMajorityElementAnArray majorityElementAnArray =new FindMajorityElementAnArray(new int[]{4,7,4,4,7,4,4,9,4,3});
        System.out.println(majorityElementAnArray.getMajorityElement());
    }
}
