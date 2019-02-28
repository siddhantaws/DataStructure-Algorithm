package com.wfs.devideConqur;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class SearchElementInSpirallySortedMatrix {

    private int arr[][];
    private int n ;

    public SearchElementInSpirallySortedMatrix(int[][] arr) {
        this.arr = arr;
        this.n=arr.length;
    }
    // Function to return the ring,the number x belongs to.
    private int findRing(int x) {
        // Returns -1 if number x is smaller than least element of arr
        if (arr[0][0] > x)
            return -1;
        // l and r represent the diagonal elements to search in
        int l = 0, r = (n + 1) / 2 - 1;
        // Returns -1 if number x is greater than the largest element of arr
        if (n % 2 == 1 && arr[r][r] < x)
            return -1;
        if (n % 2 == 0 && arr[r + 1][r] < x)
            return -1;
        while (l < r)
        {
            int mid = (l + r) / 2;
            if (arr[mid][mid] <= x)
                if (mid == (n + 1) / 2 - 1 || arr[mid + 1][mid + 1] > x)
                    return mid;
                else
                    l = mid + 1;
            else
                r = mid - 1;
        }
        return r;
    }

    // Function to perform binary search on an array sorted in increasing order
    // l and r represent the left and right index of the row to be searched
    private int binarySearchRowInc(int row, int l, int r, int x) {
        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[row][mid] == x)
                return mid;

            if (arr[row][mid] < x)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    // Function to perform binary search on a particlar column of the 2D array
    // t and b represent top and   bottom rows
    private int binarySearchColumnInc(int col, int t, int b, int x){
        while (t <= b) {
            int mid = (t + b) / 2;
            if (arr[mid][col] == x)
                return mid;
            if (arr[mid][col] < x)
                t = mid + 1;
            else
                b = mid - 1;
        }
        return -1;
    }

    // Function to perform binary search on an array sorted in decreasing order
    private int binarySearchRowDec( int row, int l, int r, int x){
        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[row][mid] == x)
                return mid;

            if (arr[row][mid] < x)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    // Function to perform binary search on a particlar column of the 2D array
    private int binarySearchColumnDec(int col, int t, int b, int x) {
        while (t <= b) {
            int mid = (t + b) / 2;
            if (arr[mid][col] == x)
                return mid;
            if (arr[mid][col] < x)
                b = mid - 1;
            else
                t = mid + 1;
        }
        return -1;
    }

    // Function to find the position of the number x
    public  void spiralBinary(int x) {
        // Finding the ring
        int f1 = findRing( x);
        // To store row and column
        int r, c;
        if (f1 == -1) {
            System.out.print("-1");
            return;
        }
        // Edge case if n is odd
        if (n % 2 == 1 && f1 == (n + 1) / 2 - 1) {
            System.out.println(f1+" "+f1);
            return;
        }
        // Check which of the 4 sides, the number x lies in
        if (x < arr[f1][n - f1 - 1]) {
            c = binarySearchRowInc(f1, f1,n - f1 - 2, x);
            r = f1;
        }
        else if (x < arr[n - f1 - 1][n - f1 - 1]) {
            c = n - f1 - 1;
            r = binarySearchColumnInc(n - f1 - 1, f1, n - f1 - 2, x);
        }
        else if (x < arr[n - f1 - 1][f1]) {
            c = binarySearchRowDec(n - f1 - 1, f1 + 1, n - f1 - 1, x);
            r = n - f1 - 1;
        }
        else {
            r = binarySearchColumnDec( f1, f1 + 1, n - f1 - 1, x);
            c = f1;
        }
        // Printing the position
        if (c == -1 || r == -1)
            System.out.print("-1");
        else
            System.out.print(r+" "+c);
        return;
    }

    public static void main(String[] args) {
        int arr[][] =  {{ 1,  2,  3,  4 },
                        { 12, 13, 14, 5 },
                        { 11, 16, 15, 6 },
                        { 10, 9,  8,  7 }};
        SearchElementInSpirallySortedMatrix element =new SearchElementInSpirallySortedMatrix(arr);
        System.out.println(element.findRing(7));
    }
}
