package com.wellsfargo.algo.backtracking;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class FindMaximumNumberPossibleByDoingAtMostKSwaps {
    private String str;

    private int K;

    static String max = "";

    public FindMaximumNumberPossibleByDoingAtMostKSwaps(String str, int k) {
        this.str = str;
        K = k;
    }
    void findMaximumNum(){
        findMaximumNum(K);
        System.out.println(max);
    }
    // function to find maximum integer possible by doing at-most K swap operations on its digits
    void findMaximumNum(int k ) {
        // return if no swaps left
        if (k == 0)
            return;
        int n = str.length();
        // consider every digit
        for (int i = 0; i < n - 1; i++) {
            // and compare it with all digits after it
            for (int j = i + 1; j < n; j++) {
                // if digit at position i is less than digit at position j, swap it and check for maximum number so far and recurse for remaining swaps
                if (str.charAt(i) < str.charAt(j)) {
                    // swap str[i] with str[j]
                    swap(i, j);
                    // If current num is more than maximum so far
                    if (str.compareTo(max) > 0)
                        max = str;
                    // recurse of the other k - 1 swaps
                    findMaximumNum(k - 1);
                    // backtrack
                    swap(i, j);
                }
            }
        }
    }

    private void swap(int i, int j) {
        char c1 =str.charAt(j);
        char ch[] = str.toCharArray();
        ch[j]=ch[i];
        ch[i]= c1;
        str = new String(ch);
    }

    public static void main(String[] args) {
        FindMaximumNumberPossibleByDoingAtMostKSwaps mostKSwaps =new FindMaximumNumberPossibleByDoingAtMostKSwaps("7599",2);
        mostKSwaps.findMaximumNum();
    }
}
