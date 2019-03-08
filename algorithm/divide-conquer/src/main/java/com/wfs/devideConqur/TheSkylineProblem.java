
package com.wfs.devideConqur;

public class TheSkylineProblem{

    private Building building[];

    public TheSkylineProblem(Building[] building) {
        this.building = building;
    }

    static class Building {
        int left;  // x coordinate of left side
        int ht;    // height
        int right; // x coordinate of right side

        public Building(int left, int ht, int right) {
            this.left = left;
            this.ht = ht;
            this.right = right;
        }
    }

    // A strip in skyline
    static class Strip {
        int left;  // x coordinate of left side
        int ht; // height
        public Strip(){
            this(0,0);
        }
        public Strip(int l, int h) {
            left = l;
            ht = h;
        }
    }

    class SkyLine {
        Strip arr[];   // Array of strips
        int capacity; // Capacity of strip array
        int n;   // Actual number of strips in array

        int count()  { return n;   }
        SkyLine(int cap) {// Constructor
            capacity = cap;
            arr = new Strip[cap];
            n = 0;
        }
        void append(Strip st) {// Function to add a strip 'st' to array
            // Check for redundant strip, a strip is redundant if it has same height or left as previous
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
                System.out.println(" ("+arr[i].left +", "+ arr[i].ht + ")");
            }
        }
    }

    public SkyLine findSkyline(){
        return findSkyline(0 ,building.length -1);
    }

    // This function returns skyline for a given array of buildings  arr[l..h].  This function is similar to mergeSort().
    private SkyLine findSkyline(int l, int h) {
        if (l == h) {
            SkyLine res = new SkyLine(2);
            res.append(new Strip(building[l].left, building[l].ht));
            res.append(new Strip(building[l].right, 0));
            return res;
        }
        int mid = (l + h)/2;
        // Recur for left and right halves and merge the two results
        SkyLine sl = findSkyline( l, mid);
        SkyLine s2 = findSkyline(mid+1, h);
        SkyLine res = merge(sl , s2);
        return res;
    }

    // Similar to merge() in MergeSort  This function merges another skyline 'other' to the skyline
    // for which it is called.  The function returns pointer to  the resultant skyline
    private SkyLine merge(SkyLine s1 ,SkyLine s2  ) {
        // Create a resultant skyline with capacity as sum of two skylines
        SkyLine res = new SkyLine(s1.n + s2.n);
        // To store current heights of two skylines
        int h1 = 0, h2 = 0;
        // Indexes of strips in two skylines
        int i = 0, j = 0;
        while (i < s1.n && j < s2.n) {
            // Compare x coordinates of left sides of two  skylines and put the smaller one in result
            if (s1.arr[i].left < s2.arr[j].left) {
                int x1 = s1.arr[i].left;
                h1 = s1.arr[i].ht;
                // Choose height as max of two heights
                int maxh = Math.max(h1, h2);

                res.append(new Strip(x1, maxh));
                i++;
            }
            else {
                int x2 = s2.arr[j].left;
                h2 = s2.arr[j].ht;
                int maxh = Math.max(h1, h2);
                res.append(new Strip(x2, maxh));
                j++;
            }
        }
        // If there are strips left in this skyline or other  skyline
        while (i < s1.n) {
            res.append(s1.arr[i]);
            i++;
        }
        while (j < s2.n) {
            res.append(s2.arr[j]);
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        Building arr[] = { new Building(1, 11, 5), new Building(2, 6, 7), new Building(3, 13, 9),
                new Building(12, 7, 16),  new Building(14, 3, 25), new Building(19, 18, 22),
                new Building(23, 13, 29), new Building(24, 4, 28)};
        TheSkylineProblem skylineProblem =new TheSkylineProblem(arr);
        skylineProblem.findSkyline().print();
    }
}

