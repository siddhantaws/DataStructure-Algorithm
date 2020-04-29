package com.google.question;

public class EncodeStringShortestLength {

    public String encode(String s) {
        int n = s.length();
        String[][] f = new String[n][n];
        for (int l = 1; l <= n; ++l) {
            for (int i = 0; i + l - 1 < n; ++i) {
                int j = i + l - 1;
                f[i][j] = s.substring(i, j + 1);
                for (int k = i; k < j; ++k) {
                    if (f[i][k].length() + f[k + 1][j].length() < f[i][j].length()) {
                        f[i][j] = f[i][k] + f[k + 1][j];
                    }
                }
                String now = s.substring(i, j + 1);
                int idx = (now + now).indexOf(now, 1);
                if (idx < now.length()) {
                    now = String.valueOf(now.length() / idx) + "[" + f[i][i + idx - 1] + "]";
                }
                if (now.length() < f[i][j].length()) {
                    f[i][j] = now;
                }
            }
        }
        return f[0][n - 1];
    }

    public static void main(String[] args) {
        EncodeStringShortestLength shortestLength =new EncodeStringShortestLength();
        System.out.println(shortestLength.encode("aabcaabcd"));
    }
}
