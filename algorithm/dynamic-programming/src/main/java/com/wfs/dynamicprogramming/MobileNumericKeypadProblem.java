package com.wfs.dynamicprogramming;

public class MobileNumericKeypadProblem {

    private int[][] keyPad;

    private int key;

    private int row[];
    private int count[][];
    private int col[];

    public MobileNumericKeypadProblem(int[][] keyPad, int key) {
        this.keyPad = keyPad;
        this.key = key;
        // left, up, right, down move from current location
        this.row = new int[]{0, 0, -1, 0, 1};
        this.col = new int[]{0, -1, 0, 1, 0};
        this.count = new int[10][key + 1];
        for (int i = 0; i <= 9; i++) {
            count[i][0] = 0;
            count[i][1] = 1;
        }
        System.out.println(1);
    }

    public int count() {

        int i = 0, j = 0, k = 0, move = 0, ro = 0, co = 0, num = 0;
        int nextNum = 0, totalCount = 0;

        // Bottom up - Get number count of length 2, 3, 4, ... , n
        for (k = 2; k <= key; k++) {
            for (i = 0; i < 4; i++)  // Loop on keypad row
            {
                for (j = 0; j < 3; j++)   // Loop on keypad column
                {
                    // Process for 0 to 9 digits
                    if (keyPad[i][j] != -1) {
                        // Here we are counting the numbers starting with
                        // digit keypad[i][j] and of length k keypad[i][j]
                        // will become 1st digit, and we need to look for
                        // (k-1) more digits
                        num = keyPad[i][j] - 0;
                        count[num][k] = 0;

                        // move left, up, right, down from current location
                        // and if new location is valid, then get number
                        // count of length (k-1) from that new digit and
                        // add in count we found so far
                        for (move = 0; move < 5; move++) {
                            ro = i + row[move];
                            co = j + col[move];
                            if (ro >= 0 && ro <= 3 && co >= 0 && co <= 2 &&
                                    keyPad[ro][co] != -1) {
                                nextNum = keyPad[ro][co] - 0;
                                count[num][k] += count[nextNum][k - 1];
                            }
                        }
                    }
                }
            }
        }
        // Get count of all possible numbers of length "n" starting
        // with digit 0, 1, 2, ..., 9
        totalCount = 0;
        for (i=0; i<=9; i++)
            totalCount += count[i][key];
        return totalCount;
    }

    public static void main(String[] args) {
        int keypad[][] = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -1}};
        MobileNumericKeypadProblem mobileNumericKeypadProblem = new MobileNumericKeypadProblem(keypad, 2);
        System.out.println(mobileNumericKeypadProblem.count());
    }


}
