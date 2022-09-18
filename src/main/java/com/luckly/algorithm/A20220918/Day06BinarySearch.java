package com.luckly.algorithm.A20220918;

public class Day06BinarySearch {
    
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }
    
    private int binarySearch(int[] nums, int left, int right, int target){
        if(left > right){
            return -1;
        }
        int index = (left + right) / 2;
        if(target > nums[index]){
            return binarySearch(nums, index + 1, right, target);
        }else if(target < nums[index]){
            return binarySearch(nums, left, index - 1, target);
        }else{
            return index;
        }
    }
    
    

}
