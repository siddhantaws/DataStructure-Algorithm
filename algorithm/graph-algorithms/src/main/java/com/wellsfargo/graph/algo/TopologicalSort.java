package com.wellsfargo.graph.algo;

import java.util.*;

public class TopologicalSort<E> {

    private Graph<E> graph;

    private List<Graph.Vertex<E>> vertices =new ArrayList<>();

    private List<E> topologicalString =new ArrayList<>();

    private Stack<Graph.Vertex<E>> stack=new Stack();

    public TopologicalSort(Graph<E> graph) {
        this.graph = graph;
        Iterator<Graph.Vertex<E>> iterator = graph.getAllVertex().iterator();
        while(iterator.hasNext())
            vertices.add(iterator.next());
    }

    public List<E> getTopologicalString()
    {
        for(Graph.Vertex<E> vertex  : vertices)
        {
            if(vertex.isVisited())
                continue;
            vertex.setVisited(true);
            stack.push(vertex);
            exploreAllAdjVertices();
        }
        return topologicalString;
    }

    private void exploreAllAdjVertices()
    {
        while(!stack.isEmpty())
        {
            Graph.Vertex<E> vertex1 = stack.peek();
            for(Graph.Vertex<E> vertex2 : vertex1.getAdjacentVertexes())
            {
                if(vertex2.isVisited())
                    continue;
                vertex2.setVisited(true);
                stack.push(vertex2);
                exploreAllAdjVertices();
            }
            if(!stack.isEmpty())
            {
                stack.pop();
                topologicalString.add(vertex1.getData());
            }

        }
    }

    public static void main(String[] args) {
        Graph<String> graph=new Graph<>(true);
        graph.addEdge("A" , "C" , 1);
        graph.addEdge("C" , "E" , 1);
        graph.addEdge("E" , "H" , 1);
        graph.addEdge("E" , "F" , 1);
        graph.addEdge("B" , "C" , 1);
        graph.addEdge("B" , "D" , 1);
        graph.addEdge("D" , "F" , 1);
        graph.addEdge("F" , "G" , 1);
        TopologicalSort<String> topologicalSort=new TopologicalSort<>(graph);
        for(String vertex : topologicalSort.getTopologicalString())
            System.out.println(vertex);
    }
}
