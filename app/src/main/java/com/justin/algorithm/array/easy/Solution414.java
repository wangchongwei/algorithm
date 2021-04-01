package com.justin.algorithm.array.easy;
/*
 * created by Justin on 2021/3/12
 * email: wcw1992yu@163.com
 * github: https://github.com/wangchongwei
 */

/**
 * 414. 第三大的数
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * 示例 2：
 *
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * 示例 3：
 *
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -2^31 <= nums[i] <= 2^31 - 1
 *
 *
 * 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
 */

class Solution414 {


    public static void main(String[] args) {
        int[] arr = {-2147483648, 1, 1, 2};
        System.out.println("result = " + thirdMax(arr));
    }


    public static int thirdMax(int[] nums) {
        int min = Integer.MIN_VALUE;
        int max = min, second = max, third = second;


        boolean hasMin = false;
        for (int i : nums) {
            if(i > max) {
                third = second;
                second = max;
                max = i;

            } else if (i == max || i == second || i == third) {
                if (i == third && i == min) {
                    hasMin = true;
                }
            } else if (i > second) {
                third = second;
                second = i;
            } else if (i > third) {
                third = i;
            }
        }
        if(third == max || third == second || (third == min && !hasMin)) {
            return max;
        }
        return third;
    }

}

/**
 * 题解：
 * 一次遍历，依次给最大值、第二值、第三大值赋值，但是考虑临界值
 * -2^31 <= nums[i] <= 2^31 - 1 要考虑int溢出
 * 使用boolean值来判断数组中是否含有min，如果含有并且第三值等于min，则返回最小值，
 * 如果不含邮时，说明第三值等于最小值只是因为不存在第三值，此时返回最大值。
 * */