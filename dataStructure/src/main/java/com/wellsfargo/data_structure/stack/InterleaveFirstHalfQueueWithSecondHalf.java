package com.wellsfargo.data_structure.stack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class InterleaveFirstHalfQueueWithSecondHalf {

    private Queue<Integer> queue;

    public InterleaveFirstHalfQueueWithSecondHalf(Queue<Integer> queue) {
        this.queue = queue;
    }

    public void rearrange(){

    }

    public static void main(String[] args) {
        Queue<Integer> q =new ArrayDeque<>();
        q.offer(11);
        q.offer(12);
        q.offer(13);
        q.offer(14);
        q.offer(15);
        q.offer(16);
        q.offer(17);
        q.offer(18);
        q.offer(19);
        q.offer(20);
        InterleaveFirstHalfQueueWithSecondHalf half =new InterleaveFirstHalfQueueWithSecondHalf(q);
        half.rearrange();
    }
}
