package com.wellsfargo.algo.backtracking;

import com.wellsfargo.graph.algo.Graph;

import java.util.*;

public class HamiltonianCycle {
    private Graph graph;

    private Map hamiltonianPath;

    private Graph.Vertex sourceVertex;
    private List<Graph.Vertex> vertices =new ArrayList<>() ;

    public HamiltonianCycle(Graph graph) {
        this.graph = graph;
        this.hamiltonianPath =new LinkedHashMap();
        Iterator<Graph.Vertex> iterator = graph.getAllVertex().iterator();
        while(iterator.hasNext())
            vertices.add(iterator.next());
    }

    public Map getHamiltonianPath()
    {
        sourceVertex=vertices.get(0);
        hamiltonianPath.put(sourceVertex ,sourceVertex);
        return getHamiltonianPath(sourceVertex) ?  hamiltonianPath : null;
    }

    private boolean getHamiltonianPath(Graph.Vertex vertex)
    {
        for(Graph.Vertex vertex1 :(List<Graph.Vertex>)vertex.getAdjacentVertexes())
        {
            if(vertices.size() ==hamiltonianPath.size() && vertex1.equals(sourceVertex))
                return true;
            if(!hamiltonianPath.containsKey(vertex1))
            {
                hamiltonianPath.put(vertex1, vertex1);
                if(getHamiltonianPath(vertex1))
                    return true;
                else
                {
                    hamiltonianPath.remove(vertex1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        /* Let us create the following graph
           (0)--(1)--(2)
            |   / \
            |  /   \
            | /     \
           (3)-------(4)    */

        Graph graph =new Graph();
        graph.addEdge(0,1 , 0);graph.addEdge(1,2 , 0);graph.addEdge(2,4,0);
        //graph.addEdge(4,3,0);
        graph.addEdge(3,0,0);graph.addEdge(3,1,0);graph.addEdge(1,4,0);
        HamiltonianCycle hamiltonianCycle =new HamiltonianCycle(graph);
        Map map=hamiltonianCycle.getHamiltonianPath();
        System.out.printf("Map" +map);
    }
}
