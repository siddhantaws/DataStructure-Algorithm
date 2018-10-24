package com.wellsfargo.data_structure.graph;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class GraphColoring<K, V extends Comparable> {

    private Graph<K, V> graph;

    private int color[];

    private int matirxGraph[][];

    private int colorNumber;

    private int V;

    public GraphColoring(Graph<K, V> graph, int colorNumber) {
        this.graph = graph;
        this.colorNumber = colorNumber;
        this.color = new int[graph.getAllVertices().size()];
        this.matirxGraph = new int[graph.getAllVertices().size()][graph.getAllVertices().size()];
        this.V = graph.getAllVertices().size();
        for (Graph.Edge<K, V> edge : graph.getAllEdges())
            matirxGraph[(Integer) edge.getV1().getData()][(Integer) edge.getV2().getData()] = 1;
    }

    public boolean graphColoring() {
        if (!graphColoringUtil(0)) {
            System.out.println("Solution does not exist");
            return false;
        }

        // Print the solution
        printSolution(color);
        return true;
    }

    private boolean graphColoringUtil(int vertex) {
        /* base case: If all vertices are assigned  a color then return true */
        if (vertex == V)
            return true;
        /* Consider this vertex v and try different  colors */
        for (int c = 1; c <= colorNumber; c++) {
            /* Check if assignment of color c to v is fine*/
            if (isSafe(vertex, c)) {
                color[vertex] = c;
                /* recur to assign colors to rest of the vertices */
                if (graphColoringUtil(vertex + 1))
                    return true;
                /* If assigning color c doesn't lead to a solution then remove it */
                color[vertex] = 0;
            }
        }
        /* If no color can be assigned to this vertex then return false */
        return false;
    }

    /* A utility function to print solution */
    void printSolution(int color[]) {
        System.out.println("Solution Exists: Following  are the assigned colors");
        for (int i = 0; i < V; i++)
            System.out.print(" " + color[i] + " ");
    }

    private boolean isSafe(int vertex, int c) {
        for (int i = 0; i < V; i++)
            if (matirxGraph[vertex][i] == 1 && c == color[i])
                return false;
        return true;
    }

    public static void main(String[] args) {
        Graph<Integer,Integer> graph =new Graph<>();
        graph.add(3, 2 ,5);graph.add(3, 0 ,5);graph.add(2, 0 ,5);
        graph.add(0, 1 ,5);graph.add(2, 1 ,5);
        GraphColoring<Integer,Integer> graphColoring =new GraphColoring<>(graph, 3 );
        System.out.println(graphColoring.graphColoring());
    }
}
