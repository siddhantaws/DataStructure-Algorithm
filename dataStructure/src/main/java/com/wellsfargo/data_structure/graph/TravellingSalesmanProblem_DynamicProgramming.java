package com.wellsfargo.data_structure.graph;

import java.util.*;

/**
 * @author Siddhanta Kumar Pattnaik
 */
public class TravellingSalesmanProblem_DynamicProgramming {

    private int[][] distance;

    private int V;

    private Map<Integer,Integer> minCostDP;

    private Map<Integer,Integer> parent;

    public TravellingSalesmanProblem_DynamicProgramming(int[][] distance) {
        this.distance = distance;
        this.V=distance[0].length;
        this.minCostDP =new HashMap<>();
        this.parent= new HashMap<>();
    }

    public int minCost(){
        List<Set<Integer>> allSets=generateCombination(V-1);
        return  -1;
    }


    private  List<Set<Integer>> generateCombination(int n) {
        int input[] = new int[n];
        for(int i = 0; i < input.length; i++) {
            input[i] = i+1;
        }
        List<Set<Integer>> allSets = new ArrayList<>();
        int result[] = new int[input.length];
        generateCombination(input, 0, 0, allSets, result);
        Collections.sort(allSets, new Comparator<Set<Integer>>() {
            @Override
            public int compare(Set<Integer> o1, Set<Integer> o2) {
                return o1.size()-o2.size();
            }
        });
        return allSets;
    }

    private  void generateCombination(int input[], int start, int pos, List<Set<Integer>> allSets, int result[]) {
        if(pos == input.length) {
            return;
        }
        Set<Integer> set = createSet(result, pos);
        allSets.add(set);
        for(int i=start; i < input.length; i++) {
            result[pos] = input[i];
            generateCombination(input, i+1, pos+1, allSets, result);
        }
    }

    private  Set<Integer> createSet(int input[], int pos) {
        if(pos == 0) {
            return new HashSet<>();
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < pos; i++) {
            set.add(input[i]);
        }
        return set;
    }

    public static void main(String[] args) {
        int arr[][]={{0,1,15,6},{2,0,7,3},{9,6,0,12},{10,4,8,0}};
        TravellingSalesmanProblem_DynamicProgramming problem_dynamicProgramming =new TravellingSalesmanProblem_DynamicProgramming(arr) ;
        for(Set<Integer> l: problem_dynamicProgramming.generateCombination(3)){
            for(Integer i:l)
                System.out.print(i+" ");
            System.out.println();
        }

    }
}
