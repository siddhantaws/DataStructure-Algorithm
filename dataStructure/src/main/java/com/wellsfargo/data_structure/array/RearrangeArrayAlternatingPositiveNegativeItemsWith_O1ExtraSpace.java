package com.wellsfargo.data_structure.array;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class RearrangeArrayAlternatingPositiveNegativeItemsWith_O1ExtraSpace {
    private int arr[];

    public RearrangeArrayAlternatingPositiveNegativeItemsWith_O1ExtraSpace(int[] arr) {
        this.arr = arr;
    }

    public void rearrange(){
        int outofplace = -1;
        for (int index = 0; index < arr.length-1; index++)
        {
            if (outofplace >= 0)
            {
                // find the item which must be moved into the out-of-place entry if out-of-place entry is positive and current
                // entry is negative OR if out-of-place entry is negative and current entry is negative then right rotate
                // [...-3, -4, -5, 6...] -->   [...6, -3, -4, -5...]
                //      ^                          ^
                //     outofplace      -->      outofplace
                if (((arr[index] >= 0) && (arr[outofplace] < 0))
                        || ((arr[index] < 0) && (arr[outofplace] >= 0))) {
                    rightrotate(arr, arr.length-1, outofplace, index);
                    // the new out-of-place entry is now 2 steps ahead
                    if (index - outofplace > 2)
                        outofplace = outofplace + 2;
                    else
                        outofplace = -1;
                }
            }
            // if no entry has been flagged out-of-place
            if (outofplace == -1) {// check if current entry is out-of-place
                if (((arr[index] >= 0) && ((index & 0x01)==0))
                        || ((arr[index] < 0) && (index & 0x01)==1))
                    outofplace = index;
            }
        }
    }

    void rightrotate(int arr[], int n, int outofplace, int cur) {
        int tmp = arr[cur];
        for (int i = cur; i > outofplace; i--)
            arr[i] = arr[i - 1];
        arr[outofplace] = tmp;
    }
}
