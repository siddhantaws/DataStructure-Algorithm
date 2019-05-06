package com.wfs.range.query;

import java.util.Arrays;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MOAlgorithm {
    private int arr[];
    private final int blockSize;
    private Query[] queues;

    public MOAlgorithm(int[] arr,Query[] queues) {
        this.arr = arr;
        this.blockSize =(int)Math.sqrt(arr.length);
        this.queues=queues;
        Arrays.sort(queues);
    }

    public void process(){
        int l =0;int r =0;int sum =0;
        for(int i =0;i<queues.length-1;i++){
            Query query =queues[i];
            int L =query.l; int R =query.r;

        }

    }


    class Query implements Comparable<Query>{

        private int l ,r ;

        public Query(int l, int r) {
            this.l = l;
            this.r = r;
        }
        @Override
        public int compareTo(Query o) {
            if(this.l/blockSize== o.l/blockSize)
                return this.r/blockSize -  o.r/blockSize;
            return this.l/blockSize -  o.l/blockSize;
        }
    }
}
