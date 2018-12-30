package com.wellsfargo.algo.mathematics;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class PrintAllPermutationsInLexicographicOrder {

    private Character str[];
    private String text;
    int size ;
    public PrintAllPermutationsInLexicographicOrder(String text) {
        this.text = text;
        this.str = new Character[text.length()];
        for(int i=0;i<text.toCharArray().length;i++)
            str[i] = text.charAt(i);
        this.size = str.length;
        /*Arrays.sort(str, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1.compareTo(o2);
            }
        });*/
    }
    private int compare(String a, String b) {
        return a.compareTo(b);
    }
    private int findCeil(Character first, int l, int h) {
        int ceilIndex = l;
        for (int i = l + 1; i <= h; i++) {
            if (str[i].compareTo(first) > 0 && str[i].compareTo(str[ceilIndex]) < 0) {
                ceilIndex = i;
            }
        }
        return ceilIndex;
    }
    private void reverse(int l, int h) {
        while (l < h) {
            swap(l, h);
            l++;
            h--;
        }
    }
    public void sortedPermutations() {
        // Print permutations one by one
        boolean isFinished = false;
        while (!isFinished) {
            // print this permutation
            print();
            // Find the rightmost character which is smaller than its next character. Let us call it 'first char'
            int i;
            for (i = size - 2; i >= 0; --i)
                if (str[i].compareTo(str[i + 1]) < 0)
                    break;
            // If there is no such chracter, all are sorted in decreasing order, means we just printed the last permutation and we are done.
            if (i == -1)
                isFinished = true;
            else {
                // Find the ceil of 'first char' in right of first character. Ceil of a character is the smallest character greater than it
                int ceilIndex = findCeil(str[i], i + 1, size - 1);
                // Swap first and second characters
                swap(i, ceilIndex);
                // Sort the string on right of 'first char'
                reverse( i + 1, size - 1 );
            }
        }
    }
    private void swap(int i, int j) {
        Character c1 = str[j];
        str[j] = str[i];
        str[i] = c1;
    }

    private void print(){
        for(Character character:str)
            System.out.print(character);
        System.out.println();
    }

    public static void main(String[] args) {
        PrintAllPermutationsInLexicographicOrder printAllPermutationsInLexicographicOrder =new PrintAllPermutationsInLexicographicOrder("476");
        printAllPermutationsInLexicographicOrder.sortedPermutations();
    }
}
