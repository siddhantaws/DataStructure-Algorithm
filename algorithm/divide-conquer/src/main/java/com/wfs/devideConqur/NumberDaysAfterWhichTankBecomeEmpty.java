package com.wfs.devideConqur;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class NumberDaysAfterWhichTankBecomeEmpty {

    private int C;

    private int L;

    public NumberDaysAfterWhichTankBecomeEmpty(int c, int l) {
        C = c;
        L = l;
    }

    int getCumulateSum(int n)
    {
        return (n * (n + 1)) / 2;
    }

    int minDaysToEmpty()
    {
        // if water filling is more than capacity then
        // after C days only tank will become empty
        if (C <= L)
            return C;

        // initialize binary search variable
        int lo = 0;
        int hi = (int)1e4;
        int mid;

        // loop until low is less than high
        while (lo < hi) {

            mid = (lo + hi) / 2;

            // if cumulate sum is greater than (C - l)
            // then search on left side
            if (getCumulateSum(mid) >= (C - L))
                hi = mid;

                // if (C - l) is more then search on
                // right side
            else
                lo = mid + 1;
        }

        // final answer will be obtained by adding
        // l to binary search result
        return (L + lo);
    }

    public static void main(String[] args) {
        NumberDaysAfterWhichTankBecomeEmpty  numberDaysAfterWhichTankBecomeEmpty =new NumberDaysAfterWhichTankBecomeEmpty(5,2);
        System.out.println(numberDaysAfterWhichTankBecomeEmpty.minDaysToEmpty());
    }
}
