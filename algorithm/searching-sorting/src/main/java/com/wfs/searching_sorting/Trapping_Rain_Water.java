package com.wfs.searching_sorting;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class Trapping_Rain_Water {
    private int arr[];

    public Trapping_Rain_Water(int[] arr) {
        this.arr = arr;
    }

    public int getRainWater(){
        // initialize output
        int result = 0;

        // maximum element on left and right
        int left_max = 0, right_max = 0;

        // indices to traverse the array
        int lo = 0, hi = arr.length-1;
        while(lo <= hi) {
            if(arr[lo] < arr[hi]) {
                if(arr[lo] > left_max)
                    // update max in left
                    left_max = arr[lo];
                else
                    // water on curr element = max - curr
                    result += left_max - arr[lo];
                lo++;
            }
            else {
                if(arr[hi] > right_max)
                    // update right maximum
                    right_max = arr[hi];
                else
                    result += right_max - arr[hi];
                hi--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[]={0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Trapping_Rain_Water rain_water =new Trapping_Rain_Water(arr);
        System.out.println(rain_water.getRainWater());
    }
}
