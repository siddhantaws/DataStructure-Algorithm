package com.wellsfargo.data_structure.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class StackPermutations {
    private int input[] ;
    private int output[] ;

    public StackPermutations(int[] input, int[] output) {
        this.input = input;
        this.output = output;
    }

    boolean  checkStackPermutation()
    {
        // Input queue
        Queue<Integer> input =new ArrayDeque<>();
        for (int i=0;i<this.input.length-1;i++)
            input.offer(this.input[i]);

        // output queue
        Queue<Integer> output =new ArrayDeque<>() ;
        for (int i=0;i<this.input.length-1;i++)
            output.offer(this.output[i]);

        // stack to be used for permutation
        Stack<Integer> tempStack = new Stack<>();
        while (!input.isEmpty())
        {
            int ele = input.peek();
            input.poll();
            if (ele == output.peek())
            {
                output.poll();
                while (!tempStack.empty())
                {
                    if (tempStack.peek() == output.peek())
                    {
                        tempStack.pop();
                        output.poll();
                    }
                    else
                        break;
                }
            }
            else
                tempStack.push(ele);
        }

        // If after processing, both input queue and
        // stack are empty then the input queue is
        // permutable otherwise not.
        return (input.isEmpty() && tempStack.empty());
    }

    public static void main(String[] args) {
        int input[] = {1, 2, 3};

        int output[] = {2, 1, 3};

        StackPermutations permutations = new StackPermutations(input,output);
        System.out.println(permutations.checkStackPermutation());
    }
}
