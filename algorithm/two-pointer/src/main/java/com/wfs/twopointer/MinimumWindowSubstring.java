package com.wfs.twopointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumWindowSubstring {
    private String str;

    private String pattern;

    public MinimumWindowSubstring(String str, String pattern) {
        this.str = str;
        this.pattern = pattern;
    }


    public String minWindow(String s, String t) {

        if (str.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> dictT = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        int required = dictT.size();

        // Filter all the characters from s into a new list along with their index.
        // The filtering criteria is that the character should be present in t.
        List<Pair> filtered= new ArrayList<Pair>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (dictT.containsKey(c)) {
                filtered.add(new Pair(i, c));
            }
        }

        int l = 0, r = 0, formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();
        int[] ans = {-1, 0, 0};

        // Look for the characters only in the filtered list instead of entire str.
        // This helps to reduce our search.
        // Hence, we follow the sliding window approach on as small list.
        while (r < filtered.size()) {
            char c = filtered.get(r).getValue();
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = filtered.get(l).getValue();

                // Save the smallest window until now.
                int end = filtered.get(r).getKey();
                int start = filtered.get(l).getKey();
                if (ans[0] == -1 || end - start + 1 < ans[0]) {
                    ans[0] = end - start + 1;
                    ans[1] = start;
                    ans[2] = end;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : str.substring(ans[1], ans[2] + 1);
    }
    class Pair{
        private Integer i ;
        private Character character;

       public char getValue(){
           return  character;
       }

        public int getKey(){
            return  i;
        }

        public Pair(Integer i, Character character) {
            this.i = i;
            this.character = character;
        }
    }
}
