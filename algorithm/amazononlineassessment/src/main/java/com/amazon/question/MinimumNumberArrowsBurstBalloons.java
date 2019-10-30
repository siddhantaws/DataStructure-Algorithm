package com.amazon.question;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberArrowsBurstBalloons {

    private int points[][];

    public MinimumNumberArrowsBurstBalloons(int[][] points) {
        this.points = points;
    }

    public int findMinArrowShots() {
        if (points.length == 0) return 0;

        // sort by x_end
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int arrows = 1;
        int xStart, xEnd, firstEnd = points[0][1];
        for (int[] p : points) {
            xStart = p[0];
            xEnd = p[1];
            // if the current balloon starts after the end of another one,
            // one needs one more arrow
            if (firstEnd < xStart) {
                arrows++;
                firstEnd = xEnd;
            }
        }
        return arrows;
    }

    public static void main(String[] args) {
        MinimumNumberArrowsBurstBalloons balloons =new MinimumNumberArrowsBurstBalloons(new int[][]{{1,5},{2,5},{3,4}});
        System.out.println(balloons.findMinArrowShots());
    }
}
