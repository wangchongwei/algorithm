package com.justin.algorithm.array.easy;
/*
 * created by Justin on 2020/12/16
 * email: wcw1992yu@163.com
 * github: https://github.com/wangchongwei
 */

/**
 * 1232. 缀点成线
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 *
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 */
class Solution1232 {

    public static void main(String[]args) {
        System.out.println("result = " + checkStraightLine(new int[][]{{1,1}, {2,2}, {2,0}}));
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length <= 2) return true;
        // 先根据两个点确认比例
        // x轴距离
        int x = (coordinates[1][0] - coordinates[0][0]);
        int y = (coordinates[1][1] - coordinates[0][1]);
        if(x == 0) {
            for(int i = 2; i < coordinates.length; i ++) {
                if(coordinates[i][0] - coordinates[i-1][0] != 0) {
                    return false;
                }
            }

        } else if (y == 0) {
            for(int i = 2; i < coordinates.length; i ++) {
                if(coordinates[i][1] - coordinates[i-1][1] != 0) {
                    return false;
                }
            }
        } else {
            for(int i = 2; i < coordinates.length; i ++) {
                float xy = (float) (x * 1.0 / y);
                float currentXy = (float) ((coordinates[i][0] - coordinates[0][0]) * 1.0 / (coordinates[i][1] - coordinates[0][1]));
                if(xy != currentXy) return false;
            }

        }
        return true;
    }

}
/**
 * 判断是否是位于一条直线上，看每次点x、y的增加比例是否一致
 *
 * */