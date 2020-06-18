package com.wfs.amazon.greedy;

import java.util.PriorityQueue;
import java.util.Queue;

public class _295FindMedianFromDataStream {

    private int arr[];
    private double median ;

    private int size;

    private Queue<Integer> maxHeap =new PriorityQueue<>((Integer o1, Integer o2)-> o2.compareTo(o1));
    private Queue<Integer> minHeap =new PriorityQueue<>();

    public _295FindMedianFromDataStream(int[] arr) {
        this.arr = arr;
        addAllElements();
    }

    public void addAllElements(){
       for(int x:arr)
           addNum(x);
    }

    public void addNum(int num) {
        if(size()==0){
            maxHeap.add(num);
            median=num;size++;
            return;
        }
        if(maxHeap.size()>minHeap.size()){
            if(median>num){
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
                median = (minHeap.peek()+maxHeap.peek())/2.0;
            }else{
                minHeap.add(num);
                median= (minHeap.peek()+maxHeap.peek())/2.0;
            }
        }else if(maxHeap.size()<minHeap.size()){
            if(median>num){
                maxHeap.add(num);
                median= (minHeap.peek()+maxHeap.peek())/2.0;
            }else{
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
                median =  (minHeap.peek()+maxHeap.peek())/2;
            }
        }else{
            if(median>num){
                maxHeap.add(num);
            }else{
                maxHeap.add(minHeap.poll());
            }
            median = maxHeap.peek();
        }
    }

    public double findMedian() {
        return median;
    }
    public int size(){
        return size;
    }

    public static void main(String[] args) {
        _295FindMedianFromDataStream median =new _295FindMedianFromDataStream(new int[]{1,2});
        System.out.println(median.findMedian());
    }
}
