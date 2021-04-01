package com.justin.algorithm.array.easy;
/*
 * created by Justin on 2020/12/28
 * email: wcw1992yu@163.com
 * github: https://github.com/wangchongwei
 */

import java.util.HashMap;

/**
 * 1013. 将数组分成和相等的三个部分
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 *
 * 形式上，如果可以找出索引 i+1 < j 且满足 A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1] 就可以将数组三等分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * 示例 2：
 *
 * 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出：false
 * 示例 3：
 *
 * 输入：[3,3,6,5,-2,2,5,1,-9,4]
 * 输出：true
 * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *
 *
 * 提示：
 *
 * 3 <= A.length <= 50000
 * -10^4 <= A[i] <= 10^4
 */


class Solution1013 {


    public static void main(String[] args) {
        int[] a = new int[]{0,-1, 1, 0, -1, 1,0};
        System.out.println("result = " + canThreePartsEqualSum(a));
    }

    public static boolean canThreePartsEqualSum(int[] arr) {

        int[] sumArr = new int[arr.length];
        sumArr[0] = arr[0];
        for (int i = 1; i < arr.length; i ++) {
            sumArr[i] = sumArr[i - 1] + arr[i];
        }
        if(sumArr[arr.length - 1] % 3 != 0) return false;




        return false;
    }

}
