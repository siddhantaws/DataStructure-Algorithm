package com.amazon.question;

public class MonotoneIncreasingDigits {
    private int N;

    public MonotoneIncreasingDigits(int n) {
        N = n;
    }

    public int monotoneIncreasingDigits() {
        char[] S = String.valueOf(N).toCharArray();
        int i = 1;
        while (i < S.length && S[i-1] <= S[i]) i++;
        while (0 < i && i < S.length && S[i-1] > S[i])
            S[--i]--;
        for (int j = i+1; j < S.length; ++j) S[j] = '9';

        return Integer.parseInt(String.valueOf(S));
    }

    public static void main(String[] args) {
        MonotoneIncreasingDigits digits =new MonotoneIncreasingDigits(332);
        System.out.println(digits.monotoneIncreasingDigits());
    }
}
