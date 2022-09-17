package com.luckly.algorithm.A20220917;

import com.luckly.algorithm.A20220915.Day03Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day05PermuteUnique {
    
    
    List<List<Integer>> res = new ArrayList<>();
    
    List<Integer> tempList = new ArrayList<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        this.backTrace(nums, used);
        return res;
    }
    
    
    private void backTrace(int[] nums, boolean[] used){
        if(tempList.size() == nums.length){
            res.add(new ArrayList<>(tempList));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])){
                continue;
            }
            if(tempList.size() <= nums.length){
                tempList.add(nums[i]);
                used[i] = true;
                backTrace(nums, used);
                tempList.remove(tempList.size() -1);
                used[i] =  false;
            }
        }
    }
    
    public static void main(String[] args) {
        Day05PermuteUnique day03Subsets = new Day05PermuteUnique();
        List<List<Integer>> subsets = day03Subsets.permuteUnique(new int[] {1,1,2});
        System.out.println(subsets);
    }

}
