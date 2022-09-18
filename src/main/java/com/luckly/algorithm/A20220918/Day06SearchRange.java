package com.luckly.algorithm.A20220918;

public class Day06SearchRange {
    
    int[] result = new int[]{-1,-1};
    
    public int[] searchRange(int[] nums, int target) {
        helpFun(nums, 0, nums.length-1, target);
        return result;
    }
    
    
    
    private void helpFun(int[] nums, int left, int right, int target){
        if(left > right){
            return;
        }
        int index = (left+right) / 2;
        if(target > nums[index]){
            helpFun(nums, index + 1, right, target);
        }else if(target < nums[index]){
            helpFun(nums, left, index - 1, target);
        }else{
            int min = index;
            int max = index;
            while(max < nums.length && nums[max] == target){
                max++;
            }
            while(min >= 0 && nums[min] == target){
                min--;
            }
            result[0] = min+1;
            result[1] = max-1;
        }
        
    }
    
}
