package com.amazon.question;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianOfStreamOfRunningIntegers {

    private int arr[];

    private Queue<Integer> minHeap;

    private Queue<Integer> maxHeap;

    public MedianOfStreamOfRunningIntegers(int[] arr) {
        this.arr = arr;
        this.minHeap =new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
    }

    public int median(){
        int medain=arr[0];
        maxHeap.add(medain);
        for(int i=1;i<arr.length;i++){
            if(maxHeap.size()>minHeap.size()){
                if(medain>arr[i]){
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(arr[i]);
                }else{
                    minHeap.add(arr[i]);
                }
                medain = (minHeap.peek()+maxHeap.peek())/2;
            }else if(maxHeap.size()==minHeap.size()){
                if(medain>arr[i]) {
                    minHeap.add(arr[i]);
                    medain =minHeap.peek();
                } else{
                    maxHeap.add(arr[i]);
                    medain =maxHeap.peek();
                }
            }else{
                if(medain<arr[i]){
                    maxHeap.add(minHeap.poll());
                    minHeap.add(arr[i]);
                }else{
                    maxHeap.add(arr[i]);
                }
                medain = (minHeap.peek()+maxHeap.peek())/2;
            }
        }
        return medain;
    }
}
