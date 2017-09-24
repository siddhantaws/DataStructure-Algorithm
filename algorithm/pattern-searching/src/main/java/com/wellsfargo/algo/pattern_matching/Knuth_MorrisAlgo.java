//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.wellsfargo.algo.pattern_matching;

public class Knuth_MorrisAlgo extends PatternMatch {
    private int[] prefixArray;

    public Knuth_MorrisAlgo(String text, String pattern) {
        super(text, pattern);
        this.prefixArray = new int[pattern.length()];
    }

    public boolean match() {
        this.getPrefixArray();
        int j = 0 , k=0;
        for(int i = 0; i + j < this.text.length(); ++i) {
            k=i;
            while(j < this.patternlength && this.pattern.charAt(j) == this.text.charAt(k)) {
                ++j;k++;
            }

            if (j == this.patternlength) {
                this.matchningIndex.add(k - this.patternlength);
            } else if (j < this.patternlength) {
                int skipIndex = j = this.prefixArray[j == 0 ? 0 : j - 1];
                i = skipIndex > 0 ? k - 1 : i;
            }
        }

        return false;
    }

    private int[] getPrefixArray() {
        int i = 0;
        int j = 1;
        this.prefixArray[0] = 0;

        while(j < this.patternlength) {
            if (this.pattern.charAt(i) == this.pattern.charAt(j)) {
                int var10001 = j++;
                ++i;
                this.prefixArray[var10001] = i;
            } else if (i == 0) {
                this.prefixArray[j++] = 0;
            } else {
                i = this.prefixArray[i - 1];
            }
        }

        return this.prefixArray;
    }

    public static void main(String[] args) {
        Knuth_MorrisAlgo patternMatch = new Knuth_MorrisAlgo("abxabcabcaby ", "abcaby");
        patternMatch.match();
        System.out.println(patternMatch.matchningIndex);
        for(int a :patternMatch.getPrefixArray())
            System.out.println(a);
    }
}
