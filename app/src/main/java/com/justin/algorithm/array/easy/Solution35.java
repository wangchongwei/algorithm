package com.justin.algorithm.array.easy;
/*
 * created by Justin on 2020/12/16
 * email: wcw1992yu@163.com
 * github: https://github.com/wangchongwei
 */

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */



class Solution35 {


    public static void main(String[] args) {
        System.out.println("result === " + searchInsert2(new int[]{1,3},2));
    }

    public static int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return 0;
        if(target <= nums[0]) return 0;
        if(target > nums[nums.length - 1]) return nums.length;
        if(target == nums[nums.length - 1]) return nums.length - 1;

        for(int i = 0; i < nums.length ; i ++) {
            if(nums[i] < target) continue;
            if(nums[i] >= target) {
                return i;
            }
        }
        return -1;
    }

    public static int searchInsert2(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}

/**
 * 因为是有序数组，
 * 如果小于或者等于第一位，则为0
 * 如果大于最后一位则 length
 * 如果等于最后一位，则为 length - 1
 *
 * 如果都不是则在数组区间内，有序数组碰到第一位等于或大于的数字，则为插入下标
 *
 * 更优解，二分查找
 */
