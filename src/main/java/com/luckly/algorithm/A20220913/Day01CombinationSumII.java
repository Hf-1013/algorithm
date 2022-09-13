package com.luckly.algorithm.A20220913;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day01CombinationSumII {
    
    List<List<Integer>> res = new ArrayList<>();
    
    List<Integer> tempList = new ArrayList<>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helpFun(candidates, 0, target, 0);
        return res;
    }
    
    public void helpFun(int[] candidates, int index, int target, int sum){
        if(sum > target){
            return;
        }
        if(sum == target){
            res.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(i>index&&candidates[i]==candidates[i-1]){
                continue;
            }
            tempList.add(candidates[i]);
            helpFun(candidates, i+1, target, sum + candidates[i]);
            tempList.remove(tempList.size() - 1);
        }
    }
    
    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 添加备注
     *
     * 执行用时：
     * 4 ms
     * , 在所有 Java 提交中击败了
     * 43.03%
     * 的用户
     * 内存消耗：
     * 41.4 MB
     * , 在所有 Java 提交中击败了
     * 92.74%
     * 的用户
     * 通过测试用例：
     * 176 / 176
     */
    
}
