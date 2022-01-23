package com.wfs.amazon.dfs;

import java.util.*;

public class _1192CriticalConnectionsNetwork {
    private int n;
    private List<List<Integer>> connections;
    private int counter=1;
    public List<List<Integer>> criticalConnections() {
        Map<Integer,List<Integer>> mapOfNodes =new HashMap<>();
        for(List<Integer> nodes :connections)  {
            mapOfNodes.computeIfAbsent(nodes.get(0) ,k->  new LinkedList<>()).add(nodes.get(1));
            mapOfNodes.computeIfAbsent(nodes.get(1) ,k->  new LinkedList<>()).add(nodes.get(0));
        }
        Map<Integer ,Integer> mapOfNodesToDiscoveryTime =new HashMap<>();
        Map<Integer ,Integer> mapOfNodesToLowTime =new HashMap<>();
        List<List<Integer>> listOfCirticalConnection =new ArrayList<>();
        for(List<Integer> nodes : connections){
            if(!mapOfNodesToDiscoveryTime.containsKey(nodes.get(0))){
                getAllCriticalConnection(mapOfNodes ,listOfCirticalConnection , mapOfNodesToDiscoveryTime ,  mapOfNodesToLowTime , nodes.get(0),-1 );
            }
        }
        return listOfCirticalConnection;
    }
    private void getAllCriticalConnection( Map<Integer,List<Integer>> mapOfNodes ,List<List<Integer>> listOfCirticalConnection , Map<Integer ,Integer> mapOfNodesToDiscoveryTime , Map<Integer ,Integer> mapOfNodesToLowTime ,  int currentNodes , int parent){
        mapOfNodesToDiscoveryTime.put(currentNodes , counter);
        mapOfNodesToLowTime.put(currentNodes , counter);
        counter++;
        Iterator<Integer> nodesOfInterator = mapOfNodes.get(currentNodes).iterator();
        while(nodesOfInterator.hasNext()){
            Integer destNodes = nodesOfInterator.next();
            if(!mapOfNodesToDiscoveryTime.containsKey(destNodes)){
                getAllCriticalConnection(mapOfNodes, listOfCirticalConnection , mapOfNodesToDiscoveryTime,mapOfNodesToLowTime , destNodes ,currentNodes );
                mapOfNodesToLowTime.put(currentNodes , Math.min(mapOfNodesToLowTime.get(currentNodes) , mapOfNodesToLowTime.get(destNodes) ));
                if(mapOfNodesToLowTime.get(destNodes)>mapOfNodesToDiscoveryTime.get(currentNodes))
                    listOfCirticalConnection.add(Arrays.asList(new Integer[]{currentNodes , destNodes}));
            }else{
                if(destNodes!=parent && mapOfNodesToLowTime.get(currentNodes)>mapOfNodesToLowTime.get(destNodes))
                    mapOfNodesToLowTime.put(currentNodes , mapOfNodesToLowTime.get(destNodes));
            }
        }
    }

}
