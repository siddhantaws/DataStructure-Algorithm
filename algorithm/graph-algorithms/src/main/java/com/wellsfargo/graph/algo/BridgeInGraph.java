package com.wellsfargo.graph.algo;


import java.util.*;

public class BridgeInGraph {

    private Map<Integer,Integer> map =new HashMap<>();

    class Graph{
        int V;

        LinkedList<Integer> linkedList[];

        int discoverValue[];
        int lowValue[];
        boolean visisted[];
        int count=0;
        public Graph(int v) {
            this.V = v;
            this.linkedList=new LinkedList[V];
            init();
        }

        private void init(){
            for(int i=0;i<V;i++)
                this.linkedList[i]=new LinkedList<>();
            this.discoverValue=new int[V];
            this.lowValue=new int[V];
            this.visisted=new boolean[V];
            Arrays.fill(discoverValue,-1);
            Arrays.fill(lowValue,-1);
        }

        public void addEdge(int u, int v){
            this.linkedList[u].add(v);
            this.linkedList[v].add(u);
        }

        public Map<Integer,Integer> getAllbridges(){
            dfs(-1,0);
            return map;
        }

        private void dfs(int u ,int v){
            if(visisted[v])
                return;
            discoverValue[v]=++count;
            lowValue[v]=count;
            visisted[v]=true;
            Iterator<Integer> iterator =linkedList[v].iterator();
            while(iterator.hasNext())   {
                int dest =iterator.next();
                if(dest==v)
                    continue;
                dfs(v,dest);
                lowValue[v]=Math.min(lowValue[dest] , lowValue[v]);
                if(discoverValue[v]<lowValue[dest]){
                    map.put(v,dest);
                    map.put(dest,v);
                }
            }
        }

    }
}
