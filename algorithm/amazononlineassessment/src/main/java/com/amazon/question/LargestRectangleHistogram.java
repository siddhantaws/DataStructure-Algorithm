package com.amazon.question;

public class LargestRectangleHistogram {
    int MAX_AREA= Integer.MIN_VALUE;
    public int largestRectangleArea(int[] heights) {
        largestRectangleArea(heights , 0, heights.length-1);
        return MAX_AREA;
    }


    private int largestRectangleArea(int[] heights , int l ,int r){
        if(l>r)
            return Integer.MIN_VALUE;

        int minIndex = getMinIndex(l,r,heights);
        int maxArea= Math.max(Math.max(largestRectangleArea(heights, l ,minIndex-1) , largestRectangleArea(heights,minIndex+1,r)), heights[minIndex]*(r-l+1) );

        MAX_AREA = Math.max(maxArea ,MAX_AREA );
        return maxArea;
    }

    private int getMinIndex(int l ,int r,int[] height){
        if(l==r)
            return l;
        int minValue= Integer.MAX_VALUE;
        int minIndex =-1;
        for(int i=l;i<=r;i++){
            if(minValue>height[i]){
                minValue = height[i];
                minIndex = i;
            }
        }
        return minIndex ;
    }
}
