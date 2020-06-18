package com.wfs.amazon.graph;

import java.util.*;

public class _192_CriticalConnectionsNetwork {

    List<List<Integer>> connections;

    public _192_CriticalConnectionsNetwork(List<List<Integer>> connections) {
        this.connections = connections;
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> listOfCriticalConnection =new ArrayList<>();
        Map<Integer , int[]> mapOfNodesToDiscoveryTime =new HashMap<>();

        dfs(mapOfNodesToDiscoveryTime , connections ,listOfCriticalConnection.get(0).get(0),-1 , 0 , listOfCriticalConnection );
        return listOfCriticalConnection;
    }

    private void dfs(Map<Integer , int[]> mapOfNodesToDiscoveryTime , List<List<Integer>> connections, int currentNode ,int parentNode , int count , List<List<Integer>> listOfCriticalConnection){
        mapOfNodesToDiscoveryTime.put(currentNode , new int[]{count,count});
        for(List<Integer> connection :connections){

            if(connection.get(0)==currentNode || connection.get(0)==currentNode){
                int nextNode =   connection.get(0)==currentNode ? connection.get(1) : connection.get(0);
                if(nextNode!=parentNode && !mapOfNodesToDiscoveryTime.containsKey(nextNode)){
                    dfs(mapOfNodesToDiscoveryTime,connections,nextNode,currentNode , count+1 ,listOfCriticalConnection );
                    mapOfNodesToDiscoveryTime.get(currentNode)[1] = Math.min(mapOfNodesToDiscoveryTime.get(currentNode)[1] ,mapOfNodesToDiscoveryTime.get(nextNode)[1] ) ;
                    if(mapOfNodesToDiscoveryTime.get(currentNode)[1]<mapOfNodesToDiscoveryTime.get(nextNode)[1])
                        listOfCriticalConnection.add(Arrays.asList(new Integer[]{currentNode,nextNode }));
                }else if(nextNode!=parentNode ){
                    dfs(mapOfNodesToDiscoveryTime ,connections , nextNode,currentNode, count+1, listOfCriticalConnection );
                }
            }
        }
    }
}
