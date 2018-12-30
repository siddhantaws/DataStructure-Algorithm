package com.wellsfargo.algo.mathematics;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class DrawCircleWithoutFloatingPointArithmetic {
    private int r;

    public DrawCircleWithoutFloatingPointArithmetic(int r) {
        this.r = r;
    }

    public void draw(){

        // Consider a rectangle of size N*N
        int N = 2*r+1;

        // Coordinates inside the rectangle
        int x, y;
        // Draw a square of size N*N.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // Start from the left most corner point
                x = i-r;
                y = j-r;
                // If this point is inside the circle, print it
                if (x*x + y*y <= r*r+1 )
                    System.out.print(".");
                else
                    // If outside the circle, print space
                    System.out.print(" ");
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DrawCircleWithoutFloatingPointArithmetic floatingPointArithmetic =new DrawCircleWithoutFloatingPointArithmetic(8);
        floatingPointArithmetic.draw();
    }
}
