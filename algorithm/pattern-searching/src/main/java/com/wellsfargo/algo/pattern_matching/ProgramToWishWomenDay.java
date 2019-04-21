package com.wellsfargo.algo.pattern_matching;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class ProgramToWishWomenDay {
    public static void main (String[] args) {
        // Initializing size of design
        int n = 5;
        // Loop to print Circle (Upper part of design) Outer loop to
        // control height of design
        for (int i = 0; i <= 2 * n; i++) {
            // Inner loop to control width
            for (int j = 0; j <= 2 * n; j++) {
                // computing distance of each point from center
                float center_dist =(float) Math.sqrt((i - n) * (i - n) +    (j - n) * (j - n));
                if (center_dist < n + 0.4)
                    System.out.print("$");
                else
                    System.out.print(" ");
            }

            // Printing HappY Women's DaY
            if (i == n)
                System.out.print(" " + "HappY Women's DaY");
            System.out.println();
        }

        // Loop to print lower part Outer loop to control height
        for (int i = 0; i <= n; i++) {
            // Positioning pattern Loop for Printing horizontal line
            if (i == (n / 2) + 1) {
                for (int j = 0; j <= 2 * n; j++)
                    if (j >= (n - n / 2) && j <= (n + n / 2))
                        System.out.print("$");
                    else
                        System.out.print(" ");
            }
            else {
                for (int j = 0; j <= 2 * n; j++) {
                    if (j == n)
                        System.out.print("$");
                    else
                        System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
