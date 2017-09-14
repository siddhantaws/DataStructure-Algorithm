package com.wellsfargo.graph.algo;

import java.util.Iterator;

public class CycleUndirectedGraphUsingDFS<T> {

    private Graph<T> graph;
    private T staringVertex;

    public CycleUndirectedGraphUsingDFS(Graph<T> graph , T staringVertex) {
       this.graph = graph;
       this.staringVertex =staringVertex;
    }

    public boolean hasCycle()
    {
       return  hasCycle(graph);
    }

    private boolean hasCycle(Graph<T> graph)
    {
        T prevVertex = null;
        Graph.Vertex<T> tVertex= graph.getVertex(staringVertex);
        prevVertex =tVertex.getData();
        for(Graph.Vertex<T> adjVertex : tVertex.getAdjacentVertexes())
        {
           if(hasCycle(adjVertex ,prevVertex ))
               return true;
            prevVertex = adjVertex.getData();
        }
        return false;
    }

    private boolean hasCycle(Graph.Vertex<T> vertex , T prevVertex )
    {
        if(vertex.isVisited() && !vertex.getData().equals(prevVertex))
            return true;
        prevVertex = vertex.getData();
        vertex.setVisited(true);
        for(Graph.Vertex<T> adjVertex : vertex.getAdjacentVertexes())
        {
            if(hasCycle(adjVertex ,prevVertex ))
                return true;
        }
        return false;
    }

}
