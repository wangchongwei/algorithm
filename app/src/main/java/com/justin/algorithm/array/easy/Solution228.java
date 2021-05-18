package com.justin.algorithm.array.easy;
/*
 * created by Justin on 2021/4/6
 * email: wcw1992yu@163.com
 * github: https://github.com/wangchongwei
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 228. 汇总区间
 * 给定一个无重复元素的有序整数数组 nums 。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *
 *
 * 示例 1：
 *
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 示例 2：
 *
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * 示例 3：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 4：
 *
 * 输入：nums = [-1]
 * 输出：["-1"]
 * 示例 5：
 *
 * 输入：nums = [0]
 * 输出：["0"]
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * nums 中的所有值都 互不相同
 * nums 按升序排列
 */
class Solution228 {


    public static void main(String[] args) {
        int[] arr = {-1,1,3,5,6,8};
        List<String> result = summaryRanges(arr);
        System.out.println(result);
    }


    public static List<String> summaryRanges(int[] nums) {
        if(nums.length == 0) return Collections.emptyList();
        List<String> list = new ArrayList<>();

        int start = nums[0];
        if(nums.length == 1) {
            list.add("" + start);
            return list;
        }
        int end = start;
        for (int i = 1; i < nums.length; i ++) {
            System.out.println("i:" + i + " start:" + start + " end:" +end);
            if(nums[i] == end + 1) {
                end = nums[i];
                if(i == nums.length - 1) {
                    list.add(start + "->" + end);
                }
                continue;
            } else if(end == start) {
                list.add(""+start);
            } else {
                list.add(start + "->" + end);
            }
            start = nums[i];
            end = start;
            if(i == nums.length - 1) {
                list.add(start + "");
            }
        }
        return list;
    }
}
