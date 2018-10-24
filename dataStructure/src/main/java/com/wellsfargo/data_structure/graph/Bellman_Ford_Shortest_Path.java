package com.wellsfargo.data_structure.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class Bellman_Ford_Shortest_Path<K, V extends Comparable> {

    private Graph<K, V> graph;

    private Map<K, DistanceAndSource<K, V>> map;

    public Bellman_Ford_Shortest_Path(Graph<K, V> graph) {
        this.graph = graph;
        this.map = new HashMap<>();
        boolean flag = true;
        for (K k : graph.getVertices()) {
            if (flag) {
                map.put(k, new DistanceAndSource(null, 0));
                flag = false;
            }
            map.put(k, new DistanceAndSource(null, Integer.MAX_VALUE));
        }
    }

    public void constructShottestpath(){
        for(int i=0;i<graph.getVertices().size()-2;i++){
            for(Graph.Edge<K,V> edge :graph.getAllEdges()){
                if(map.get(edge.getV1().getData()).v.compareTo(Integer.MAX_VALUE ) ==0 &&  map.get(edge.getV2   ().getData()).v.compareTo(Integer.MAX_VALUE ) ==0)
                    continue;
                if(map.get(edge.getV2   ().getData()).v.compareTo((Comparable)((Integer)map.get(edge.getV1().getData()).v +(Integer)edge.getWeight())) > 0)
                    map.get(edge.getV2   ().getData()).v =((V)(Object)((Integer)map.get(edge.getV1().getData()).v +(Integer)edge.getWeight()));
            }
        }
    }


    public static void main(String[] args) {

    }

    static class DistanceAndSource<K, V> {
        K k;
        V v;

        public DistanceAndSource(K k, V v) {
            this.k = k;
            this.v = v;
        }

    }
}
