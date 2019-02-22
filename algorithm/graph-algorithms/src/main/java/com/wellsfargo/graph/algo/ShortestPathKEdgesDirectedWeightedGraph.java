package com.wellsfargo.graph.algo;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class ShortestPathKEdgesDirectedWeightedGraph {
    static final int V = 4;

    static final int INF = Integer.MAX_VALUE;

    private int graph[][];

    private int u;

    private int v;

    private int k;

    public ShortestPathKEdgesDirectedWeightedGraph(int[][] graph, int u, int v, int k) {
        this.graph = graph;
        this.u = u;
        this.v = v;
        this.k = k;
    }

    // A Dynamic programming based function to find the shortest path  from u to v with exactly k edges.
    public int shortestPath() {
        // Table to be filled up using DP. The value sp[i][j][e] will
        // store weight of the shortest path from i to j with exactly k edges
        int sp[][][] = new int[V][V][k+1];
        // Loop for number of edges from 0 to k
        for (int e = 0; e <= k; e++) {
            for (int i = 0; i < V; i++) { // for source
                for (int j = 0; j < V; j++) {// for destination
                    // initialize value
                    sp[i][j][e] = INF;
                    // from base cases
                    if (e == 0 && i == j)
                        sp[i][j][e] = 0;
                    if (e == 1 && graph[i][j] != INF)
                        sp[i][j][e] = graph[i][j];
                    // go to adjacent only when number of edges is more than 1
                    if (e > 1) {
                        for (int a = 0; a < V; a++) {
                            // There should be an edge from i to a and a should not be same as either i or j
                            if (graph[i][a] != INF && i != a && j!= a && sp[a][j][e-1] != INF)
                                sp[i][j][e] = Math.min(sp[i][j][e], graph[i][a] + sp[a][j][e-1]);
                        }
                    }
                }
            }
        }
        return sp[u][v][k];
    }

    public static void main(String[] args) {
        int graph[][] = new int[][]{ {0, 10, 3, 2},
                {INF, 0, INF, 7},
                {INF, INF, 0, 6},
                {INF, INF, INF, 0}
        };int u = 0, v = 3, k = 2;
        ShortestPathKEdgesDirectedWeightedGraph directedWeightedGraph =new ShortestPathKEdgesDirectedWeightedGraph(graph,u,v,k);
        directedWeightedGraph.shortestPath();
    }
}
