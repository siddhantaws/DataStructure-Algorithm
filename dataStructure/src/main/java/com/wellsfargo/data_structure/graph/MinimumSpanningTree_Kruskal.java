package com.wellsfargo.data_structure.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class MinimumSpanningTree_Kruskal<K,V extends Comparable> {
    private Graph<K,V> graph;

    private DisJointSet<K> disJointSet;

    private PriorityQueue<Graph.Edge<K,V>> edges;

    private List<Graph.Edge<K,V>> edgeList;

    public MinimumSpanningTree_Kruskal(Graph<K,V> graph) {
        this.graph = graph;
        this.disJointSet =new DisJointSet(graph.getVertices());
        this.edgeList =new ArrayList<>();
        this.edges=new PriorityQueue<>(new Comparator<Graph.Edge<K,V>>() {
            @Override
            public int compare(Graph.Edge<K,V> o1, Graph.Edge<K,V> o2) {
                return o1.getWeight().compareTo(o2.getWeight()) ;
            }
        });
        for(Graph.Edge<K,V> edge : graph.getAllEdges()){
            edges.add(edge);
        }
    }

    public List<Graph.Edge<K,V>> getMinimumSpanningTree(){
        while(!edges.isEmpty()){
            Graph.Edge<K,V> kEdge = edges.poll();
            if(disJointSet.union(kEdge.getV1().getData(),kEdge.getV2().getData() ))
                edgeList.add(kEdge);
        }
        return edgeList;
    }

    public static void main(String[] args) {
        Graph<String,Integer> graph =new Graph<>();
        graph.add("A","D",1);graph.add("A","B",3);graph.add("B","D",3);graph.add("B","C",1);
        graph.add("D","C",1);graph.add("C","F",4);graph.add("D","E",6);graph.add("C","E",5);
        graph.add("E","F",2);
        MinimumSpanningTree_Kruskal<String,Integer> spanningTree_prims =new MinimumSpanningTree_Kruskal<>(graph);
        for(Graph.Edge<String,Integer> edge :spanningTree_prims.getMinimumSpanningTree())
            System.out.println(edge.getV1().getData() +"----"+edge.getV2().getData());
    }

}
