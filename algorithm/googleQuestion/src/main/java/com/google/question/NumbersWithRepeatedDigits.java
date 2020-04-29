package com.google.question;

import java.util.ArrayList;
import java.util.HashSet;

public class NumbersWithRepeatedDigits   {
    private int N;

    public NumbersWithRepeatedDigits(int n) {
        N = n;
    }


    public int numDupDigitsAtMostN() {
        // Transform N + 1 to arrayList
        ArrayList<Integer> L = new ArrayList<Integer>();
        for (int x = N + 1; x > 0; x /= 10)
            L.add(0, x % 10);

        // Count the number with digits < N
        int res = 0, n = L.size();
        for (int i = 1; i < n; ++i)
            res += 9 * A(9, i - 1);

        // Count the number with same prefix
        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            for (int j = i > 0 ? 0 : 1; j < L.get(i); ++j)
                if (!seen.contains(j))
                    res += A(9 - i, n - i - 1);
            if (seen.contains(L.get(i))) break;
            seen.add(L.get(i));
        }
        return N - res;
    }
    private int A(int m, int n) {
        return n == 0 ? 1 : A(m, n - 1) * (m - n + 1);
    }

    public static void main(String[] args) {
        NumbersWithRepeatedDigits numbers =new  NumbersWithRepeatedDigits(102);
        System.out.println(numbers.A(9,2));
        //System.out.println(numbers.numDupDigitsAtMostN());
    }
}
