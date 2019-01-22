package com.wellsfargo.data_structure.array;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class CheckStringsRotationsOfEachOtherOrNot {

    private String str1;

    private String str2;

    public CheckStringsRotationsOfEachOtherOrNot(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    public boolean isRotation(){
        int n = str1.length();
        int m = str2.length();
        if (n != m)
            return false;
        // create lps[] that will hold the longest  prefix suffix values for pattern
        int lps[] = new int[n];

        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to n-1
        while (i < n) {
            if (str1.charAt(i) == str2.charAt(len)) {
                lps[i] = ++len;
                ++i;
            }
            else {
                if (len == 0) {
                    lps[i] = 0;
                    ++i;
                }
                else {
                    len = lps[len - 1];
                }
            }
        }
        i = 0;
        // match from that rotating point
        for (int k = lps[n - 1]; k < m; ++k) {
            if (str2.charAt(k) != str1.charAt(i++))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CheckStringsRotationsOfEachOtherOrNot rotations =new CheckStringsRotationsOfEachOtherOrNot("ABACD","CDABA");
        System.out.println(rotations.isRotation());
    }
}
