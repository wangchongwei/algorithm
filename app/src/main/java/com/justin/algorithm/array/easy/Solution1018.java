package com.justin.algorithm.array.easy;
/*
 * created by Justin on 2020/12/16
 * email: wcw1992yu@163.com
 * github: https://github.com/wangchongwei
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1018. 可被 5 整除的二进制前缀
 * 给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 *
 * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[0,1,1]
 * 输出：[true,false,false]
 * 解释：
 * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
 * 示例 2：
 *
 * 输入：[1,1,1]
 * 输出：[false,false,false]
 * 示例 3：
 *
 * 输入：[0,1,1,1,1,1]
 * 输出：[true,false,false,false,true,false]
 * 示例 4：
 *
 * 输入：[1,1,1,0,1]
 * 输出：[false,false,false,false,false]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 30000
 * A[i] 为 0 或 1
 */

class Solution1018 {

    public static void main(String[] args) {
        prefixesDivBy5(new int[]{0,1,1,1,1,1});
    }

    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean>list = new ArrayList<>(A.length);
        int[] a = new int[A.length];

        if(A[0] == 0) {
            a[0] = 0;
            list.add(true);
        } else {
            a[0] = 1;
            list.add(false);
        }
        for(int i = 1; i < A.length; i ++) {
            a[i] = (a[i - 1] * 2 + A[i]) % 10;
            list.add(a[i] % 5 == 0);
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(list.toArray()));
        return list;
    }
}

/**
 * 很明显就是二进制转换，
 * a[i] = (a[i - 1] * 2 + A[i]) % 10;
 * 每次增加一位时，其实就是上一位转换的值 * 2 + 当前位的值
 * 但有一个问题时，当数组长度过长时，会溢出，因为是判断能否被5整除，所以我们只要保留各位就可以了。
 *
 */
