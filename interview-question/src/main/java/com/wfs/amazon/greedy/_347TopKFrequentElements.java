package com.wfs.amazon.greedy;

import java.util.HashMap;
import java.util.Map;

public class _347TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mapOfElementTOCount  =new HashMap();
        for(int num :nums)
            mapOfElementTOCount.compute(num , (key,v)-> (key==null) ? 1 : v+1);
        int arr[][] =new int[mapOfElementTOCount.size()][2];
        
    }
}
