package com.luckly.algorithm.A20220916;

import com.luckly.algorithm.A20220915.Day03Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day04SubsetsWithDup {
    
    private List<List<Integer>> res = new ArrayList<>();
    
    private List<Integer> tempList = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.backTrace(nums, 0);
        return new ArrayList<>(res);
    }
    
    
    private void backTrace(int[] nums, int index){
        res.add(new ArrayList<>(tempList));
        if(index >= nums.length){
            return;
        }
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i-1] ){
                continue;
            }
            tempList.add(nums[i]);
            backTrace(nums, i+1);
            tempList.remove(tempList.size()-1);
        }
    }
    
    public static void main(String[] args) {
        Day04SubsetsWithDup day04Subsets = new Day04SubsetsWithDup();
        List<List<Integer>> subsets = day04Subsets.subsetsWithDup(new int[] {1,2,2});
        System.out.println(subsets);
    }

}
