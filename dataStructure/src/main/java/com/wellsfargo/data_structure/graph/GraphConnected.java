package com.wellsfargo.data_structure.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class GraphConnected<K,V extends Comparable> {

    private Graph<K,V> graph;

    private Set<K> totalVertex ;

    public GraphConnected(Graph<K,V> graph) {
        this.graph = graph;
        this.totalVertex =new HashSet<>();
        for(Graph.Vertex<K> vertex :graph.getAllVertices())
            totalVertex.add(vertex.getData());
    }

    public boolean isConnected(){
        dfs(graph.getAllVertices().get(0).getData());
        return totalVertex.size() == 0;
    }

    private void dfs(K source){
          for(Graph.Vertex<K> vertex: graph.getVertex(source).getAdjecentVertex()){
              if(totalVertex.contains(vertex.getData())){
                  totalVertex.remove(vertex.getData());
                  dfs(vertex.getData());
              }
          }
    }

    public static void main(String[] args) {
        Graph<String,Integer> graph =new Graph<>();
        graph.add("A","B",10);
        graph.add("B","C",10);
        graph.add("C","D",10);
        graph.add("D","E",10);
        graph.add("D","F",10);
        /*graph.add("E","C",10);
        graph.add("C","A",10);*/
        GraphConnected<String,Integer> stringGraphConnected =new GraphConnected(graph);
        System.out.println(stringGraphConnected.isConnected());
    }
}
