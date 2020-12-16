package com.justin.algorithm.array.easy;
/*
 * created by Justin on 2020/12/15
 * email: wcw1992yu@163.com
 * github: https://github.com/wangchongwei
 */

/**
 * 1646. 获取生成数组中的最大值
 * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
 *
 * nums[0] = 0
 * nums[1] = 1
 * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
 * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
 * 返回生成数组 nums 中的 最大 值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 7
 * 输出：3
 * 解释：根据规则：
 *   nums[0] = 0
 *   nums[1] = 1
 *   nums[(1 * 2) = 2] = nums[1] = 1
 *   nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
 *   nums[(2 * 2) = 4] = nums[2] = 1
 *   nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
 *   nums[(3 * 2) = 6] = nums[3] = 2
 *   nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
 * 因此，nums = [0,1,1,2,1,3,2,3]，最大值 3
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：1
 * 解释：根据规则，nums[0]、nums[1] 和 nums[2] 之中的最大值是 1
 */

import java.util.Arrays;

class Solution1646 {


    public static void main(String[] args) {
        System.out.println("result = " + getMaximumGenerated2(15));
    }

    public static int getMaximumGenerated(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        int[] result = new int[n+1];
        result[0] = 0;
        result[1] = 1;
        int max = 1;
        for (int i = 2; i <= n; i ++) {
            if(i % 2 == 0) {
                // 偶数
                result[i] = result[i / 2];
            } else {
                // 奇数
                result[i] = result[i / 2] + result[i / 2 + 1];
            }
            max = Math.max(max, result[i]);
        }
        System.out.println("array = " + Arrays.toString(result) + "   max ===" + max);
        return max;
    }

    public static int getMaximumGenerated2(int n) {
        int max = 0;
        for(int i = 0; i <= n; i++) {
            if(i % 2 == 0) continue;
            max = Math.max(max, getX(i));
        }
        return max;
    }

    public static int getX(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;
        if(n % 2 == 0) return getX(n / 2);
        return getX(n / 2) + getX(n / 2 + 1);
    }
}

/**
 * 依次遍历完成数组的赋值即可获取到最大值
 *
 * 更优解：不需要完全赋值整个数组，
 * 而是直接根据公示：奇数肯定比偶数大，转换成16进制时，1占多的数。
 * result[i] = result[i / 2] + result[i / 2 + 1];
 * 所有的奇数偶数最后都会被拆成1，2
 * 最后变成了递归调用
 * */
