package com.luckly.algorithm.A20221007;

public class Day08MaxSubArray {
    
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i = 0; i < dp.length; i++){
            dp[i] = nums[i];
        }
        int res = nums[0];
        for(int i = 0; i < dp.length; i++){
            if(i > 0){
                dp[i] = Math.max(dp[i], dp[i-1] + nums[i]);
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
