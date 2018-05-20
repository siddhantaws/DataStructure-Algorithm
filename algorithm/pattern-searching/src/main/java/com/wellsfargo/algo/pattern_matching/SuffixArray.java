package com.wellsfargo.algo.pattern_matching;

import java.util.*;

public class SuffixArray {

    private String suffix;
    private List<Suffix> suffixArray;

    public SuffixArray(String suffix) {
        this.suffix = suffix;
        this.suffixArray =new ArrayList<>();
        for(int i=0;i<suffix.toCharArray().length;i++){
            this.suffixArray.add( new Suffix());
        }
    }

    class Suffix {
        private int index; // To store original index
        private int rank[] =new int[2];// To store ranks and next rank pair

        @Override
        public String toString() {
            return suffix.substring(index);
        }
    }
    static class SuffixComparator implements Comparator<Suffix>{
        @Override
        public int compare(Suffix a, Suffix b) {
            if(a.rank[0] == b.rank[0])
            {
                return ((Integer)a.rank[1]).compareTo(b.rank[1]);
            }else
            {
                return ((Integer)a.rank[0]).compareTo(b.rank[0]);
            }
        }
    }

    public void buildSuffixArray(){
        buildSuffixArray(suffix , suffix.length()-1);
    }

    private void buildSuffixArray(String suffix , int n){
        char ch[] =suffix.toCharArray();

        // Store suffixes and their indexes in an array of structures.
        // The structure is needed to sort the suffixes alphabatically
        // and maintain their old indexes while sorting

        for (int i = 0; i <=n; i++)
        {
            suffixArray.get(i).index = i;
            suffixArray.get(i).rank[0] = ch[i] - 'a';
            suffixArray.get(i).rank[1] = ((i + 1) < n)? (ch[i + 1] - 'a'): -1;
        }
        // Sort the suffixes using the comparison function
        // defined above.
        Collections.sort(suffixArray , new SuffixComparator());

        // At his point, all suffixes are sorted according to first
        // 2 characters.  Let us sort suffixes according to first 4
        // characters, then first 8 and so on
        int ind[] =new int[n];  // This array is needed to get the index in suffixes[]
        // from original index.  This mapping is needed to get
        // next suffix.

        for (int k = 4; k < 2*n; k = k*2) {
            // Assigning rank and index values to first suffix
            int rank = 0;
            Suffix suffix1 =suffixArray.get(0);
            int prev_rank = suffix1.rank[0];
            suffix1.rank[0] = rank;
            ind[suffix1.index-1] = 0;

            // Assigning rank to suffixes
            for (int i = 1; i < n; i++)
            {
                // If first rank and next ranks are same as that of previous
                // suffix in array, assign the same new rank to this suffix
                Suffix suffix2 = suffixArray.get(i);
                Suffix suffix3 = suffixArray.get(i-1);
                if (suffix2.rank[0] == prev_rank &&
                        suffix2.rank[1] == suffix3.rank[1])
                {
                    prev_rank = suffix2.rank[0];
                    suffix2.rank[0] = rank;
                }
                else // Otherwise increment rank and assign
                {
                    prev_rank = suffix2.rank[0];
                    suffix2.rank[0] = ++rank;
                }
                ind[suffix2.index] = i;
            }

            // Assign next rank to every suffix
            for (int i = 0; i < n; i++)
            {
                Suffix suffix2 = suffixArray.get(i);
                int nextindex = suffix2.index + k/2;
                suffix2.rank[1] = (nextindex < n)?
                        suffixArray.get(ind[nextindex]).rank[0]: -1;
            }
            Collections.sort(suffixArray , new SuffixComparator());
        }
        printArr();
    }

    void printArr()
    {
        char ch[]=suffix.toCharArray();
        for(Suffix sd: suffixArray){
            System.out.println(sd);
        }
    }

    public static void main(String[] args) {
        SuffixArray  suffixArray1 =new SuffixArray("banana");
        suffixArray1.buildSuffixArray();
    }
}
