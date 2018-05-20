package com.wellsfargo.algo.mathematics;

public class CubicRootOfANumber {
    private double num;

    public CubicRootOfANumber(double num) {
        this.num = num;
    }

    private double diff(double n, double mid)
    {
        if (n > (mid*mid*mid))
            return (n-(mid*mid*mid));
        else
            return ((mid*mid*mid) - n);
    }

    private double getCubicRoot(){
        return getCubicRoot(num);
    }

    public double getCubicRoot(double n){
        // Set start and end for binary search
        double start = 0, end = n;

        // Set precision
        double e = 0.0000001;

        while (true)
        {
            double mid = (start + end)/2;
            double error = diff(n, mid);

            // If error is less than e then mid is
            // our answer so return mid
            if (error <= e)
                return mid;

            // If mid*mid*mid is greater than n set
            // end = mid
            if ((mid*mid*mid) > n)
                end = mid;

                // If mid*mid*mid is less than n set
                // start = mid
            else
                start = mid;
        }
    }

    public static void main(String[] args) {
        CubicRootOfANumber cubicRootOfANumber =new CubicRootOfANumber(10.0);
        System.out.println(cubicRootOfANumber.getCubicRoot());
    }
}
