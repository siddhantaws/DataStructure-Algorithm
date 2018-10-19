package com.wellsfargo.data_structure.graph;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class CheckWhetherGraphIsBipartiteOrNot {
    private int graph[][];
    private int color[];

    public CheckWhetherGraphIsBipartiteOrNot(int[][] graph) {
        this.graph = graph;
        this.color=new int[graph.length];
        for(int i=0;i<graph.length;i++)
            color[i] = -1;
    }

    public boolean isBipartiteGraph(int pos ,int c ){
        if(color[pos] != -1 && color[pos] !=c)
            return false;
        // color this pos as c and all its neighbours and 1-c
        color[pos] = c;
        boolean ans = true;
        for(int i=0;i<graph.length;i++){
            if(graph[pos][i]==1){
                if(color[i] == -1)
                    ans &= isBipartiteGraph(i,1-c);

                if(color[i] !=-1 && color[i] != 1-c)
                    return false;
            }
            if (!ans)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int G[][] = {{0, 1, 0, 1},
                     {1, 0, 1, 0},
                     {0, 1, 0, 1},
                     {1, 0, 1, 0}
                    };
        int pos = 0;
        CheckWhetherGraphIsBipartiteOrNot bipartiteOrNot =new CheckWhetherGraphIsBipartiteOrNot(G);
        System.out.println(bipartiteOrNot.isBipartiteGraph(pos, 1));
    }
}
