package com.wellsfargo.data_structure.graph;

import java.util.*;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class TravellingSalesmanProblem_BackTracking<K,V extends Comparable> {

    private Graph<K, V> graph;

    private Graph.Vertex<K> sourceVertex ;

    private Stack<K> kStack;
    private Set<K> kSet;

    private int totalVertexSize ;

    private static int totalPathSum =Integer.MAX_VALUE;

    public TravellingSalesmanProblem_BackTracking(Graph<K, V> graph) {
        this.graph = graph;
        this.kStack =new Stack<>();
        this.kSet =new HashSet<>();
        this.totalVertexSize =graph.getAllVertices().size();
    }

    public void getAllPath(){
        sourceVertex = graph.getAllVertices().get(0);
        kStack.add(sourceVertex.getData());
        kSet.add(sourceVertex.getData());
        getAllPath(sourceVertex , 0);
        System.out.println("Shottest path "+totalPathSum);
    }

    private void printPath(){
        Enumeration<K> kEnumeration =kStack.elements();
        while(kEnumeration.hasMoreElements()){
            System.out.println( kEnumeration.nextElement());;
        }
    }

    private void getAllPath(Graph.Vertex<K> vertex , int sumPath) {
        if(kStack.size() == totalVertexSize+1 && vertex == sourceVertex) {
            totalPathSum =Math.min( totalPathSum ,sumPath);
            System.out.println(totalPathSum);printPath();
            return;
        }
        for(Graph.Edge<K,V> edge : vertex.getEdges()){
            Graph.Vertex<K> adjVertex ;
            if(edge.getV1() == vertex)
                adjVertex =edge.getV2();
            else
                adjVertex =edge.getV1();
            if( !(kStack.size() == totalVertexSize && adjVertex == sourceVertex )
                    &&   kSet.contains(adjVertex.getData()))
                continue;
            kStack.push(adjVertex.getData());kSet.add(adjVertex.getData());
            getAllPath(adjVertex , sumPath + (Integer) edge.getWeight());
            kStack.pop();kSet.remove(adjVertex.getData());
        }
    }

    public static void main(String[] args) {
        Graph<String ,Integer> graph =new Graph<>();
        graph.add("1","2",10);
        graph.add("1","3",15);
        graph.add("2","3",35);
        graph.add("1","4",20);
        graph.add("2","4",25);
        graph.add("3","4",30);
        TravellingSalesmanProblem_BackTracking<String ,Integer> problem_backTracking =new TravellingSalesmanProblem_BackTracking(graph);
        problem_backTracking.getAllPath();
    }
}
