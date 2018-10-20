package com.wellsfargo.data_structure.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class CycleInDirectedGraph<K,V extends Comparable> {

    private Graph<K,V> graph;

    private Map<Graph.Vertex<K>, Graph.Vertex<K>> startSet  , whiteSet , graySet;

    public CycleInDirectedGraph(Graph<K,V> graph) {
        this.graph = graph;
        this.startSet =new ConcurrentHashMap<>();
        this.whiteSet = new ConcurrentHashMap<>();
        this.graySet =new ConcurrentHashMap<>();
        for(Graph.Vertex<K> vertex :graph.getAllVertices())
            startSet.put(vertex,vertex );
    }

    public boolean hasContainCycle(){
        for(Map.Entry<Graph.Vertex<K> ,Graph.Vertex<K>> vertex: startSet.entrySet()) {
            Graph.Vertex<K> vertex1 =vertex.getKey();
            startSet.remove(vertex1);
            if(!whiteSet.containsKey(vertex1)){
                whiteSet.put(vertex1, vertex1);
                if(dfs(vertex1))
                    return true;
            }
        }
        return false;
    }

    private  boolean dfs(Graph.Vertex<K> vertex) {
        for(Graph.Vertex<K> vertex1: vertex.getAdjecentVertex()){
            if(whiteSet.containsKey(vertex1))
                return true;
            whiteSet.put(vertex1, vertex1);
             if (dfs(vertex1))
                 return true;
        }
        whiteSet.remove(vertex);
        graySet.put(vertex, vertex);
        return false;
    }

    public static void main(String[] args) {
        Graph<String,Integer> graph1=new Graph<>(true);
        graph1.add("A","B",10);
        graph1.add("B","C",10);
        graph1.add("F","C",10);
        graph1.add("C","D",10);
        graph1.add("F","D",10);
        graph1.add("D","E",10);
        graph1.add("E","A",10);
        CycleInDirectedGraph<String,Integer> cycle=new CycleInDirectedGraph(graph1);
        System.out.println(cycle.hasContainCycle());
    }
}
