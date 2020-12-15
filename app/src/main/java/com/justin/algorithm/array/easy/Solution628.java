package com.justin.algorithm.array.easy;
/*
 * created by Justin on 2020/12/15
 * email: wcw1992yu@163.com
 * github: https://github.com/wangchongwei
 */

class Solution628 {

    public static void main(String[] args) {
        int[] a = {-100,-98,-1,2,3,4};
        System.out.println("result = " + maximumProduct(a));
    }


    public static int maximumProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return nums[0] * nums[1];
        if(nums.length == 3) return nums[0] * nums[1] * nums[2];

        // 正数
        int max = -1000;
        int second = max;
        int third = second;
        // 负数
        int min = 0;
        int secondMin = 0;


        for (int i : nums) {
            // 正数情况
            if(i >= max) {
                third = second;
                second = max;
                max = i;
            } else if (i >= second) {
                third = second;
                second = i;
            } else if (i > third) {
                third = i;
            }
            // 负数
            if(i <= min) {
                secondMin = min;
                min = i;
            } else if (i < secondMin) {
                secondMin = i;
            }
        }
        int result = Math.max(max * second * third, max * min * secondMin);
        System.out.println("min = " + min + "  secondMin = " + secondMin + "  max = " + max);
        System.out.println("max = " + max + "  second = " + second + "  third = " + third);
        return result;
    }

}

/**
 * 三个子元素乘积最大，第一理解是取三个最大数乘积即可，但提交发现异常，还需要考虑负数问题，因为负负得正。
 * 所以我们只需要得出5个数，三个是最大值，两个最小值，因为负负得正，所以最小值只需两个。
 * 最后比较一下，三个最大值乘积、两个最小值与最大值乘积，取两者较大值即可。
 */
