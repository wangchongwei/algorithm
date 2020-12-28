package com.justin.algorithm.array.easy;
/*
 * created by Justin on 2020/12/22
 * email: wcw1992yu@163.com
 * github: https://github.com/wangchongwei
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 */

class SolutionOffer29 {

    public static void main(String[] args) {

        int[][] a = new int[][]{{1,2,3}, {4, 5, 6}, {7, 8, 9}};
        spiralOrder(a);
    }

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        if (matrix.length == 1) return matrix[0];
        int[] result = new int[matrix.length * matrix[0].length];
        int row = matrix.length, column = matrix[0].length;

        for(int i = 0 ; i < row - 1; i ++) {

        }

        return result;
    }

}
