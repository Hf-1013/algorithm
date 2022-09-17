package com.luckly.algorithm.A20220917;

import java.util.ArrayList;
import java.util.List;

public class Day05Combine {
    
    
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
}
