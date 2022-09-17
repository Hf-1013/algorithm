package com.luckly.algorithm.A20220917;

import com.luckly.algorithm.A20220915.Day03Subsets;

import java.util.ArrayList;
import java.util.List;

public class Day05CombinationSum {
    
    List<List<Integer>> res = new ArrayList<>();
    
    List<Integer> tempList = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.backTrace(candidates, target, 0, 0);
        return res;
    }
    
    private void backTrace(int[] candidates, int target, int sum, int index){
        if(target == sum){
            res.add(new ArrayList<>(tempList));
        }
        
        for(int i = index; i < candidates.length; i++){
            tempList.add(candidates[i]);
            if(sum + candidates[i] <=  target){
                backTrace(candidates, target, sum + candidates[i], i);
            }
            tempList.remove(tempList.size()-1);
        }
    }
    
    public static void main(String[] args) {
        Day05CombinationSum day03Subsets = new Day05CombinationSum();
        List<List<Integer>> subsets = day03Subsets.combinationSum(new int[] {2,3,6,7}, 7);
        System.out.println(subsets);
    }
    
    

}
