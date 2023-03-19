package com.google.question;

import java.util.*;

public class _2242MaximumScoreNodeSequence {

    public int maximumScore(int[] scores, int[][] edges) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for(int i =0; i< scores.length;i++) {
            map.put(i,new ArrayList<Integer>());
        }
        for(int i =0; i< edges.length;i++) {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i =0; i< scores.length;i++) {
            Collections.sort(map.get(i), new Comparator<Integer>(){
                public int compare(Integer a, Integer b) {
                    return(scores[b] - scores[a]);
                }
            });
        }
        int ans = -1;
        for(int i=0;i<edges.length;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int least = scores[u] + scores[v];
            for(int j=0;j< Math.min(3, map.get(u).size());j++) {
                int x = map.get(u).get(j);
                if(x == v) continue;
                for(int k=0;k< Math.min(3, map.get(v).size());k++) {
                    int y = map.get(v).get(k);
                    if(y == u || y == x) continue;
                    ans = Math.max(ans, least+scores[x]+scores[y]);
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _2242MaximumScoreNodeSequence sequence =new _2242MaximumScoreNodeSequence();
        System.out.println(sequence.maximumScore(new int[]{5,2,9,8,4} , new int[][] {{0,1}, {1,2},{2,3},{0,2},{1,3},{2,4}}));
    }
}
