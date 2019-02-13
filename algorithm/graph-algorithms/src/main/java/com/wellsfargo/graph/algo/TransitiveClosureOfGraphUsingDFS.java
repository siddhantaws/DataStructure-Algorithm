package com.wellsfargo.graph.algo;

import java.util.Arrays;
import java.util.List;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class TransitiveClosureOfGraphUsingDFS {

    private Graph<Integer> graph;

    private int vertices;// No. of vertices in graph

    private int[][] tc;// To store transitive closure

    public TransitiveClosureOfGraphUsingDFS(Graph<Integer> graph) {
        this.graph = graph;
        this.vertices =graph.getAllVertex().size();
        this.tc = new int[this.vertices][this.vertices];
    }

    // A recursive DFS traversal function that finds all reachable vertices for s
    private void dfsUtil(int s, int v) {
        // Mark reachability from s to v as true.
        tc[s][v] = 1;
        // Find all the vertices reachable through v
        for (Graph.Vertex adj : graph.getVertex(v).getAdjacentVertexes()) {
            if (tc[s][(int)adj.getData()]==0) {
                dfsUtil(s, (int)adj.getData());
            }
        }
    }
    // The function to find transitive closure. It uses recursive DFSUtil()
    public void transitiveClosure() {
        // Call the recursive helper function to print DFS
        // traversal starting from all vertices one by one
        for (int i = 0; i < vertices; i++) {
            dfsUtil(i, i);
        }

        for (int i = 0; i < vertices; i++) {
            System.out.println(Arrays.toString(tc[i]));
        }
    }
}
