package com.wellsfargo.algo.backtracking;

import java.util.Arrays;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class PowerSetLexicographicOrder {

    private String str;

    public PowerSetLexicographicOrder(String str) {
        this.str = str;
    }
    // Generates power set in lexicographic  order.
    public void powerSet()
    {
        char ch[] = str.toCharArray();
        Arrays.sort(ch);
        String newStr =new String(ch);
        permuteRec(newStr, newStr.length(), -1 , "");
    }
    // str : Stores input string  n : Length of str. curr : Stores current permutation index : Index in current permutation, curr
    private void permuteRec(String str, int n,int index , String curr ) {
        // base case
        if (index == n)
            return;
        System.out.println(curr);
        for (int i = index + 1; i < n; i++) {
            curr += str.charAt(i);
            permuteRec(str, n, i, curr);
            // backtracking
            curr = curr.substring(0, curr.length() - 1);
        }
        return;
    }

    public static void main(String[] args) {
        PowerSetLexicographicOrder  order =new PowerSetLexicographicOrder("cab");
        order.powerSet();
    }
}
