/*
package com.wellsfargo.data_structure.tree;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * @author Siddhanta Kumar Pattnaik
 *//*

public class QueryAncestorDescendantRelationshipTree {
    private int edges [][];

    private int E ;
    private int V ;
    private int timeIn[];
    private int timeOut[];

    public QueryAncestorDescendantRelationshipTree(int[][] edges) {
        this.edges = edges;
        this.E = edges.length / edges[0].length;
        this.V= E+1;
        this.timeIn =new int[V];
        this.timeOut =new int[V];
    }

    private void preProcess() {
        List<Integer> g[] =new ArrayList[V];


        // construct array of vector data structure
        // for tree
        for (int i = 0; i < V - 1; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            g[u].push_back(v);
            g[v].push_back(u);
        }

        int cnt = 0;

        // call dfs method from root
        dfs(g, 0, -1, timeIn, timeOut, cnt);
    }
}
*/
