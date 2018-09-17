package com.wellsfargo.data_structure.array;

public class MajorityElement {

    private int arr[];

    public MajorityElement(int[] arr) {
        this.arr = arr;
    }

    private int findCandidate()
    {
        int maj_index = 0, count = 1;
        int i;
        for (i = 1; i < arr.length-1; i++)
        {
            if (arr[maj_index] == arr[i])
                count++;
            else
                count--;
            if (count == 0)
            {
                maj_index = i;
                count = 1;
            }
        }
        return arr[maj_index];
    }

    private boolean isMajority(int cand)
    {
        int i, count = 0;
        for (i = 0; i < arr.length; i++)
        {
            if (arr[i] == cand)
                count++;
        }
        if (count > arr.length / 2)
            return true;
        else
            return false;
    }

    public void printMajority()
    {
        /* Find the candidate for Majority*/
        int cand = findCandidate();

        /* Print the candidate if it is Majority*/
        if (isMajority(cand))
            System.out.println(" " + cand + " ");
        else
            System.out.println("No Majority Element");
    }

    public static void main(String[] args) {
        MajorityElement  majorityElement =new MajorityElement(new int[]{2,3,5,4,2,2,2});
        majorityElement.printMajority();
    }
}
