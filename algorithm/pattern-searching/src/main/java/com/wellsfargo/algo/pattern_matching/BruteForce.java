package com.wellsfargo.algo.pattern_matching;

public class BruteForce extends PatternMatch {
    public BruteForce(String text, String pattern) {
        super(text, pattern);
    }

    public boolean match() {
        int j = 0 , k=0;
        for (int i = 0; i < this.text.length() - this.patternlength + 1; ++i) {
            j = 0;
            k = i;
            while (j < this.patternlength && this.pattern.charAt(j++) == this.text.charAt(k++)) ;

            if (j >= this.patternlength) {
                this.matchningIndex.add(k - this.patternlength);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        PatternMatch patternMatch = new BruteForce("AABAACAADAABAABA", "AABA");
        patternMatch.match();
        System.out.println("String Match :" + patternMatch.matchningIndex);
    }
}
