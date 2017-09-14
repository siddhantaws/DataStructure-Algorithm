package com.wellsfargo.graph.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch<K> {

    private Graph<K> graph;

    private Stack<Graph.Vertex> stack;

    private K startingVertex ;

    private List<K> dfsvalues;

    public DepthFirstSearch(Graph graph , K startingVertex ) {

        this.graph = graph;
        this.stack =new Stack<>();
        this.startingVertex =startingVertex;
        this.dfsvalues=new ArrayList<>();
    }

    public List<String> printDFS()
    {
        return  getDFS();
    }

    private List getDFS()
    {
        stack.push(graph.getVertex(startingVertex));
        stack.peek().setVisited(true);
        while(!stack.isEmpty())
        {
            dfsvalues.add((K)stack.peek().getData());
            Graph.Vertex vertex =stack.pop();
            Graph.Vertex nextVertex ;
            if((nextVertex =getNextAdjVertex(vertex))!=null )
                stack.push(nextVertex);
        }
        return dfsvalues ;
    }

    private Graph.Vertex getNextAdjVertex(Graph.Vertex vertex)
    {
        for(Graph.Vertex vertex1:(List<Graph.Vertex>) vertex.getAdjacentVertexes())
        {
            if(!vertex1.isVisited())
                return  vertex1;
        }
        return null;
    }

    public static void main(String[] args) {
        Graph<String> graph =new Graph();
        graph.addEdge("A" , "B" , 10);
        graph.addEdge("B" , "D" , 30);
        graph.addEdge("D" , "F" , 50);
        graph.addEdge("F" , "E" , 60);
        graph.addEdge("E" , "C" , 40);
        graph.addEdge("C" , "A" , 20);

        DepthFirstSearch<String> stringDepthFirstSearch=new DepthFirstSearch<>(graph , "A");
        for(String vertex: stringDepthFirstSearch.printDFS())
            System.out.println(vertex);
    }
}
