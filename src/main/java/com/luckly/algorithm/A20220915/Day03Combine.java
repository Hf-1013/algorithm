package com.luckly.algorithm.A20220915;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author houfeng
 * @Date 2022/9/15 19:45
 * @tag 回溯
 * @url https://leetcode.cn/problems/combinations/
 */
public class Day03Combine {
    
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tempList = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        this.backTrace(0, k, 1, n);
        return res;
    }
    
    
    private void backTrace(int currentDepth, int maxDepth, int preValue, int n){
        if(currentDepth == maxDepth){
            res.add(new ArrayList<>(tempList));
            return;
        }
        if(currentDepth > maxDepth){
            return;
        }
        
        for(int i = preValue; i <= n; i++){
            tempList.add(i);
            backTrace(currentDepth+1, maxDepth, i+1, n);
            tempList.remove(tempList.size()-1);
        }
    }
    
    public static void main(String[] args) {
        Day03Combine day03Combine = new Day03Combine();
        List<List<Integer>> combine = day03Combine.combine(1, 1);
        System.out.println(combine);
    }

}
