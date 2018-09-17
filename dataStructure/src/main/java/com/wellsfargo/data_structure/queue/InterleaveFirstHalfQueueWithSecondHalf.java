package com.wellsfargo.data_structure.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class InterleaveFirstHalfQueueWithSecondHalf {

    private Queue<Integer> queue;

    public InterleaveFirstHalfQueueWithSecondHalf(Queue<Integer> queue) {
        this.queue = queue;
    }

    void interLeaveQueue()
    {
        // To check the even number of elements
        if (queue.size() % 2 != 0)
            System.out.println("Input even number of integers.");

        // Initialize an empty stack of int type
        Stack<Integer> stack = new Stack<>();
        int halfSize = queue.size() / 2;

        // Push first half elements into the stack
        // queue:16 17 18 19 20, stack: 15(T) 14 13 12 11
        for (int i = 0; i < halfSize; i++) {
            stack.push(queue.peek());
            queue.poll();
        }

        // enqueue back the stack elements
        // queue: 16 17 18 19 20 15 14 13 12 11
        while (!stack.empty()) {
            queue.offer(stack.peek());
            stack.pop();
        }

        // dequeue the first half elements of queue
        // and enqueue them back
        // queue: 15 14 13 12 11 16 17 18 19 20
        for (int i = 0; i < halfSize; i++) {
            queue.offer(queue.peek());
            queue.poll();
        }

        // Again push the first half elements into the stack
        // queue: 16 17 18 19 20, stack: 11(T) 12 13 14 15
        for (int i = 0; i < halfSize; i++) {
            stack.push(queue.peek());
            queue.poll();
        }

        // interleave the elements of queue and stack
        // queue: 11 16 12 17 13 18 14 19 15 20
        while (!stack.empty()) {
            queue.offer(stack.peek());
            stack.pop();
            queue.offer(queue.peek());
            queue.poll();
        }
    }

    public void display(){
        for (int i = 0; i < queue.size()-1; i++) {
            System.out.println(queue.peek());
            queue.poll();
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q =new ArrayDeque<>();
        q.offer(11);q.offer(12);q.offer(13);q.offer(14);
        q.offer(15);q.offer(16);q.offer(17);q.offer(18);
        q.offer(19);q.offer(20);
        InterleaveFirstHalfQueueWithSecondHalf  queue1 =new InterleaveFirstHalfQueueWithSecondHalf(q);
        queue1.interLeaveQueue();
        queue1.display();
    }
}
