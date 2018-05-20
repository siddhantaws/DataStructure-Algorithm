package com.wellsfargo.algo.backtracking;

import com.wellsfargo.graph.algo.Graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindifThereIsPathOfMoreThanKLengthFromSource {

    private Graph<String> graph;

    private int K;

    private Set<String> paths;

    public FindifThereIsPathOfMoreThanKLengthFromSource(Graph<String> graph , int K) {
        this.graph = graph;
        this.paths = new HashSet<>();
        this.K= K;
    }

    public boolean isPathExistMoreThanK(){
        return isPathExistMoreThanK("0" ,K );
    }

    private boolean isPathExistMoreThanK(String v , int k){
        if(k<0)
            return false;

        if(k>K)
            return true;

        /*for(Graph.Edge<String> edges : graph.getVertex(v).getEdges()){
            if();
            String newV = vertexAdc.toString();
            Integer weight = vertexAdc.getDegree();
            if(paths.contains(newV))
                continue;

            paths.add(newV);
        }*/
        return  false;
    }

    public static void main(String[] args) {
        Graph<String> graph =new Graph<>();
        graph.addEdge("0", "1", 4);
        graph.addEdge("0", "7", 8);
        graph.addEdge("1", "2", 8);
        graph.addEdge("1", "7", 11);
        graph.addEdge("2"," 3", 7);
        graph.addEdge("2", "8", 2);
        graph.addEdge("2", "5", 4);
        graph.addEdge("3","4", 9);
        graph.addEdge("3", "5", 14);
        graph.addEdge("4", "5", 10);
        graph.addEdge("5"," 6", 2);
        graph.addEdge("6", "7", 1);
        graph.addEdge("6", "8", 6);
        graph.addEdge("7", "8", 7);
    }
}
