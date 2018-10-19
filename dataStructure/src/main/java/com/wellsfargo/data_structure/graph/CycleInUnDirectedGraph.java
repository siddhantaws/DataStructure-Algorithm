package com.wellsfargo.data_structure.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class CycleInUnDirectedGraph<K> {

    private DisJointSet<K> disJointSet ;
    private Graph<K> graph;
    private List<Graph.Edge<K>> edgeList;

    public CycleInUnDirectedGraph(Graph<K> graph) {
        this.graph = graph;
        this.edgeList=graph.getAllEdges();
        List<K> kList =new ArrayList<>();
        for(Graph.Vertex<K> vertex :graph.getAllVertices()){
            kList.add(vertex.getData());
        }
        this.disJointSet =new DisJointSet<>(kList);
    }

    public boolean hasContainCycle(){
        for(Graph.Edge<K> kEdge :edgeList){
            if(!disJointSet.union(kEdge.getV1().getData() ,kEdge.getV2().getData()))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Graph<String> graph1=new Graph<>();
        graph1.add("A","B",10);
        graph1.add("B","C",10);
        graph1.add("F","C",10);
        graph1.add("C","D",10);
        graph1.add("F","D",10);
        graph1.add("D","E",10);
        graph1.add("E","A",10);
        CycleInUnDirectedGraph<String> cycleargs = new CycleInUnDirectedGraph<>(graph1);
        System.out.println(cycleargs.hasContainCycle());

    }
}
