package com.wellsfargo.graph.algo;

import java.util.Iterator;
import java.util.List;

public class CycleUndirectedGraphUsingDisjointSet<T> {
    private Graph<T> graph;
    private DisjointSet<T> tDisjointSet;

    public CycleUndirectedGraphUsingDisjointSet(Graph<T> graph) {
        this.graph = graph;
        this.tDisjointSet= new DisjointSet<>();
    }

    public boolean hasCycle()
    {
        return  hasCycle(graph);
    }

    private boolean hasCycle(Graph<T> graph)
    {
        Iterator<Graph.Vertex<T>> vertex = graph.getAllVertex().iterator();
        while (vertex.hasNext())
        {
            Graph.Vertex<T> vertex1= vertex.next();
            tDisjointSet.makeSet(vertex1.getData());
        }
        for(Graph.Edge<T> edge : graph.getAllEdges())
        {
            T data1 = tDisjointSet.findSet(edge.getVertex1().getData()) ;
            T data2 = tDisjointSet.findSet(edge.getVertex2().getData()) ;
            if(data1.equals(data2))
                return true;
            tDisjointSet.union(data1 , data2);
        }
        return false;
    }

    public static void main(String[] args) {

        Graph<String> graph = new Graph<String>(false);
        graph.addEdge("A" , "B" , 10);
        graph.addEdge("B" , "C" , 20);
        graph.addEdge("C" , "D" , 30);
        graph.addEdge("D" , "E" , 20);
        graph.addEdge("E" , "F" , 10);
        graph.addEdge("F" , "C" , 10);
        CycleUndirectedGraphUsingDisjointSet<String>  cycleUndirectedGraphUsingDisjointSet=new CycleUndirectedGraphUsingDisjointSet(graph);
        System.out.println(cycleUndirectedGraphUsingDisjointSet.hasCycle());
    }
}
