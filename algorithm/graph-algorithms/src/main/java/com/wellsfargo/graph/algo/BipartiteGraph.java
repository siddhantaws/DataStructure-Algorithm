package com.wellsfargo.graph.algo;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class BipartiteGraph {

    private int [][]graph;

    private int []color;

    private int V;

    public BipartiteGraph(int[][] graph) {
        this.graph = graph;
        this.V= graph[0].length;
        this.color =new int[V];
        for(int i=0;i<V;i++)
            color[i] = -1;
    }

    private boolean colorGraph(int pos, int c){
        if(color[pos] != -1 && color[pos] !=c)
            return false;
        // color this pos as c and all its neighbours and 1-c
        color[pos] = c;
        boolean ans = true;
        for(int i=0;i<V;i++){
            if(graph[pos][i]==1){
                if(color[i] == -1)
                    ans &= colorGraph(i,1-c);
                if(color[i] !=-1 && color[i] != 1-c)
                    return false;
            }
            if (!ans)
                return false;
        }
        return true;
    }

    public boolean isBipartite(){
        //start is vertex 0;
        int pos = 0;// two colors 1 and 0
        return colorGraph(pos,1);
    }

    public static void main(String[] args) {
        int G[][] = {{0, 1, 0, 1},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 0, 1, 0}
        };
        BipartiteGraph graph =new BipartiteGraph(G);
        System.out.println(graph.isBipartite());
    }
}
