package com.wfs.twopointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueLetterString {
    private String str;

    public UniqueLetterString(String str) {
        this.str = str;
    }

    public int uniqueLetterString(String S) {
        Map<Character, List<Integer>> index = new HashMap<>();
        for (int i = 0; i < S.length(); ++i) {
            char c = S.charAt(i);
            index.computeIfAbsent(c, x-> new ArrayList()).add(i);
        }

        long ans = 0;
        for (List<Integer> A: index.values()) {
            for (int i = 0; i < A.size(); ++i) {
                long prev = i > 0 ? A.get(i-1) : -1;
                long next = i < A.size() - 1 ? A.get(i+1) : S.length();
                ans += (A.get(i) - prev) * (next - A.get(i));
            }
        }

        return (int) ans % 1_000_000_007;
    }

    public static void main(String[] args) {
        UniqueLetterString letterString =new UniqueLetterString("ABC");
        System.out.println(letterString.uniqueLetterString(letterString.str));
    }
}
