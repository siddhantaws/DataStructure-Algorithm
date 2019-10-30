package com.amazon.question;

import java.util.*;

public class WordBreak_II {
    private char[] chars;

    private Set<String> stringSet;

    private Result[][] results;

    public WordBreak_II(String str, Set<String> stringSet) {
        this.chars = str.toCharArray();
        this.stringSet = stringSet;
        this.results = new Result[chars.length][chars.length];
        for(int i=0;i<results.length;i++)
            Arrays.fill(results[i], new Result());
    }

    public List<String> wordBreak() {
        List<String> al = new ArrayList<>();
        int l = 1;
        while (l <= chars.length) {
            for (int i = 0; i + l <=chars.length; i++) {
                String subStr = new String(chars, i, l);
                if (stringSet.contains(subStr)) {
                    results[i][i + l].isWordPossible = true;
                    results[i][i + l].getIntegerMap().put(i, i + l);
                } else {
                    for (int k = 0; k < i + l && l>1 ; k++) {
                        if (results[i][i + k].isWordPossible == true && results[i + k + 1][i + l-1].isWordPossible == true) {
                            results[i][i + l].isWordPossible = true;
                            results[i][i + l].getIntegerMap().put(i, i + k);
                            results[i][i + l].getIntegerMap().put(i + k + 1, i + l);
                            break;
                        }
                    }
                }
            }
            l++;
        }
        return al;
    }

    class Result {
        boolean isWordPossible;
        Map<Integer, Integer> integerMap = new LinkedHashMap<>();

        public boolean isWordPossible() {
            return isWordPossible;
        }

        public Map<Integer, Integer> getIntegerMap() {
            return integerMap;
        }
    }

    public static void main(String[] args) {
        String str[] = {"cat", "cats", "and", "sand", "dog"};
        WordBreak_II breakIi = new WordBreak_II("catsanddog", new HashSet(Arrays.asList(str)));
        for (String s : breakIi.wordBreak()) {
            System.out.println(s);
        }
    }
}
