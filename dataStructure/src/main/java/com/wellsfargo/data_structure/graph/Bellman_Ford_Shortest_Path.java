package com.wellsfargo.data_structure.graph;

import java.util.Map;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class Bellman_Ford_Shortest_Path<K,V extends  Comparable>  {

    private Graph<K,V> graph;

    private Map<K ,DistanceAndSource<K,V>> map;




    static class DistanceAndSource<K , V>{
        K k;
        V v;

        public DistanceAndSource(K k , V v)  {
            this.k = k;
            this.v=v;
        }

    }
}
