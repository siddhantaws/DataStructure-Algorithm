package com.wellsfargo.data_structure.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCAUsingDP {

    private static int adj[][];
    private static int V;
    private static int parent[];

    private static int log(int N) {
        return 31 - Integer.numberOfLeadingZeros(N);
    }

    private static void findAncestors(final int DP[][]) {
        System.arraycopy(parent, 1, DP[0], 1, V);
        for (int i = 1; i < DP.length; i++) {
            for (int j = 1; j <= V; j++) {
                DP[i][j] = DP[i - 1][DP[i - 1][j]];
            }
        }
    }

    private static void dfs(final int u, final int par, final int lev, int level[]) {
        parent[u] = par;
        level[u] = lev;
        for (int v : adj[u]) {
            if (v != par) {
                dfs(v, u, lev + 1, level);
            }
        }
    }

    private static int[][] getAdjacencyList(int n, int[] from, int[] to) {
        final int[][] lists = new int[n + 1][];
        final int[] adjacent = new int[n + 1];
        for (final int f : from) {
            adjacent[f]++;
        }
        for (final int t : to) {
            adjacent[t]++;
        }
        for (int i = 1; i < n + 1; i++) {
            lists[i] = new int[adjacent[i]];
        }
        for (int i = 0; i < from.length; i++) {
            lists[from[i]][--adjacent[from[i]]] = to[i];
            lists[to[i]][--adjacent[to[i]]] = from[i];
        }
        return lists;
    }

    private static int lca(int u, int v, int DP[][], int level[]) {
        if (level[v] < level[u]) {
            int temp = u;
            u = v;
            v = temp;
        }
        int diff = level[v] - level[u];
        while (diff > 0) {
            int log = log(diff);
            v = DP[log][v];
            diff -= (1 << log);
        }
        while (u != v) {
            int i = log(level[u]);
            for (; i > 0 && DP[i][u] == DP[i][v]; )
                i--;

            u = DP[i][u];
            v = DP[i][v];
        }
        return u;
    }

    public static void main(final String args[]) throws IOException {
        //final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        V = 7;
        int E = V - 1;
        final int from[] = {7 , 7 , 5 ,5,10,10};
        final int to[] = {20 ,25,15,30,5,7 };
        adj = getAdjacencyList(V, from, to);
        final int[] level = new int[V + 1];
        final int DP[][] = new int[log(V) + 1][V + 1];
        parent = new int[V + 1];
        dfs(1, 0, 0, level);
        findAncestors(DP);
        //find lca of 0 and 0
        lca(0, 0, DP, level);
    }


}
