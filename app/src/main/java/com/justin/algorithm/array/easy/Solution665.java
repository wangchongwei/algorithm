package com.justin.algorithm.array.easy;
/*
 * created by Justin on 2021/3/12
 * email: wcw1992yu@163.com
 * github: https://github.com/wangchongwei
 */

/**
 * 665. 非递减数列
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 *
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *
 *
 * 提示：
 *
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5 <= nums[i] <= 10 ^ 5
 */
class Solution665 {


    public static void main(String[] args) {
        int[] arr = {4,2,3};
        System.out.println("result:" + checkPossibility(arr));
    }


    public static boolean checkPossibility(int[] nums) {
        if(nums.length <= 2) return true;
        int count = 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            if(nums[i] < nums[i - 1] || nums[i] < max){
                max = nums[i - 1];
                count++;
            }

            if(count > 1) return false;
        }
        return true;
    }



}
