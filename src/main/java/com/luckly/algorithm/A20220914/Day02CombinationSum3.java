package com.luckly.algorithm.A20220914;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author houfeng
 * @Date 2022/9/14 19:45
 * @tag 回溯
 * @url https://leetcode.cn/problems/combination-sum-iii/
 */
public class Day02CombinationSum3 {
    
    List<List<Integer>> res = new ArrayList<>();
    
    List<Integer> tempList = new ArrayList<>();
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.backTrace(0, k, n, 0, 1);
        return res;
    }
    
    private void backTrace(int currentDepth, int maxDepth, int target, int sum, int preValue){
        if(currentDepth == maxDepth && sum == target){
            res.add(new ArrayList<>(tempList));
        }
        if(currentDepth >= maxDepth){
            return;
        }
        
        for(int i = preValue; i < 10; i++){
            tempList.add(i);
            backTrace(currentDepth + 1, maxDepth, target, sum + i, i+1);
            tempList.remove(tempList.size()-1);
        }
    }
    
    public static void main(String[] args) {
        Day02CombinationSum3 day02CombinationSum3 = new Day02CombinationSum3();
        List<List<Integer>> lists = day02CombinationSum3.combinationSum3(3, 9);
        System.out.println(lists);
    
    }
    
    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 添加备注
     *
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 39 MB
     * , 在所有 Java 提交中击败了
     * 60.66%
     * 的用户
     * 通过测试用例：
     * 18 / 18
     */
}
