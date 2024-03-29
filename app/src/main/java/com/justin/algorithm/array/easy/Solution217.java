package com.justin.algorithm.array.easy;
/*
 * created by Justin on 2021/4/6
 * email: wcw1992yu@163.com
 * github: https://github.com/wangchongwei
 */

import java.util.HashMap;

/**
 * 217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */

class Solution217 {

    public static void main(String[] args) {
        int[] arr = {1,1,1,3,3,4,3,2,4,2};
        boolean result = containsDuplicate(arr);
        System.out.println("result:" + result);
    }

    public static boolean containsDuplicate(int[] nums) {
        if(nums.length <= 1) return false;
        HashMap<Integer, Integer>hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i ++) {
            if(hashMap.containsKey(nums[i])) return true;
            hashMap.put(nums[i], 1);
        }
        return false;
    }

}
