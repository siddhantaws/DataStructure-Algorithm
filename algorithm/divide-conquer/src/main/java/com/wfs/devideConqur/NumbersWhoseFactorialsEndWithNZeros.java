package com.wfs.devideConqur;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class NumbersWhoseFactorialsEndWithNZeros {
    private int n;

    public NumbersWhoseFactorialsEndWithNZeros(int n) {
        this.n = n;
    }

    private int trailingZeroes(int num)
    {
        int cnt = 0;
        while (num > 0)
        {
            num /= 5;
            cnt += num;
        }
        return cnt;
    }

    public void binarySearch()
    {
        int low = 0;
        // range of numbers
        int high = 1000000;
        // binary search for first number with n trailing zeros
        while (low < high) {
            int mid = (low + high) / 2;
            int count = trailingZeroes(mid);
            if (count < n)
                low = mid + 1;
            else
                high = mid;
        }
        // Print all numbers after low with n trailing zeros.
        int result[] = new int[1000];
        int k = 0;
        while (trailingZeroes(low) == n) {
            result[k] = low;
            k++;
            low++;
        }
        // Print result
        for (int i = 0; i < k; i++)
            System.out.print(result[i] + " ");
    }

    public static void main(String[] args) {
        NumbersWhoseFactorialsEndWithNZeros end =new NumbersWhoseFactorialsEndWithNZeros(1);
        end.binarySearch();
    }
}
