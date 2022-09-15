package com.luckly.algorithm.A20220914;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author houfeng
 * @Date 2022/9/14 11:41
 * @tag 回溯
 */
public class Day02SolveNQueens {

    List<List<String>> result = new ArrayList<>();

    List<String> tempList = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        //初始化一个棋盘
        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            for(int j=0; j < n; j++){
                s.append(".");
            }
            tempList.add(s.toString());
        }
        this.backTrace(n, 0);
        return result;
    }

    private void backTrace(int n, int index){
        if(index > n){
            return;
        }
        if(index == n){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = 0; i < n; i ++){
            if(this.isValid(tempList, index, i)){
                StringBuilder sb1 = new StringBuilder();
                for (int k = 0; k < n; k ++){
                    if(k == i){
                        sb1.append("Q");
                        continue;
                    }
                    sb1.append(".");
                }
                tempList.remove(index);
                tempList.add(index, sb1.toString());
                backTrace(n, index + 1);
                StringBuilder sb2 = new StringBuilder();
                for (int k = 0; k < n; k ++){
                    sb2.append(".");
                }
                tempList.remove(index);
                tempList.add(index,sb2.toString());
            }
        }
    }

    /**
     *
     * @param board 当前棋盘
     * @param row 行
     * @param column 列
     * @return 是否能够满足条件
     */
    private boolean isValid(List<String> board, int row, int column){
        for(int i = 0; i < board.size(); i++){
            if('Q' == board.get(row).charAt(i)){
                return false;
            }
            if('Q' == board.get(i).charAt(column)){
                return false;
            }
        }
        for(int i = row, j = column; i>=0 && j>=0; i--,j--){
            if('Q' == board.get(i).charAt(j)){
                return false;
            }
        }
        for(int i = row,j=column; i>=0 && j<board.size(); i--,j++){
            if('Q' == board.get(i).charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Day02SolveNQueens day02SolveNQueens = new Day02SolveNQueens();

        List<List<String>> lists = day02SolveNQueens.solveNQueens(4);
        System.out.println(lists);
    }
}
