package com.amazon.question;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumCostConnectSticks {
    private int arr[];

    private int minimumCost(){
        Queue<Integer> integers =new PriorityQueue<>();
        int result =0;
        for(int i=0;i<arr.length;i++)
            integers.add(arr[i]);

        while(integers.size()>1){
            int x1 =integers .poll();
            int x2 =integers .poll();
            result+= x1+x2;
            integers.add(x1+x2);
        }
        return result;
    }
}
