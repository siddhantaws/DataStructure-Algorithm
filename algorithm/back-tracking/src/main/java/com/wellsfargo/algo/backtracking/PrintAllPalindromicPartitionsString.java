package com.wellsfargo.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class PrintAllPalindromicPartitionsString {
    private String str;

    public PrintAllPalindromicPartitionsString(String str) {
        this.str = str;
    }

    // Returns true if str is palindrome, else false
    private boolean checkPalindrome(String str) {
        int len = str.length();
        len--;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) != str.charAt(len))
                return false;
            len--;
        }
        return true;
    }

    // Prints the partition list
    private void printSolution(List<List<String>> partitions) {
        for (List<String> i : partitions) {
            for (String j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    // Goes through all indexes and recursively add remaining  partitions if current string is palindrome.
    private List<List<String>> addStrings(List<List<String>> v, String s, List<String> temp, int index) {
        int len = s.length();
        String str = "";
        List<String> current = new ArrayList<>(temp);
        if (index == 0)
            temp.clear();
        // Iterate over the string
        for (int i = index; i < len; ++i) {
            str = str + s.charAt(i);
            // check whether the substring is palindromic or not
            if (checkPalindrome(str)) {
                // if palindrome add it to temp list
                temp.add(str);
                if (i + 1 < len) {
                    // recurr to get all the palindromic partitions for the substrings
                    v = addStrings(v, s, temp, i + 1);
                } else {
                    // if end of the string is reached add temp to v
                    v.add(temp);
                }
                // temp is reinitialize with the current i.
                temp = new ArrayList<>(current);
            }
        }
        return v;
    }

    // Generates all palindromic partitions of 's' and stores the result in 'v'.
    public void partition() {
        // temporary ArrayList to store each palindromic string
        List<List<String>> partitions = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        // calling addString method it adds all the palindromic partitions to v
        partitions = addStrings(partitions, str, temp, 0);
        // printing the solution
        printSolution(partitions);
    }

    public static void main(String[] args) {
        PrintAllPalindromicPartitionsString partitionsString = new PrintAllPalindromicPartitionsString("geeks");
        partitionsString.partition();
    }
}
