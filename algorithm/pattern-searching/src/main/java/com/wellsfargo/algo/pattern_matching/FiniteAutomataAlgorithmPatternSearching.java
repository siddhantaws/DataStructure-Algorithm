package com.wellsfargo.algo.pattern_matching;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class FiniteAutomataAlgorithmPatternSearching {

    private Map<Character ,Character> characterMap;
    private char arr[];
    private int numberOfUniqueCharacter;
    private int state[][];


    public FiniteAutomataAlgorithmPatternSearching(char[] arr) {
        this.characterMap = new HashMap<>();
        this.arr = arr;
        for(char c:arr)
            characterMap.put(c,c);
        this.numberOfUniqueCharacter =characterMap.size();
        this.state = new int[arr.length+1][numberOfUniqueCharacter];
    }

    /* This function builds the TF table which represents Finite Automata for a  given pattern  */
    void computeTransFun() {
        int i, lps = 0, x;
        // Fill entries in first row
        for (x =0; x < numberOfUniqueCharacter; x++)
            state[0][x] = 0;
        state[0][arr[0]] = 1;

        // Fill entries in other rows
        for (i = 1; i<= arr.length; i++)
        {
            // Copy values from row at index lps
            for (x = 0; x < numberOfUniqueCharacter; x++)
                state[i][x] = state[lps][x];

            // Update the entry corresponding to this character
            state[i][arr[i]] = i + 1;

            // Update lps for next row to be filled
            if (i < arr.length)
                lps = state[lps][arr[i]];
        }

        for(i=0;i<state.length;i++){
            System.out.println("");
            for(int j=0;j<state[i].length;j++){
                System.out.print(" "+ state[i][j]);
            }
        }

    }

    public static void main(String[] args) {
        FiniteAutomataAlgorithmPatternSearching patternSearching =new FiniteAutomataAlgorithmPatternSearching("GEEKS".toCharArray());
        patternSearching.computeTransFun();
    }

}
