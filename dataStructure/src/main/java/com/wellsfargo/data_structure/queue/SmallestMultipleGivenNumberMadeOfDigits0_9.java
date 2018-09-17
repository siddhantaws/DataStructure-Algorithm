package com.wellsfargo.data_structure.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Vector;

public class SmallestMultipleGivenNumberMadeOfDigits0_9 {

    private int MAX_COUNT = 10000;

    private Vector<String> vec;

    private int N;

    public SmallestMultipleGivenNumberMadeOfDigits0_9(int n) {
        this.N = n;
        this .vec=new Vector<>();
    }

    String generateNumbersUtil() {
        // Create an empty queue of strings
        Queue<String> q = new ArrayDeque<>();

        // enque the first number
        q.offer("9");

        // This loops is like BFS of a tree with 9 as root
        // 0 as left child and 9 as right child and so on
        for (int count = MAX_COUNT; count > 0; count--) {
            String s1 = q.peek();
            q.poll();

            // storing the front of queue in the vector
            vec.add(s1);

            String s2 = s1;

            // Append "0" to s1 and enqueue it
            q.offer(s1 + "0");

            // Append "9" to s2 and enqueue it. Note that
            // s2 contains the previous front
            q.offer(s2 + "9");
        }
        return findSmallestMultiple(N);
    }
    // function to find smallest number made up of only
    // digits 9’s and 0’s, which is a multiple of n.
    String findSmallestMultiple(int n)
    {
        // traverse the vector to find the smallest
        // multiple of n
        for (int i = 0; i < vec.size(); i++)
            // stoi() is used for string to int conversion
            if (Integer.parseInt(vec.get(i))%n == 0)
                return vec.get(i);

        return null;
    }

    public static void main(String[] args) {
        SmallestMultipleGivenNumberMadeOfDigits0_9 small =new SmallestMultipleGivenNumberMadeOfDigits0_9(5);
        System.out.println(small.generateNumbersUtil());
    }
}
