package com.wellsfargo.data_structure.heap;

import java.util.PriorityQueue;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MedianOfStreamOfRunningIntegers {

    private PriorityQueue<Integer> maxHeap ;
    private PriorityQueue<Integer> minHeap ;
    private int arr[];
    private int med ;

    public MedianOfStreamOfRunningIntegers(int[] arr) {
        this.arr = arr;
        this.med=arr[0];
        this.maxHeap =new PriorityQueue<>((c1,c2 )->{
            return c2.compareTo(c1) ;
        });
        maxHeap.add(med);
        this.minHeap =new PriorityQueue<>((c1,c2 )->{
            return c1.compareTo(c2) ;
        });
    }

    public int median() {

        for(int i=1;i<arr.length;i++){
           int x= arr[i];
            if (maxHeap.size() > minHeap.size()) {// case1(left side heap has more elements)
                if (x < med) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.poll();
                    maxHeap.add(x);
                } else
                    minHeap.add(x);

                med = (maxHeap.peek() + minHeap.peek()) / 2;
            }else if (maxHeap.size() == minHeap.size()) { // case2(both heaps are balanced)
                if (x < med) {
                    maxHeap.add(x);
                    med = maxHeap.peek();
                } else {
                    minHeap.add(x);
                    med = minHeap.peek();
                }
            }else {// case3(right side heap has more elements)
                if (x > med) {
                    maxHeap.add(minHeap.peek());
                    minHeap.poll();
                    minHeap.add(x);
                } else
                    maxHeap.add(x);
                med = (maxHeap.peek() + minHeap.peek()) / 2;
            }
        }
        return med;
    }


    public static void main(String[] args) {
        int arr[] = {5, 15, 10, 20, 3};
        MedianOfStreamOfRunningIntegers median =new MedianOfStreamOfRunningIntegers(arr);
        System.out.println(median.median());
    }
}
