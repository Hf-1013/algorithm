package com.luckly.algorithm.A20220913;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author houfeng
 * @Date 2022/9/13 19:45
 * @tag 回溯
 */
public class Day01CombinationSum {
    
    List<List<Integer>> res = new ArrayList<>();
    
    List<Integer> tempList = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helpFun(candidates, 0, target, 0);
        return res;
    }
    
    public void helpFun(int[] candidates, int index, int target, int sum){
        if(sum > target||index > candidates.length-1){
            return;
        }
        if(sum == target){
            res.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            tempList.add(candidates[i]);
            helpFun(candidates, i, target, sum + candidates[i]);
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
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 97.98%
     * 的用户
     * 内存消耗：
     * 41.4 MB
     * , 在所有 Java 提交中击败了
     * 94.26%
     * 的用户
     * 通过测试用例：
     * 160 / 160
     * 炫耀一下:
     */
}
