package com.wellsfargo.data_structure.queue;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {
    private int arr[];
    private int k;

    public SlidingWindow(int[] arr, int k) {
        this.arr = arr;
        this.k=k;
    }

    public void printMax(){
        Deque<Integer> Qi = new LinkedList<>();

        int i;
        for(i = 0; i < k; ++i)
        {
            // For very element, the previous smaller elements are useless so
            // remove them from Qi
            while(!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();   // Remove from rear

            // Add new element at rear of queue
            Qi.addLast(i);
        }

        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for( ;i < arr.length; ++i)
        {
            // The element at the front of the queue is the largest element of
            // previous window, so print it
            System.out.print(arr[Qi.peek()] + " ");

            // Remove the elements which are out of this window
            while((!Qi.isEmpty()) && Qi.peek() <= i-k)
                Qi.removeFirst();

            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();


            // Add current element at the rear of Qi
            Qi.addLast(i);

        }

        // Print the maximum element of last window
        System.out.print(arr[Qi.peek()]);

    }

    public static void main(String[] args) {
        int arr[]={12, 1, 78, 90, 57, 89, 56};
        SlidingWindow window =new SlidingWindow(arr, 3);
        window.printMax();
    }
}
