package com.luckly.algorithm.A20220913;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author houfeng
 * @Date 2022/9/13 19:45
 * @tag 回溯
 */
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

    public static void main(String[] args) {
        System.out.println(reduceDate(new Date(1663660800L *1000), new Date(1663642800L *1000)));
    }

    public static String reduceDate(Date date1, Date date2){
        long l = date1.getTime() - date2.getTime();
        long hours = l / 3600000;
        long l1 = l % 3600000;
        long minute = l1 / 60000;
        long l2 = l1 % 60000;
        long second = l2 / 1000;
        String x = hours + ":" + minute + ":" + second;
        System.out.println(x);
        return x;
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
