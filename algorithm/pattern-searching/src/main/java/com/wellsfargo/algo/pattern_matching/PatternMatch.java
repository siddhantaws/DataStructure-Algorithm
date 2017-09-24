//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.wellsfargo.algo.pattern_matching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class PatternMatch {
    protected String text;
    protected String pattern;
    protected List matchningIndex;
    protected int patternlength;
    protected Map<Character, Integer> characterToIndexMap;
    protected int numberOfUniqueCharacter;

    public PatternMatch(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
        this.patternlength = pattern.length();
        this.characterToIndexMap = new HashMap();
        int index = 0;
        char[] var4 = pattern.toCharArray();
        int var5 = var4.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Character character = var4[var6];
            if (!this.characterToIndexMap.containsKey(character)) {
                this.characterToIndexMap.put(character, index++);
            }
        }

        this.numberOfUniqueCharacter = this.characterToIndexMap.size();
        this.matchningIndex = new ArrayList();
    }

    public abstract boolean match();

    public List getMatchningIndex() {
        return this.matchningIndex;
    }
}
