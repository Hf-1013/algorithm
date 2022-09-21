package com.luckly.algorithm.A20220915;

/**
 * @Author houfeng
 * @Date 2022/9/17 19:24
 */
public class StringTest {

    public static void main(String[] args) {
        String s = "0001-01-0002";
        int i = s.lastIndexOf("-");
        System.out.println(s.substring(0, i));
    }
}
