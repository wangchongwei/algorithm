package com.justin.algorithm.array.easy;
/*
 * created by Justin on 2021/4/14
 * email: wcw1992yu@163.com
 * github: https://github.com/wangchongwei
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 1252. 奇数值单元格的数目
 * 给你一个 m x n 的矩阵，最开始的时候，每个单元格中的值都是 0。
 *
 * 另有一个二维索引数组 indices，indices[i] = [ri, ci] 指向矩阵中的某个位置，其中 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
 *
 * 对 indices[i] 所指向的每个位置，应同时执行下述增量操作：
 *
 * ri 行上的所有单元格，加 1 。
 * ci 列上的所有单元格，加 1 。
 * 给你 m、n 和 indices 。请你在执行完所有 indices 指定的增量操作后，返回矩阵中 奇数值单元格 的数目。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：m = 2, n = 3, indices = [[0,1],[1,1]]
 * 输出：6
 * 解释：最开始的矩阵是 [[0,0,0],[0,0,0]]。
 * 第一次增量操作后得到 [[1,2,1],[0,1,0]]。
 * 最后的矩阵是 [[1,3,1],[1,3,1]]，里面有 6 个奇数。
 * 示例 2：
 *
 *
 *
 * 输入：m = 2, n = 2, indices = [[1,1],[0,0]]
 * 输出：0
 * 解释：最后的矩阵是 [[2,2],[2,2]]，里面没有奇数。
 *
 *
 * 提示：
 *
 * 1 <= m, n <= 50
 * 1 <= indices.length <= 100
 * 0 <= ri < m
 * 0 <= ci < n
 *
 *
 * 进阶：你可以设计一个时间复杂度为 O(n + m + indices.length) 且仅用 O(n + m) 额外空间的算法来解决此问题吗？
 */
class Solution1252 {

    public static void main(String[] args) {
        int[][] arr = {{1,1}, {1, 1}};
        System.out.println("result = " + oddCells2(3,3, arr));
    }


    public static int oddCells(int m, int n, int[][] indices) {
        int[][] arr= new int[m][n];
        for(int i = 0; i < indices.length; i ++) {
            int row = indices[i][0];
            int colums = indices[i][1];

            for(int a = 0; a < m; a ++) {
                if(a == row) {
                   for(int k =0; k < n; k++) {
                       arr[a][k] += 1;
                   }
                }
                arr[a][colums] += 1;
            }
        }
        int count = 0;
        for(int i = 0; i < m; i ++) {
            for(int b = 0; b < n; b ++) {
                if(arr[i][b] % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }


    public static int oddCells2(int m, int n, int[][] indices) {
        int count = 0;
        Map<Integer, Integer> rowMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> columnMap = new HashMap<Integer, Integer>();
        int row = 0;
        int column = 0;
        for(int i = 0; i < indices.length; i ++) {
            row = indices[i][0];
            column = indices[i][1];
            if(rowMap.containsKey(row)) {
                rowMap.put(row, rowMap.get(row) + 1);
            } else {
                rowMap.put(row, 1);
            }
            if(columnMap.containsKey(column)) {
                columnMap.put(column, columnMap.get(column) + 1);
            } else {
                columnMap.put(column, 1);
            }
        }
        System.out.println("rowMap" + rowMap);
        System.out.println("columnMap" + columnMap);
        row = 0;
        for(int key : rowMap.keySet()) {
            // 遍历需要加1的行
            if(rowMap.get(key) % 2 == 1) {
                count += n;
                row ++;
            }
        }
        column = 0;
        for(int key : columnMap.keySet()) {
            // 遍历需要加1的列
            if(columnMap.get(key) % 2 == 1) {
                count += m;
                column ++;
            }
        }
        System.out.println("count" + count);
        return count - row * column * 2;
    }

}
