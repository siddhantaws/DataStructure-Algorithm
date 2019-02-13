package com.wellsfargo.data_structure.queue;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class DistanceNearestCellHaving1InBinaryMatrix {

    private int arr[][];

    private static int N;

    private static int M;

    public DistanceNearestCellHaving1InBinaryMatrix(int[][] arr) {
        this.arr = arr;
        this.N = arr.length;
        this.M = arr[0].length;
    }

    static class Graph {
        List<Integer>[] g = new ArrayList[N * M];
        int n, m;

        public Graph(int a, int b) {
            n = a;
            m = b;
        }

        // Function to create graph with N*M nodes  considering each cell as a node and each boundry as an edge.
        public void createGraph() {
            int k = 1;  // A number to be assigned to a cell
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    // If last row, then add edge on right side.
                    if (i == N) {
                        // If not bottom right cell.
                        if (j != M) {
                            g[k].add(k + 1);
                            g[k + 1].add(k);
                        }
                    }// If last column, then add edge toward down.
                    else if (j == M) {
                        g[k].add(k + m);
                        g[k + m].add(k);
                    } else {// Else make edge in all four direction.
                        g[k].add(k + 1);
                        g[k + 1].add(k);
                        g[k].add(k + m);
                        g[k + m].add(k);
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
                for (int i = 0; i < g[temp].size(); i++) {
                    if (!visit[g[temp].get(i)]) {
                        dist[g[temp].get(i)] = Math.min(dist[g[temp].get(i)], dist[temp] + 1);
                        q.add(g[temp].get(i));
                        visit[g[temp].get(i)] = true;
                    }
                }
            }
        }

        void print(int dist[]) {
            for (int i = 1, c = 1; i <= n * m; i++, c++) {
                System.out.print(dist[i] + " ");
                if (c % m == 0)
                    System.out.println();
            }
        }
    }

    // Find minimum distance
    void findMinDistance() {
        // Creating a graph with nodes values assigned
        // from 1 to N x M and matrix adjacent.
        Graph g1 = new Graph(N, M);
        g1.createGraph();

        // To store minimum distance
        int dist[] = new int[M * N];

        // To mark each node as visited or not in BFS
        boolean visit[] = new boolean[M * N];

        // Initalising the value of distance and visit.
        for (int i = 1; i <= M * N; i++) {
            dist[i] = Integer.MAX_VALUE;
            visit[i] = false;
        }
        // Inserting nodes whose value in matrix is 1 in the queue.
        int k = 1;
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    dist[k] = 0;
                    visit[k] = true;
                    q.add(k);
                }
                k++;
            }
        }
        // Calling for Bfs with given Queue.
        g1.bfs(visit, dist, q);
        // Printing the solution.
        g1.print(dist);
    }

    public static void main(String[] args) {
        int mat[][] = {{0, 0, 0, 1}
                        ,{0, 0, 1, 1},{0, 1, 1, 0 }};

        DistanceNearestCellHaving1InBinaryMatrix inBinaryMatrix =new DistanceNearestCellHaving1InBinaryMatrix(mat);
        inBinaryMatrix.findMinDistance();
    }
}