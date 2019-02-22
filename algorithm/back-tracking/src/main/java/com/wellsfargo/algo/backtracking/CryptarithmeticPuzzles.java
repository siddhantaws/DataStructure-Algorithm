package com.wellsfargo.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class CryptarithmeticPuzzles {
    private String s1;

    private String s2;

    private String s3;

    private List<Integer> use =new ArrayList();
    int count = 0;

    public CryptarithmeticPuzzles(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        for(int i=0;i<26;i++)
            use.add(0);
    }

    // function check for correct solution
    private int check(Node[] nodeArr, String s1, String s2, String s3) {
        int val1 = 0, val2 = 0, val3 = 0, m = 1, j, i;
        // calculate number corresponding to first string
        for (i = s1.length() - 1; i >= 0; i--) {
            char ch = s1.charAt(i);
            for (j = 0; j < count; j++)
                if (nodeArr[j].c == ch)
                    break;
            val1 += m * nodeArr[j].v;
            m *= 10;
        }
        m = 1;
        // calculate number corresponding to second string
        for (i = s2.length() - 1; i >= 0; i--) {
            char ch = s2.charAt(i);
            for (j = 0; j < count; j++)
                if (nodeArr[j].c == ch)
                    break;
            val2 += m * nodeArr[j].v;
            m *= 10;
        }
        m = 1;
        // calculate number corresponding to third string
        for (i = s3.length() - 1; i >= 0; i--) {
            char ch = s3.charAt(i);
            for (j = 0; j < count; j++)
                if (nodeArr[j].c == ch)
                    break;
            val3 += m * nodeArr[j].v;
            m *= 10;
        }
        // sum of first two number equal to third return true
        if (val3 == (val1 + val2))
            return 1;
        // else return false
        return 0;
    }

    // Recursive function to check solution for all permutations
    private boolean permutation(Node[] nodeArr, int n) {
        // Base case
        if (n == count - 1) {
            // check for all numbers not used yet
            for (int i = 0; i < 10; i++) {
                // if not used
                if (use.get(i) == 0) {
                    // assign char at index n integer i
                    nodeArr[n].v = i;
                    // if solution found
                    if (check(nodeArr, s1, s2, s3) == 1) {
                        System.out.println("Solution found: ");
                        for (int j = 0; j < count; j++)
                            System.out.println(" "+ nodeArr[j].c + " = "+ nodeArr[j].v);
                        return true;
                    }
                }
            }
            return false;
        }
        for (int i = 0; i < 10; i++) {
            // if ith integer not used yet
            if (use.get(i) == 0) {
                // assign char at index n integer i
                nodeArr[n].v = i;
                // mark it as not available for other char
                use.set(i ,1) ;
                // call recursive function
                if (permutation(nodeArr, n + 1))
                    return true;
                // backtrack for all other possible solutions
                use.set(i ,0) ;
            }
        }
        return false;
    }

    public boolean solveCryptographic() {
        // count to store number of unique char

        // Length of all three strings
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        // vector to store frequency of each char
        List<Integer> freq =new ArrayList<>(26);
        for(int i=0;i<26;i++)
            freq.add(0);
        for (int i = 0; i < l1; i++){
            int c = s1.charAt(i) - 'A';
            freq.set(c , freq.get(c)+1);
        }
        for (int i = 0; i < l2; i++) {
            int c = s2.charAt(i) - 'A';
            freq.set(c , freq.get(c)+1);
        }
        for (int i = 0; i < l3; i++){
            int c = s3.charAt(i) - 'A';
            freq.set(c , freq.get(c)+1);
        }
        // count number of unique char
        for (int i = 0; i < 26; i++)
            if (freq.get(i) > 0)
                count++;
        // solution not possible for count greater than 10
        if (count > 10) {
            System.out.println("Invalid strings");
            return false;
        }
        // array of nodes
        Node nodeArr[] =new Node[count];
        // store all unique char in nodeArr
        for (int i = 0, j = 0; i < 26; i++) {
            if (freq.get(i) > 0) {
                nodeArr[j] = new Node();
                nodeArr[j].c = (char)(i + 'A');
                j++;
            }
        }
        return permutation( nodeArr, 0);
    }


    class Node {
        char c;
        int v;
    }

    public static void main(String[] args) {
        CryptarithmeticPuzzles puzzles =new CryptarithmeticPuzzles("SEND","MORE","MONEY");
        System.out.println(puzzles.solveCryptographic());
    }

}
