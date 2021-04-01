package com.justin.algorithm.array.middle;
/*
 * created by Justin on 2021/3/15
 * email: wcw1992yu@163.com
 * github: https://github.com/wangchongwei
 */

import java.util.Arrays;

/**
 * 48. 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * 示例 2：
 *
 *
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * 示例 3：
 *
 * 输入：matrix = [[1]]
 * 输出：[[1]]
 * 示例 4：
 *
 * 输入：matrix = [[1,2],[3,4]]
 * 输出：[[3,1],[4,2]]
 *
 *
 * 提示：
 *
 * matrix.length == n
 * matrix[i].length == n
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */
class Solution48 {

    public static void main(String[] args) {
        int [][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        rotate(matrix);
    }


    // 要求原地旋转，需要下面的解法不行。
    public static void rotate(int[][] matrix) {
        int rows = matrix.length;
        int [][]result = new int[rows][rows];
        // 行与列相等
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                result[j][i] = matrix[rows - 1 - i][j];
            }
        }
        for(int i = 0; i < result.length; i ++) {
            System.out.println(Arrays.toString(result[i]));
        }

    }

}


