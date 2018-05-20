package com.wfs.devideConqur;

public class SquareRootOfAnInteger {

    private int num ;
    public SquareRootOfAnInteger(int num){
        this.num=num;
    }

    public int getSqureRoot(){
        return getSqureRoot(num);
    }

    private  int getSqureRoot(int num){
        if (num == 0 || num == 1)
            return num;

        // Do Binary Search for floor(sqrt(x))
        int start = 1, end = num, ans=0;
        while (start <= end)
        {
            int mid = (start + end) / 2;

            // If x is a perfect square
            if (mid*mid ==num)
                return mid;

            // Since we need floor, we update answer when mid*mid is
            // smaller than x, and move closer to sqrt(x)
            if (mid*mid < num)
            {
                start = mid + 1;
                ans = mid;
            }
            else   // If mid*mid is greater than x
                end = mid - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        SquareRootOfAnInteger squareRootOfAnInteger=new SquareRootOfAnInteger(165);
        System.out.println(squareRootOfAnInteger.getSqureRoot());
    }
}
