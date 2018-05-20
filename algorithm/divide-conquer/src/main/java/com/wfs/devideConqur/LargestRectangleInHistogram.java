package com.wfs.devideConqur;

public class LargestRectangleInHistogram {

    private int[] height;
    private int[][] minHeight ;

    public LargestRectangleInHistogram(int[] height){
        this.height = height;
        this.minHeight= new int[height.length][height.length];
        buildMinIndex(height);
    }

    private void buildMinIndex(int[] heights) {
        int n = heights.length;

        // Build minIdx arrary using DP
        for (int i = 0; i < n; i++)
            minHeight[i][i] = i;
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n-len; i++) {
                int j = i+len-1;
                if (heights[j] < heights[minHeight[i][j-1]])
                    minHeight[i][j] = j;
                else
                    minHeight[i][j] = minHeight[i][j-1];
            }
        }
    }

    private int getMinIndex(int i , int j){
        return minHeight[i][j];
    }

    private int divideAndconquer(int L, int R) {
        if (L > R)
            return 0;

        int M = getMinIndex( L, R);
        int area = height[M] * (R-L+1);
        int leftArea = divideAndconquer( L, M-1);
        int rightArea = divideAndconquer( M+1, R);

        area = Math.max(leftArea, area);
        area = Math.max(rightArea, area);
        return area;
    }

    public int largestRectangleArea() {
        return divideAndconquer(0, height.length-1);
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram largestRectangleInHistogram=new LargestRectangleInHistogram(new int[]{2,1,5,6,2,3});
        System.out.println(largestRectangleInHistogram.largestRectangleArea());
    }
}
