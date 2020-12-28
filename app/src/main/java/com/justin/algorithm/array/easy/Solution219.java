package com.justin.algorithm.array.easy;
/*
 * created by Justin on 2020/12/25
 * email: wcw1992yu@163.com
 * github: https://github.com/wangchongwei
 */

import java.util.HashMap;

/**
 * 219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */

public class Solution219 {

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,1,2,3};
        System.out.println("result = " + containsNearbyDuplicate(a, 2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length == 1) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i ++) {
            if(map.containsKey(nums[i])) {
                if(i - (int)map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

}
