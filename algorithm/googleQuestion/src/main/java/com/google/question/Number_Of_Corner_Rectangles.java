package com.google.question;

import java.util.HashMap;
import java.util.Map;

public class Number_Of_Corner_Rectangles {

    private int[][] grid;

    public Number_Of_Corner_Rectangles(int[][] grid) {
        this.grid = grid;
    }

    public int countCornerRectangles() {
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int[] row : grid) {
            for (int c1 = 0; c1 < row.length; ++c1)
                if (row[c1] == 1) {
                    for (int c2 = c1 + 1; c2 < row.length; ++c2)
                        if (row[c2] == 1) {
                            int pos = c1 * 200 + c2;
                            int c = count.getOrDefault(pos, 0);
                            ans += c;
                            count.put(pos, c + 1);
                        }
                }
        }
        return ans;
    }

    public static void main(String[] args) {
        Number_Of_Corner_Rectangles number = new Number_Of_Corner_Rectangles(new int[][]{
                {1, 1},
                {1, 1}});
        System.out.println(number.countCornerRectangles());
    }
}
