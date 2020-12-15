package com.justin.algorithm.array.easy;
/*
 * created by Justin on 2020/12/14
 * email: wcw1992yu@163.com
 * github: https://github.com/wangchongwei
 */

import java.util.Arrays;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *  
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class SolutionOffer3 {

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        System.out.println(search(nums, 9));
    }


    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        if(nums[0] > target || nums[nums.length - 1] < target) return 0;
        int count = 0;
        for (int i: nums) {
            if(i == target) count ++;
            if(i > target) return count;
        }
        return count;
    }

}
/**
 * 直接遍历查找就可以，时间复杂度O(n)
 * 之前忽略了条件中的有序数组条件，
 * 针对有序数组，我们可以采用二分法，
 */