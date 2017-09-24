//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.wellsfargo.algo.pattern_matching;

public class FiniteAutomata extends PatternMatch {
    private int[][] finiteAutomataArray;

    public FiniteAutomata(String text, String pattern) {
        super(text, pattern);
        this.finiteAutomataArray = new int[this.patternlength+1][this.numberOfUniqueCharacter];
    }

    public boolean match() {
        int state =0 ;
        constructFiniteAutomataArray();
        for(int i=0;i<text.length();i++)
        {
            if(!characterToIndexMap.containsKey(text.charAt(i)))
                state =0;
            else
                state =finiteAutomataArray[state][characterToIndexMap.get(text.charAt(i))];

            if(state==patternlength)
                matchningIndex.add(i-patternlength+1);
        }
        return false;
    }

    private void constructFiniteAutomataArray() {
        int lps = 0;

        int i;
        for (i = 0; i < this.numberOfUniqueCharacter; ++i) {
            this.finiteAutomataArray[0][i] = 0;
        }

        this.finiteAutomataArray[0][((Integer) this.characterToIndexMap.get(this.pattern.toCharArray()[0])).intValue()] = 1;

        for (i = 1; i < this.patternlength+1; ++i) {
            for (int x = 0; x < this.numberOfUniqueCharacter; ++x) {
                this.finiteAutomataArray[i][x] = this.finiteAutomataArray[lps][x];
            }
            if (i < this.patternlength) {
                this.finiteAutomataArray[i][this.characterToIndexMap.get(this.pattern.toCharArray()[i])] = i + 1;
                lps = this.finiteAutomataArray[lps][this.characterToIndexMap.get(this.pattern.toCharArray()[i])];
            }
        }

    }

    public static void main(String[] args) {
        PatternMatch finiteAutomata = new FiniteAutomata("abxabcabcaby", "abcaby");
        finiteAutomata.match();
        System.out.println(finiteAutomata.getMatchningIndex());
    }
}
