package com.wellsfargo.graph.algo;

import java.util.ArrayDeque;
import java.util.Queue;

public class FindMinimumS_TCutInFlowNetwork {

    private int [][]graph;
    private int [][]tempGraph;

    private int source;

    private int sink;

    private boolean visitedVertex[];

    private int parentVertex[];

    private Queue<Integer> queue;

    public FindMinimumS_TCutInFlowNetwork(int[][] graph, int source, int sink) {
        this.graph = graph;
        this.source = source;
        this.sink = sink;
        init();
    }

    public void init(){
        queue=new ArrayDeque<>();
        visitedVertex =new boolean[graph.length];
        parentVertex =new int[graph.length];
        tempGraph =new int[graph.length][graph[0].length];
        for(int i=0;i<graph.length;i++)
            for(int j=0;j<graph[i].length;j++)
                tempGraph[i][j] =graph[i][j];
    }

    public void reset(){
        queue.clear();
        for(int i=0;i<visitedVertex.length;i++)
            visitedVertex[i]=false;
        for(int i=0;i<parentVertex.length;i++)
            parentVertex[i]=-1;
    }

    public boolean isBfs(){
        queue.add(source);
        visitedVertex[source] =true;
        while(!queue.isEmpty()){
            int u= queue.poll();

            for(int v=0;v<graph[u].length;v++){
                if(tempGraph[u][v]>0 && !visitedVertex[v]){
                    queue.add(v);
                    visitedVertex[v] =true;
                    parentVertex[v]=u;
                }
            }
        }
        return visitedVertex[sink];
    }

    public void minCut(){
        int maxFlow=0 , v =0,u=0;
            while(isBfs()){
                int currentFlow=Integer.MAX_VALUE;
                for(v=sink;v!=source;v=parentVertex[v]){
                    currentFlow =Math.min(currentFlow, tempGraph[parentVertex[v]][v]);
                }
                for(v=sink;v!=source;v=parentVertex[v]){
                    tempGraph[parentVertex[v]][v] -= currentFlow;
                    tempGraph[v][parentVertex[v]]+=currentFlow;
                }
                maxFlow+=currentFlow;
                reset();
            }
        dfs();
        // Print all edges that are from a reachable vertex to
        // non-reachable vertex in the original graph
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] > 0 && visitedVertex[i] && !visitedVertex[j]) {
                    System.out.println(i + " - " + j);
                }
            }
        }

    }


    public void dfs(){
        visitedVertex[source]=true;
        dfs(source);
    }

    private void dfs(int source){
        for(int i=0;i<tempGraph[0].length;i++){
            if(tempGraph[source][i]>0 && !visitedVertex[i]){
                visitedVertex[i]=true;
                dfs(i);
            }
        }


    }
    public static void main(String[] args) {
        int graph[][] =new int[][] { {0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}
        };
        FindMinimumS_TCutInFlowNetwork flowProblem =new FindMinimumS_TCutInFlowNetwork(graph, 0,5);
        flowProblem.minCut();
    }
}

