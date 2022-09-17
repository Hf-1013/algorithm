package com.luckly.algorithm.A20220916;

import com.luckly.algorithm.A20220915.Day03Subsets;

import java.util.ArrayList;
import java.util.List;

public class Day04Subsets {
    
    private List<List<Integer>> res = new ArrayList<>();
    
    private List<Integer> tempList = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        this.backTrace(nums, 0);
        return res;
    }
    
    
    private void backTrace(int[] nums, int index){
        res.add(new ArrayList<>(tempList));
        if(index >= nums.length){
            return;
        }
        for(int i = index; i < nums.length; i++){
            tempList.add(nums[i]);
            backTrace(nums, i+1);
            tempList.remove(tempList.size()-1);
        }
    }
    
    public static void main(String[] args) {
        Day03Subsets day03Subsets = new Day03Subsets();
        List<List<Integer>> subsets = day03Subsets.subsets(new int[] {1, 2, 3});
        System.out.println(subsets);
    }
    
}
