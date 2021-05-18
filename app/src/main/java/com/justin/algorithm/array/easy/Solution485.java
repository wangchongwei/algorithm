package com.justin.algorithm.array.easy;
/*
 * created by Justin on 2021/4/7
 * email: wcw1992yu@163.com
 * github: https://github.com/wangchongwei
 */

/**
 * 485. 最大连续 1 的个数
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 *
 *
 *
 * 示例：
 *
 * 输入：[1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 *
 *
 * 提示：
 *
 * 输入的数组只包含 0 和 1 。
 * 输入数组的长度是正整数，且不超过 10,000。
 */
class Solution485 {


    public static void main(String[] args) {
        int[] arr = {};
        System.out.println("result:" + findMaxConsecutiveOnes(arr));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for(int num : nums) {
            if(num == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }

        }
        return max;
    }

}
