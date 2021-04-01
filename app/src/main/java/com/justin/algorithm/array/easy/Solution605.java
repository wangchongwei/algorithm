package com.justin.algorithm.array.easy;
/*
 * created by Justin on 2021/3/12
 * email: wcw1992yu@163.com
 * github: https://github.com/wangchongwei
 */

/**
 * 605. 种花问题
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * 示例 2：
 *
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] 为 0 或 1
 * flowerbed 中不存在相邻的两朵花
 * 0 <= n <= flowerbed.length
 *
 *
 */

class Solution605 {


    public static void main(String[] args) {
        int[] arr = {0,1,0};
        System.out.println("result:" + canPlaceFlowers(arr, 1));
    }


    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int zeroCount = 0;
        boolean isStart = true, isEnd = false;
        for(int i = 0; i < flowerbed.length; i ++) {
            if(i == flowerbed.length - 1 && flowerbed[i] == 0) isEnd = true;
            if(flowerbed[i] == 0) {
                zeroCount++;
            }
            if(flowerbed[i] == 1 && zeroCount > 0 || isEnd) {
                if(isStart && isEnd) {
                    System.out.println("---1:" + zeroCount);
                    if(zeroCount % 2 == 0) {
                        count += zeroCount / 2;
                    } else {
                        count += zeroCount / 2 + 1;
                    }

                } else if (isStart || isEnd) {
                    System.out.println("---2:" + zeroCount + isStart + isEnd);
                    count += zeroCount / 2;
                } else if(zeroCount > 2) {
                    System.out.println("---3:" + zeroCount);
                    if(zeroCount % 2 == 0) {
                        count += (zeroCount -2) / 2;
                    } else {
                        count += (zeroCount -2) / 2 + 1;
                    }
                }
                if(count >= n) return true;
                zeroCount = 0;
                isStart = false;
            } else if (flowerbed[i] == 1) {
                System.out.println("---4:" + zeroCount);
                isStart = false;
                zeroCount = 0;
            }
        }
        return count >= n;
    }
}


/**
 * 只有0处才能种花，0分三种情况，0处于前面，处于中间、处于后面
 */
