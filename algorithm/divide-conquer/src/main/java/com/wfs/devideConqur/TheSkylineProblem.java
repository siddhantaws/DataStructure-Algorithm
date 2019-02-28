/*
package com.wfs.devideConqur;

public class TheSkylineProblem{

    static class Building{
        int left;  // x coordinate of left side
        int ht;    // height
        int right; // x coordinate of right side
    }

    class Strip {// A strip in skyline
        int left;  // x coordinate of left side
        int ht; // height
        public Strip(int l, int h) {
            left = l;
            ht = h;
        }

    }

    class SkyLine {// Skyline:  To represent Output (An array of strips)
        Strip arr[];   // Array of strips
        int capacity; // Capacity of strip array
        int n;   // Actual number of strips in array

        int count()  { return n;   }

        // A function to merge another skyline to this skyline

        SkyLine(int cap) {// Constructor
            capacity = cap;
            arr = new Strip[cap];
            n = 0;
        }

        void append(Strip st) {// Function to add a strip 'st' to array
            // Check for redundant strip, a strip is
            // redundant if it has same height or left as previous
            if (n>0 && arr[n-1].ht == st.ht)
                return;
            if (n>0 && arr[n-1].left == st.left) {
                arr[n-1].ht = Math.max(arr[n-1].ht, st.ht);
                return;
            }
            arr[n] = st;
            n++;
        }
        void print() {// A utility function to print all strips of skyline
            for (int i=0; i<n; i++) {
                System.out.println("("+ arr[i].left +","+ arr[i].ht + ")");
            }
        }
    }

    // Similar to merge() in MergeSort  This function merges another skyline 'other' to the skyline
// for which it is called.  The function returns pointer to the resultant skyline
    SkyLine SkyLine merge(SkyLine other) {
        // Create a resultant skyline with capacity as sum of two
        // skylines
        SkyLine res = new SkyLine(this.n + other.n);

        // To store current heights of two skylines
        int h1 = 0, h2 = 0;

        // Indexes of strips in two skylines
        int i = 0, j = 0;
        while (i < this->n && j < other->n)
        {
            // Compare x coordinates of left sides of two
            // skylines and put the smaller one in result
            if (this->arr[i].left < other->arr[j].left)
            {
                int x1 = this->arr[i].left;
                h1 = this->arr[i].ht;

                // Choose height as max of two heights
                int maxh = max(h1, h2);

                res->append(new Strip(x1, maxh));
                i++;
            }
        else
            {
                int x2 = other->arr[j].left;
                h2 = other->arr[j].ht;
                int maxh = max(h1, h2);
                res->append(new Strip(x2, maxh));
                j++;
            }
        }

        // If there are strips left in this skyline or other
        // skyline
        while (i < this->n)
        {
            res->append(&arr[i]);
            i++;
        }
        while (j < other->n)
        {
            res->append(&other->arr[j]);
            j++;
        }
        return res;
    }
}
*/
