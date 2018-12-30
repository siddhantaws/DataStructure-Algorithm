package com.wellsfargo.algo.mathematics;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class LexicographicRankOfAString {

    private static int MAX_CHAR = 256;
    private int count[] = new int[MAX_CHAR];
    private String str;
    private char ch[];

    public LexicographicRankOfAString(String str) {
        this.str = str;
        this.ch= str.toCharArray();
    }

    private int factorial(int n) {
        return (n <= 1) ? 1 : n * factorial(n - 1);
    }

    // Removes a character ch from count[] array  constructed by populateAndIncreaseCount()
    private void updatecount(char ch) {
        for (int i = ch; i < MAX_CHAR; ++i)
            --count[i];
    }

    // Construct a count array where value at every index  contains count of smaller characters in whole string
    private void populateAndIncreaseCount() {
        int i;
        for (i = 0; i < str.length(); ++i)
            ++count[ch[i]];
        for (i = 1; i < MAX_CHAR; ++i)
            count[i] += count[i - 1];
    }
    // A function to find rank of a string in all permutations  of characters
    public int findRank() {
        int len = str.length();
        int mul = factorial(len);
        int rank = 1, i;
        // all elements of count[] are initialized with 0
        // Populate the count array such that count[i] contains count of characters which are present in str and are smaller than i
        populateAndIncreaseCount();
        for (i = 0; i < len; ++i) {
            mul /= len - i;
            // count number of chars smaller than str[i] fron str[i+1] to str[len-1]
            rank += count[ ch[i] - 1] * mul;
            // Reduce count of characters greater than str[i]
            updatecount (ch[i]);
        }
        return rank;
    }

    public static void main(String[] args) {
        LexicographicRankOfAString rank =new LexicographicRankOfAString("DCBA");
        System.out.println(rank.findRank());
    }
}
