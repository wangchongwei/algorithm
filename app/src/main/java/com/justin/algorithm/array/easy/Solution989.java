package com.justin.algorithm.array.easy;
/*
 * created by Justin on 2020/12/16
 * email: wcw1992yu@163.com
 * github: https://github.com/wangchongwei
 */
/**
 * 989. 数组形式的整数加法
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 *
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * 示例 2：
 *
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * 示例 3：
 *
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * 示例 4：
 *
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * 如果 A.length > 1，那么 A[0] != 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import android.icu.lang.UScript;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution989 {

    public static void main(String[] args){
        System.out.println("result = " + addToArrayForm(new int[]{0}, 23));
    }

    // 当数组的值过大会溢出，导致结果错误
    public static List<Integer> addToArrayForm(int[] A, int K) {
        if(A.length > 5) return addToArrayForm2(A, K);
        int n = A.length;
        int num = 0;
        for(int i = 0; i < n; i ++) {
            num += A[i] * Math.pow(10, n - i - 1);
        }
        num += K;
        System.out.println("num = " + num);
        n = String.valueOf(num).length();
        List<Integer>list = new ArrayList<>(n);
        for(int i = 0; i < n; i ++) {
            if(i == n - 1) {
                list.add(num);
                break;
            }
            int vale = (int) (Math.pow(10, n - i - 1));
            System.out.println("value = " + vale);
            list.add(num / vale);
            num = num % vale;
        }
        return list;
    }


    public static List<Integer> addToArrayForm2(int[] A, int K) {
        int n = A.length;
        String kstr = String.valueOf(K);
        boolean needAdd = false;

        for (int i = n -1; i >= 0; i --) {
            int kIndex = kstr.length() - n + i;
            int a = A[i];
            if(kIndex >= 0) {
                a = a + Integer.parseInt(kstr.charAt(kIndex) + "");
            }
            if(needAdd) a = a + 1;
            if(a>= 10) {
                a = a - 10;
                needAdd = true;
            } else {
                needAdd = false;
            }
            A[i] = a;
        }

        List<Integer>list = new ArrayList<>();
        if(needAdd) {
            list.add(0, 1);
        }
        for(int i : A) {
            list.add(i);
        }
        return list;
    }


}
