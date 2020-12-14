package com.justin.algorithm;
/*
 * created by Justin on 2020/12/14
 * email: wcw1992yu@163.com
 * github: https://github.com/wangchongwei
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * 26. 删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 *
 * 说明:
 *
 * 为什么返回数值是整数，但输出的答案是数组呢?
 *
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 */

public class Solution26 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(nums);
    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        if(nums[nums.length - 1] == nums[0]) return 1;
        int left = 1;
        int right = 1;
        for (int i = 1; i < nums.length; i ++) {
            right = i;
            if(nums[i] == nums[i - 1]) continue;
            if (right > left && right <= nums.length - 1) {
                for (int j = 0; j < right - left; j ++) {
                    nums[left + j] = nums[right];
                    i--;
                }
                System.out.println("i = " + i);
                System.out.println(Arrays.toString(nums));
                right = left;
                left = i + 1;
            } else {
                left = i + 1;
            }
        }
        System.out.println("result ==== " + left);
        System.out.println(Arrays.toString(nums));
        return left;
    }


    public static int removeDuplicates2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        if(nums[nums.length - 1] == nums[0]) return 1;
        int newIndex = 0;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]) {
                newIndex ++;
                nums[newIndex] = nums[i];
            }
        }
        return newIndex + 1;
    }
}

/**
 * 限定空间复杂度为O(1) 所以数组操作只能在原数组上操作，
 * 思路使用双指针，当碰到相同元素时，右指针右移，直到不想等，然后将重复的元素都设置为下一个不想等的元素，
 * 这样有一个明显的弊端，每次修改元素的值时，需要操作的元素越来越多，
 * 因为 将重复的元素都设置为下一个不想等的元素 ，此时肯定会造成下一个元素的重复，导致重复元素的个数只会越来越多。
 *
 * 思路二：我们不考虑重复元素的下标，遍历元素，碰到重复元素就将其修改为下一个不重复的元素，
 * 用双指针，一个指针遍历所有元素，一个指针跟随不重复的元素
 * */