package com.wfs.dynamicprogramming;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class PalindromePartitioning {

    private String str;

    private boolean[][] booleanArray;

    private int[] numArray;

    private int len;

    public PalindromePartitioning(String str) {
        this.str = str;
        this.len = str.length();
        this.booleanArray = new boolean[this.len][this.len];
        for (int i = 0; i < this.len; i++) {
            booleanArray[i][i] = true;
        }
        this.numArray = new int[this.len];
    }

    public int getMinPartition() {

        for (int L = 2; L <= len; L++) {
            // For substring of length L, set different
            // possible starting indexes
            for (int i = 0; i < len - L + 1; i++) {
                int j = i + L - 1; // Set ending index

                // If L is 2, then we just need to
                // compare two characters. Else need to
                // check two corner characters and value
                // of P[i+1][j-1]
                if (L == 2)
                    booleanArray[i][j] = (str.charAt(i) ==
                            str.charAt(j));
                else
                    booleanArray[i][j] = (str.charAt(i) == str.charAt(j)) && booleanArray[i + 1][j - 1];
            }
        }

        for(int i=0;i<booleanArray.length;i++)
        {
            System.out.println();
            for(int j=0;j<booleanArray[i].length;j++)
                System.out.print(booleanArray[i][j]+"\t");
        }

        for (int i = 0; i < len; i++) {
            if (booleanArray[0][i] == true)
                numArray[i] = 0;
            else {
                numArray[i] = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (booleanArray[j + 1][i] == true && 1 +
                            numArray[j] < numArray[i])
                        numArray[i] = 1 + numArray[j];
                }
            }
        }

        // Return the min cut value for complete
        // string. i.e., str[0..n-1]
        return numArray[len - 1];
    }

    public static void main(String[] args) {
        PalindromePartitioning partitioning =new PalindromePartitioning("aabcba");
        System.out.println(partitioning.getMinPartition());
    }
}
