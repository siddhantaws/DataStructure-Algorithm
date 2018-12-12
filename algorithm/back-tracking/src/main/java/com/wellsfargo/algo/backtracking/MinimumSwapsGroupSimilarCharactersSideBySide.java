package com.wellsfargo.algo.backtracking;


import java.util.HashSet;
import java.util.Set;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MinimumSwapsGroupSimilarCharactersSideBySide {

    private String str;


    private boolean sameCharAdj(String str) {
        int n = str.length(), i;
        Set<String> set = new HashSet<>();
        char ch[] = str.toCharArray();
        set.add(str.toCharArray()[0] + "");
        for (i = 1; i < n; i++) {
            // If similar chars side by side, continue
            if (ch[i] == ch[i - 1])
                continue;
            // If we have found a char equal to current char and does not exist side to it, return false
            if (set.contains(ch[i]+""))
                return false;
            set.add(ch[i]+"");
        }
        return true;
    }

    private String swap(String str, int i, int j) {
        char ch[] = str.toCharArray();
        char c = ch[i];
        ch[i] = ch[j];
        ch[j] = c;
        return  new String(ch);
    }

    // counts min swap operations to convert a string that has similar characters side by side
    public int minSwaps(String str, int l, int r, int cnt, int minm) {
        // Base case
        if (l == r) {
            if (sameCharAdj(str))
                return cnt;
            else
                return Integer.MAX_VALUE;
        }
        for (int i = l + 1; i <= r; i++) {
            str = swap(str, i, l);
            cnt++;
            // considering swapping of i and l chars
            int x = minSwaps(str, l + 1, r, cnt, minm);
            // Backtrack
            str = swap(str, i, l);
            cnt--;
            // not considering swapping of i and l chars
            int y = minSwaps(str, l + 1, r, cnt, minm);
            // taking min of above two
            minm = Math.min(minm, Math.min(x, y));
        }
        return minm;
    }

    public static void main(String[] args) {
        MinimumSwapsGroupSimilarCharactersSideBySide side =new MinimumSwapsGroupSimilarCharactersSideBySide();
        String str = "abbaacb";
        System.out.println(side.minSwaps("abbaacb", 0 , str.length()-1 , 0 ,Integer.MAX_VALUE));
    }

}
