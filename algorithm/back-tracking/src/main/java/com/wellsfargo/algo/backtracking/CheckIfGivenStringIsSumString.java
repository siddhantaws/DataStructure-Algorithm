package com.wellsfargo.algo.backtracking;

/**
 * @author Siddhanta Kumar Pattnaik
 */

public class CheckIfGivenStringIsSumString {
    private String str;
    public CheckIfGivenStringIsSumString(String str) {
        this.str = str;
    }
    private String[] convertToStringArray(String str1) {
        String s1[] = new String[str1.length()];
        for (int i = 0; i < str1.length(); i++)
            s1[i] = str1.substring(i, i+1);
        return s1;
    }
    // this is function for finding sum of two  numbers as string
    private String string_sum(String str1, String str2) {
        return (new Integer(str1)+new Integer(str2))+"";
    }

    // Returns true of two substrings of ginven lengths of str[beg..] can cause a positive result.
    boolean checkSumStrUtil(String str, int beg, int len1, int len2) {
        // Finding two substrings of given lengths and their sum
        System.out.println("beg->"+beg+",len1->"+len1+",len2->"+len2);
        String s1 = str.substring(beg, beg + len1);
        String s2 = str.substring(beg + len1, beg + len1 + len2);
        String s3 = string_sum(s1, s2);
        int s3_len = s3.length();
        // if number of digits s3 is greater then the available string size
        if (s3_len > str.length() - len1 - len2 - beg)
            return false;
        // we got s3 as next number in main string
        if (s3 .equals(str.substring(beg + len1 + len2, beg + len1 + len2+s3_len))) {
            // if we reach at the end of the string
            if (beg + len1 + len2 + s3_len == str.length())
                return true;
            // otherwise call recursively for n2, s3
            System.out.println("recurring");
            return checkSumStrUtil(str, beg + len1, len2, s3_len);
        }
        // we do not get s3 in main string
        return false;
    }
    // Returns true if str is sum string, else false.
    boolean isSumStr() {
        int n = str.length();
        // choosing first two numbers and checking whether it is sum-string or not.
        for (int i = 1; i < n; i++)
            for (int j = 1; i + j < n; j++)
                if (checkSumStrUtil(str, 0, i, j))
                    return true;
        return false;
    }

    public static void main(String[] args) {
        CheckIfGivenStringIsSumString stringIsSumString =new CheckIfGivenStringIsSumString("1212243660");
        System.out.println(stringIsSumString.isSumStr());
    }
}

