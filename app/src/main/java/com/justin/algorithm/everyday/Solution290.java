package com.justin.algorithm.everyday;
/*
 * created by Justin on 2020/12/16
 * email: wcw1992yu@163.com
 * github: https://github.com/wangchongwei
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;


/***
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 *
 */
class Solution290 {

    public static void main(String[] args) {



    }

    public static boolean wordPattern(String pattern, String s) {
        // 长度不想等时直接返回false
        if(pattern.length() != s.length()) return false;
        if(pattern.length() == 0 || pattern.length() == 1) return true;

        String[] sArr = s.split(" ");


        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> sMap = new HashMap<>();

        for (int i = 0; i < sArr.length; i++) {
            map.put(i, String.valueOf(pattern.charAt(i)).hashCode());
            sMap.put(i, sArr[i].hashCode());
            sArr[i] = sArr[i].hashCode() + "";
        }




        return false;
    }

}
