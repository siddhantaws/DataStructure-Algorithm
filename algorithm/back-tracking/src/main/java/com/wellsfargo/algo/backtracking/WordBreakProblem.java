package com.wellsfargo.algo.backtracking;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class WordBreakProblem {

    private static String dictionary[] = {"mobile", "samsung", "sam", "sung", "man", "mango", "icecream", "and", "go", "i", "love", "ice", "cream"};

    private String word;

    public WordBreakProblem(String word) {
        this.word = word;
    }

    /* A utility function to check whether a word  is present in dictionary or not.  An array of strings is used for dictionary.  Using array of strings for dictionary is definitely not
        a good idea. We have used for simplicity of  the program*/
    private boolean dictionaryContains(String word1) {
        for (int i = 0; i < dictionary.length; i++)
            if (dictionary[i].compareTo(word1) == 0)
                return true;
        return false;
    }

    // Prints all possible word breaks of given string
    public  void wordBreak() {
        // last argument is prefix
        wordBreakUtil(word, word.length(), "");
    }

    // result store the current prefix with spaces  between words
    void wordBreakUtil(String str, int n, String result) {
        //Process all prefixes one by one
        for (int i = 1; i <= n; i++) {
            //extract substring from 0 to i in prefix
            String prefix = str.substring(0, i);
            // if dictionary conatins this prefix, then we check for remaining string. Otherwise
            // we ignore this prefix (there is no else for this if) and try next
            if (dictionaryContains(prefix)) {
                // if no more elements are there, print it
                if (i == n) {
                    // add this element to previous prefix
                    result += prefix;
                    System.out.println(result); //print result
                    return;
                }
                wordBreakUtil(str.substring(i, n - i), n - i, result + prefix + " ");
            }
        }      //end for
    }

    public static void main(String[] args) {
        WordBreakProblem breakProblem =new WordBreakProblem("iloveicecreamandmango");
        breakProblem.wordBreak();
    }
}
