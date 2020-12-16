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
 * 830. 较大分组的位置
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 *
 * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 *
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 *
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 *
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abbxxxxzzy"
 * 输出：[[3,6]]
 * 解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * 示例 2：
 *
 * 输入：s = "abc"
 * 输出：[]
 * 解释："a","b" 和 "c" 均不是符合要求的较大分组。
 * 示例 3：
 *
 * 输入：s = "abcdddeeeeaabbbcd"
 * 输出：[[3,5],[6,9],[12,14]]
 * 解释：较大分组为 "ddd", "eeee" 和 "bbb"
 * 示例 4：
 *
 * 输入：s = "aba"
 * 输出：[]
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅含小写英文字母
 * 通过次数13,272提交次数27,606
 */


class Solution830 {


    public static void main(String[] args) {
        largeGroupPositions("abcdddeeeeaabbbcd");
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>>lists = new ArrayList<>();
        if(s.length() < 3) return lists;
        s = s + "A";
        int start = 0;
        int end = 0;
        for (int i = 1; i < s.length(); i ++) {
            char current = s.charAt(i);
            if(current != s.charAt(i - 1)) {
                // 不同元素
                if(end - start >= 2) {
                    // 超过三个
                    lists.add(Arrays.asList(start, end));
                }
                start = i;
            } else {
                end = i;
            }
        }
        return lists;
    }

}

/**
 * 双指针，一个指向相同字符的起点，一个指向终点，
 * 当相减大于等于2时，则添加
 * 因为要考虑最后一个元素是否想等问题，我们可以在开头直接给s字符串最后追加一个大写字母A，
 * 因为原本的字符串都是小写，保证最后一位不相等
 */
