package com.wellsfargo.data_structure.queue;

import java.util.*;

public class DistanceNearestCellHaving1BinaryMatrix {

    private int[][] arr;
    private int N, M;
    private static int MAX = 500;

    public DistanceNearestCellHaving1BinaryMatrix(int[][] arr) {
        this.arr = arr;
        this.N = arr.length;
        this.M = arr[0].length;
    }


    class Graph {
        int n, m;
        Map<Integer, List<Integer>> graph = new HashMap<>();

        Graph(int a, int b) {
            n = a;
            m = b;
        }

        public void addGraphNode(int key, int value) {
            if (graph.get(key) == null) {
                List<Integer> l = new ArrayList<>();
                l.add(value);
                graph.put(key, l);
            } else {
                graph.get(key).add(value);
            }
        }

        public void createGraph() {
            int k = 1;  // A number to be assigned to a cell

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    // If last row, then add edge on right side.
                    if (i == n) {
                        // If not bottom right cell.
                        if (j != m) {
                            addGraphNode(k, k + 1);
                            addGraphNode(k + 1, k);
                        }
                    }

                    // If last column, then add edge toward down.
                    else if (j == m) {
                        addGraphNode(k, k + m);
                        addGraphNode(k + m, k);
                    }

                    // Else make edge in all four direction.
                    else {
                        addGraphNode(k, k + 1);
                        addGraphNode(k + 1, k);
                        addGraphNode(k, k + m);
                        addGraphNode(k + m, k);
                    }
                    k++;
                }
            }
        }

        // BFS function to find minimum distance
        public void bfs(boolean visit[], int dist[], Queue<Integer> q) {
            while (!q.isEmpty()) {
                int temp = q.peek();
                q.poll();

                for (int i = 0; i < graph.get(temp).size(); i++) {
                    if (visit[graph.get(temp).get(i)] != true) {
                        dist[graph.get(temp).get(i)] =
                                Math.min(dist[graph.get(temp).get(i)], dist[temp] + 1);

                        q.offer(graph.get(temp).get(i));
                        visit[graph.get(temp).get(i)] = true;
                    }
                }
            }
        }

        public void print(int dist[]) {
            for (int i = 1, c = 1; i <= n * m; i++, c++) {
                System.out.println(dist[i] + " ");
            }
        }
    }

    void findMinDistance() {
        // Creating a graph with nodes values assigned
        // from 1 to N x M and matrix adjacent.
        Graph graph = new Graph(N, M);
        graph.createGraph();

        // To store minimum distance
        int dist[] = new int[MAX];

        // To mark each node as visited or not in BFS
        boolean visit[] = new boolean[MAX];

        // Initalising the value of distance and visit.
        for (int i = 1; i <= M * N; i++) {
            dist[i] = Integer.MAX_VALUE;
            visit[i] = false;
        }

        // Inserting nodes whose value in matrix
        // is 1 in the queue.
        int k = 1;
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    dist[k] = 0;
                    visit[k] = true;
                    q.offer(k);
                }
                k++;
            }
        }

        // Calling for Bfs with given Queue.
        graph.bfs(visit, dist, q);

        // Printing the solution.
        graph.print(dist);
    }

    public static void main(String[] args) {
        int mat[][] =
        {
                {0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 0}
        };
        DistanceNearestCellHaving1BinaryMatrix distance =new DistanceNearestCellHaving1BinaryMatrix(mat);
        distance.findMinDistance();
    }
}



