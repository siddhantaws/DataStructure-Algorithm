package com.wfs.amazon.greedy;

import java.util.*;
import java.util.stream.Collectors;

public class _632SmallestRangeCoveringElementsFromKLists {
    private List<List<Integer>> nums;

    public _632SmallestRangeCoveringElementsFromKLists(List<List<Integer>> nums) {
        this.nums = nums;
    }
    public int[] smallestRange() {
        int minDifferences =Integer.MAX_VALUE;
        int returnArr[] =new int[2];
        int currentMax []=new int[2];
        currentMax[0]=0;currentMax[1]=0;
        Queue<int[]> queue =new PriorityQueue<>((int[] a1 , int[] a2 )->{

            return nums.get(a1[0]).get(a1[1]) - nums.get(a2[0]).get(a2[1]);
        });
        queue.add(new int[]{0,0});
        for(int i=1;i<nums.size();i++){
            if(nums.get(currentMax[0]).get(currentMax[1])<nums.get(i).get(0)){
                currentMax[0]=i;currentMax[1]=0;
            }
            queue.add(new int[]{i,0});
        }

        while(queue.size()==nums.size()){
            int arr[] =queue.poll();
            int differneces =nums.get(currentMax[0]).get(currentMax[1]) - nums.get(arr[0]).get(arr[1]);
            if(differneces<minDifferences) {
                minDifferences =differneces;
                returnArr[0]=nums.get(arr[0]).get(arr[1]);
                returnArr[1]=nums.get(currentMax[0]).get(currentMax[1]);
            }

            if(++arr[1]<nums.get(arr[0]).size()){
                queue.add(arr);
                if(nums.get(currentMax[0]).get(currentMax[1])< nums.get(arr[0]).get(arr[1])){
                    currentMax[0]=arr[0];currentMax[1]=arr[1];
                }

            }
        }
        return returnArr;
    }

    public static void main(String[] args) {
        int a1[]= {4,10,15,24,26};
        List<List<Integer>> nums= new ArrayList<>();
        List<Integer> La1 = Arrays.stream(a1).boxed().collect(Collectors.toList());nums.add(La1);
        int a2[] = {0,9,12,20};La1 = Arrays.stream(a2).boxed().collect(Collectors.toList());nums.add(La1);
        int a3[] = {5,18,22,30};La1 = Arrays.stream(a3).boxed().collect(Collectors.toList());nums.add(La1);
        _632SmallestRangeCoveringElementsFromKLists fromKLists =new _632SmallestRangeCoveringElementsFromKLists(nums);
        for(int a : fromKLists.smallestRange())
            System.out.print(a+" ");
    }
}
