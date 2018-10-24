package com.wellsfargo.data_structure.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class TravellingSalesmanProblem_MinimumSpanningTree<K,V extends Comparable> {

    private Graph<K,V> graph;

    private MinimumSpanningTree_Prims<K,V> minimumSpanningTree_prims ;

    private List<Graph.Edge<K,V>> edgeList ;

    private K sourceVertex ;

    private List<Graph.Edge<K,V>> edges;

    public TravellingSalesmanProblem_MinimumSpanningTree(Graph<K, V> graph , K sourceVertex) {
        this.graph = graph;
        this.sourceVertex =sourceVertex;
        this.minimumSpanningTree_prims=new MinimumSpanningTree_Prims<>(graph);
        this.edgeList = minimumSpanningTree_prims.getMinimumSpanningTree();
        this.edges =new ArrayList<>();
    }

    public void getPath() {
        Graph.Edge<K,V> edge =null;
        for( Graph.Edge<K,V> kvEdge:edgeList){
            edge= kvEdge;
            if(kvEdge.getV1().getData().equals(sourceVertex))
                break;
        }
        
    }
}
