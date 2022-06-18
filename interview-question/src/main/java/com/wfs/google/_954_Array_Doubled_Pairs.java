package com.wfs.google;

import java.util.HashMap;
import java.util.Map;

public class _954_Array_Doubled_Pairs {
    public static void main(String[] args) {
        System.out.println(canReorderDoubled(new int[]{1,2,4,8}));
    }

    public static boolean canReorderDoubled(int[] A) {
        if (A == null || (A.length % 2 )!= 0)
            return false;
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++)
            map.compute(A[i], (k, v) -> v == null ? 1 : v + 1);
        map.forEach((k, v) -> {
            if (k % 2==0 && map.containsKey(k / 2) && map.get(k / 2)>0) {
                map.put(k ,v-1);
                map.put(k / 2, map.get(k / 2) - 1);
            } else if (map.containsKey(k * 2) && map.get(k * 2)>0) {
                map.put(k ,v-1);
                map.put(k * 2, map.get(k * 2) - 1);
            }
        });
        return map.entrySet().stream().noneMatch(integerIntegerEntry -> integerIntegerEntry.getValue() > 0);
    }
}
