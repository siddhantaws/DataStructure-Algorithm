package com.wfs.amazon.backtracking;

import java.util.*;

public class _40CombinationSumII {
    private int[] candidates;
    private int target;
    List<List<Integer>> listOfSums = new ArrayList<>();
    public _40CombinationSumII(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum2(candidates ,target , new ArrayList(),0);
        return listOfSums;
    }
    private  void combinationSum2(int[] candidates,  int target , List<Integer> listOfSum,int pos ){
        if(target==0){
            listOfSums.add((List<Integer>)((ArrayList<Integer>)listOfSum).clone());
            return ;
        }else{

            for(int i=pos;i<candidates.length;i++){
                if(candidates[i]<=target){
                    listOfSum.add(candidates[i]);
                    combinationSum2(candidates  ,target-candidates[i], listOfSum ,i+1);
                    listOfSum.remove(listOfSum.size()-1);
                }
            }
        }
    }
}
