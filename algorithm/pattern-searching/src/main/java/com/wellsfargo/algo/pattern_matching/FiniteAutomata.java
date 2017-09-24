//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.wellsfargo.algo.pattern_matching;

public class FiniteAutomata extends PatternMatch {
    private int[][] finiteAutomataArray;

    public FiniteAutomata(String text, String pattern) {
        super(text, pattern);
        this.finiteAutomataArray = new int[this.patternlength][this.numberOfUniqueCharacter];
    }

    public boolean match() {
        return false;
    }

    private void constructFiniteAutomataArray() {
        int lps = 0;

        int i;
        for(i = 0; i < this.numberOfUniqueCharacter; ++i) {
            this.finiteAutomataArray[0][i] = 0;
        }

        this.finiteAutomataArray[0][((Integer)this.characterToIndexMap.get(this.pattern.toCharArray()[0])).intValue()] = 1;

        for(i = 1; i < this.patternlength - 1; ++i) {
            for(int x = 0; x < this.numberOfUniqueCharacter; ++x) {
                this.finiteAutomataArray[i][x] = this.finiteAutomataArray[lps][x];
            }

            this.finiteAutomataArray[i][((Integer)this.characterToIndexMap.get(this.pattern.toCharArray()[i])).intValue()] = i + 1;
            if (i < this.patternlength) {
                lps = this.finiteAutomataArray[lps][((Integer)this.characterToIndexMap.get(this.pattern.toCharArray()[i])).intValue()];
            }
        }

    }

    public static void main(String[] args) {
        PatternMatch finiteAutomata = new FiniteAutomata("ababac", "ababaca");
        finiteAutomata.match();
    }
}
