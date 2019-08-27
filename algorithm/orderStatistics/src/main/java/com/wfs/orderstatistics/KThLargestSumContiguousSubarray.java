package com.wfs.orderstatistics;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KThLargestSumContiguousSubarray {

    private int arr[];

    private int k;

    private PriorityQueue<Integer> queue;
    public KThLargestSumContiguousSubarray(int[] arr, int k) {
        this.arr = arr;
        this.k = k;
        this.queue =new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public int getKthLargestSum(){
        for(int i=0;i<arr.length;i++) {
            int sum =0;
            for(int j=i;j<arr.length;i++) {
                sum+=arr[j];
                if(queue.size()==k){
                    queue.poll();
                }
                queue.add(sum);
            }
        }
        return queue.poll();
    }

}
