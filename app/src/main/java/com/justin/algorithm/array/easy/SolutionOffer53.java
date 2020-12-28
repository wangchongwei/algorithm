package com.justin.algorithm.array.easy;
/*
 * created by Justin on 2020/12/22
 * email: wcw1992yu@163.com
 * github: https://github.com/wangchongwei
 */

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 10000
 */


class SolutionOffer53 {

    public static void main(String[] args) {
        int[] a = new int[]{0,1,2, 3, 4, 5, 6, 7, 9};
        System.out.println("result = " + missingNumber2(a));
    }


    public static int missingNumber(int[] nums) {
        if(nums[nums.length - 1] != nums.length) return nums.length;
        for(int i = 0; i < nums.length; i ++) {
            if(i != nums[i]) return i;
        }
        return 0;
    }

    // 二分查找
    public static int missingNumber2(int[] nums) {
        if(nums[nums.length - 1] != nums.length) return nums.length;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int center = (left + right) / 2;
            if(nums[center] != center) {
                right = center - 1;
            } else {
                left = center + 1;
            }
        }


        return left;
    }

}
