package com.wfs.amazon.dynamicprograming;

import java.util.Stack;

public class _84LargestRectangleHistogram {
    private int arr[];

    public _84LargestRectangleHistogram(int[] arr) {
        this.arr = arr;
    }
    public int largestRectangleArea() {
        if(arr.length==1)
            return arr[0];
        Stack<Integer> stack =new Stack();stack.push(-1);stack.push(0);
        int maxArea =arr[0];
        int i=1;
        for(;i<arr.length;i++){
            maxArea =Math.max(maxArea , arr[i]);
            if(arr[stack.peek()]>arr[i]){
                while(stack.peek()!=-1 && arr[stack.peek()]>arr[i])
                    stack.pop();
                maxArea =Math.max(maxArea , (i- stack.peek()-1)*arr[i]);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int x =stack.pop();
            maxArea =Math.max(maxArea , (i- x)*arr[x]);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        _84LargestRectangleHistogram rectangleHistogram =new _84LargestRectangleHistogram(new int []{2,1,5,6,2,3});
        System.out.println(rectangleHistogram.largestRectangleArea());
    }
}
