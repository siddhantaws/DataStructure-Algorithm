package com.wellsfargo.algo.mathematics;

public class SquareRootOfAnInteger {

    private Integer num;

    public SquareRootOfAnInteger(Integer num) {
        this.num = num;
    }

    public Integer getSquareRootBF(Integer num) {

        // Base cases
        if (num == 0 || num == 1)
            return num;

        int i = 1, result = 1;

        while (result <= num) {
            i++;
            result = i * i;
        }

        return i - 1;
    }

    public Integer getSquareRootUsingBS(Integer num) {
        // Base cases
        if (num == 0 || num == 1)
            return num;

        int start = 1, end = num, ans=0;
        while (start <= end)
        {
            int mid = (start + end) / 2;

            // If x is a perfect square
            if (mid*mid == num)
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

    public float getSquareUsingBabylonian(float num){

        /*We are using n itself as
        initial approximation This
        can definitely be improved */
        float x = num;
        float y = 1;
        // e decides the accuracy level
        double e = 0.000001;
        while(x - y > e)
        {
            x = (x + y)/2;
            y = num/x;
        }
        return  x;
    }

    int squareRoot(int n)
    {
        int x = n;
        int y = 1;
        while(x > y)
        {
            x = (x + y)/2;
            y = n/x;
        }
        return x;
    }
    public static void main(String[] args) {
        SquareRootOfAnInteger sq=new SquareRootOfAnInteger(10);
        System.out.println(sq.squareRoot(9));
    }
}
