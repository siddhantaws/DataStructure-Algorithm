package com.wfs.amazon.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _1051HeightChecker {
    private int heights[];

    public _1051HeightChecker(int[] heights) {
        this.heights = heights;
    }
    public int heightChecker() {
        Height []point =new Height[heights.length];
        for(int i=0;i<heights.length;i++)
            point[i]= new Height(heights[i],i);

        Arrays.sort(point);
        Set<Integer> setsOfVisitedPoints=new HashSet<>();

        int maxRotationCount =0;
        for(int i=0;i<point.length;i++){
            if(point[i].index==i){
                setsOfVisitedPoints.add(i);
                continue;
            }else{
                int k = i;
                while( !setsOfVisitedPoints.contains(k) ){
                    maxRotationCount++;
                    setsOfVisitedPoints.add(k);
                    k=point[k].index;
                }
            }
        }
        return maxRotationCount;
    }

    public static void main(String[] args) {
        _1051HeightChecker checker =new _1051HeightChecker(new int[]{1,1,4,2,1,3});
        System.out.println(checker.heightChecker());
    }
    class Height implements Comparable<Height>{
        int height ;
        int index ;

        public Height(int height, int index) {
            this.height = height;
            this.index = index;
        }

        @Override
        public int compareTo(Height o) {
            return this.height-o.height;
        }
    }
}
