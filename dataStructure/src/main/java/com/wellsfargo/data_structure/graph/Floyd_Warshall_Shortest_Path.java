package com.wellsfargo.data_structure.graph;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class Floyd_Warshall_Shortest_Path {
    private Graph<Integer, Integer> graph;

    private int[][] graphAdjList;

    private int[][] sourcePath;

    public Floyd_Warshall_Shortest_Path(Graph graph) {
        this.graph = graph;
        this.graphAdjList = new int[graph.getVertices().size()][graph.getVertices().size()];
        this.sourcePath = new int[graph.getVertices().size()][graph.getVertices().size()];
        for (int i = 0; i < graphAdjList.length; i++)
            for (int j = 0; j < graphAdjList[0].length; j++)
                graphAdjList[i][j] = i == j ? 0 : Integer.MAX_VALUE;
        constructAdjMatrix();
    }

    private void constructAdjMatrix() {
        for (Graph.Edge<Integer, Integer> edge : graph.getAllEdges()) {
            graphAdjList[edge.getV2().getData()][edge.getV1().getData()] = edge.getWeight();
        }
    }

    public void constructShottestpath() {
        for (int k = 0; k < graph.getVertices().size() - 1; k++) {
            for (int i = 0; i < graph.getVertices().size() - 1; i++)
                for (int j = 0; j < graph.getVertices().size() - 1; j++) {
                    if (graphAdjList[i][j] == Integer.MAX_VALUE && (graphAdjList[i][k] == Integer.MAX_VALUE || graphAdjList[k][j] == Integer.MAX_VALUE))
                        continue;
                    if(graphAdjList[i][k] == Integer.MAX_VALUE || graphAdjList[k][j] == Integer.MAX_VALUE)
                        continue;
                    if (graphAdjList[i][j]==Integer.MAX_VALUE ||  (graphAdjList[i][j] > graphAdjList[i][k] + graphAdjList[k][j])) {
                        graphAdjList[i][j] = graphAdjList[i][k] + graphAdjList[k][j];
                        sourcePath[i][j] = k;
                    }
                }
        }
        System.out.println(1);
    }

    public static void main(String[] args) {
        Graph<Integer,Integer> graph =new Graph<>(true);
        graph.add(0,3,1);graph.add(3,0,15);
        graph.add(0,1,3);graph.add(1,2,-2);
        graph.add(0,2,6);graph.add(0,3,1);
        graph.add(2,3,2);
        Floyd_Warshall_Shortest_Path shortest_path =new Floyd_Warshall_Shortest_Path(graph);
        shortest_path.constructShottestpath();
    }

}
