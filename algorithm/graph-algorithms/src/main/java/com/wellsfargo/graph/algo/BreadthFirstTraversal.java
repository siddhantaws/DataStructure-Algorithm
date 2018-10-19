package com.wellsfargo.graph.algo;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class BreadthFirstTraversal<K> {

    private Graph<K> graph;

    private Queue<Graph.Vertex> queue;

    private K startingVertex ;

    private List<K> bfsvalues;

    public BreadthFirstTraversal(Graph graph , K startingVertex ) {
        this.graph = graph;
        this.queue =new ArrayDeque<>();
        this.startingVertex =startingVertex;
        this.bfsvalues=new ArrayList<>();
    }

    public List<K> printBFS()
    {
        return  getBFS();
    }

    private List<K> getBFS(){
        queue.add(graph.getVertex(startingVertex));
        queue.peek().setVisited(true);
        while(!queue.isEmpty()){
            bfsvalues.add((K)queue.peek().getData());
            Graph.Vertex vertex =queue.poll();
            addAllAdjVertex(vertex);
        }
        return bfsvalues ;
    }

    private void addAllAdjVertex(Graph.Vertex vertex)
    {
        for(Graph.Vertex vertex1:(List<Graph.Vertex>) vertex.getAdjacentVertexes())
        {
            if(!vertex1.isVisited())
            {
                queue.add(vertex1);
                graph.getVertex((K)vertex1.getData()).setVisited(true);
            }
        }

    }

    public static void main(String[] args) {
        Graph<String> graph =new Graph();
        graph.addEdge("A" , "B" , 10);
        graph.addEdge("B" , "D" , 30);
        graph.addEdge("D" , "F" , 50);
        graph.addEdge("F" , "E" , 60);
        graph.addEdge("E" , "C" , 40);
        graph.addEdge("C" , "A" , 20);
        BreadthFirstTraversal  breadthFirstTraversal =new BreadthFirstTraversal(graph  , "A");
        for(String vertex :(List<String>) breadthFirstTraversal.printBFS())
            System.out.println(vertex);
    }
}
