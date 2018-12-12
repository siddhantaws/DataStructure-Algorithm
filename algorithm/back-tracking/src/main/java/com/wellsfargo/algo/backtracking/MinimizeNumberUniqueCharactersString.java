package com.wellsfargo.algo.backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MinimizeNumberUniqueCharactersString {

    private String str1;

    private String str2;

    int ans = 0;

    public MinimizeNumberUniqueCharactersString(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
        ans = str1.length();
    }

    // Utility function to find minimum  number of unique characters in string.
    private int minCountUtil(String A, String B, Map<Character, Integer> map, int ind) {
        char ch1[] = A.toCharArray();
        char ch2[] = A.toCharArray();
        // If entire string is traversed, then compare current number of distinct characters in A with overall minimum.
        if (ind == A.length()) {
            ans = Math.min(ans, map.size());
            return ans;
        }
        // swap A[i] with B[i], increase count of corresponding character in map and call recursively for next index.
        A =swap(A, B, ind);
        if (map.containsKey(map.get(ch1[ind])))
            map.put(ch1[ind], map.get(ch1[ind]).intValue() + 1);
        else
            map.put(ch1[ind], 1);
        minCountUtil(A, B, map, ind + 1);
        // Backtrack (Undo the changes done)
        if (map.containsKey(map.get(ch1[ind])))
            map.put(ch1[ind], map.get(ch1[ind]).intValue() - 1);
        else
            map.put(ch1[ind], 1);

        // If count of character is reduced to zero, then that character is not present in A.
        // So remove that character from map.
        if (map.get(ch1[ind]) == 0)
            map.remove(ch1[ind]);
        // Restore A to original form. (Backtracking step)
        A =swap(A, B, ind);
        // Increase count of A[i] in map and call recursively for next index.
        if (map.containsKey(map.get(ch1[ind])))
            map.put(ch1[ind], map.get(ch1[ind]).intValue() + 1);
        else
            map.put(ch1[ind], 1);
        minCountUtil(A, B, map, ind + 1);
        // Restore the changes done (Backtracking step)
        if (map.containsKey(map.get(ch1[ind])))
            map.put(ch1[ind], map.get(ch1[ind]).intValue() - 1);
        else
            map.put(ch1[ind], 1);

        if (map.get(ch1[ind]) == 0)
            map.remove(ch1[ind]);

        return ans;
    }

    // Function to find minimum number of  distinct characters in string.
    private int minCount() {
        // Variable to store minimum number of distinct character. Initialize it with length of A
        // as maximum possible value is length of A.
        Map<Character, Integer> ele = new HashMap<>();
        // Call utility function to find minimum number of unique characters.
        return minCountUtil(str1, str2, ele, 0);
    }

    private String swap(String s1, String s2, int i) {
        char c1[]= s1.toCharArray();
        c1[i]=s2.toCharArray()[i];
        return new String(c1);
    }

    public static void main(String[] args) {
        MinimizeNumberUniqueCharactersString string = new MinimizeNumberUniqueCharactersString("abaaa", "bbabb");
        System.out.println(string.minCount());
    }
}
