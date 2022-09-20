package com.luckly.algorithm.A20220919;

public class Day07CoinChange {
    
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0){
            return -1;
        }
        int[] dp = new int[amount+1];
        for(int i = 0; i < dp.length; i++){
            dp[i] = amount+1;
        }
        dp[0] = 0;
        for(int i = 1; i<=amount; i++){
            
            for(int j = 0; j < coins.length; j++){
                if(i >= coins[j]){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }
        if(dp[amount] == amount+1){
            return -1;
        }
        return dp[amount];
    }

}
