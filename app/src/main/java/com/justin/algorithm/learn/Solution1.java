package com.justin.algorithm.learn;
/*
 * created by Justin on 2021/5/12
 * email: wcw1992yu@163.com
 * github: https://github.com/wangchongwei
 */

/**
 *
 * 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *  
 *
 * 提示：
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *  
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/tencent/xx6c46/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution1 {


    public static void main(String[] args) {
        int[] num1 = {}, num2 = {2};
        double b = findMedianSortedArrays(num1, num2);
        System.out.println("result: " + b);
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m + n == 1 ){
            if(m == 0) return nums2[0];
            if(n == 0) return nums1[0];
        }
        int m1 = 0, n1 = 0, center = (m + n) / 2;
        int[] ans = new int[m + n];
        while(m1 < m || n1 < n) {
            if(m1 == m) {
                ans[m1 + n1] = nums2[n1];
                n1 ++;
            } else if (n1 == n) {
                ans[m1 + n1] = nums1[m1];
                m1 ++;
            } else if(nums1[m1] <= nums2[n1]) {
                ans[m1 + n1] = nums1[m1];
                m1 ++;
            }  else {
                ans[m1 + n1] = nums2[n1];
                n1 ++;
            }
        };
        if((m + n) % 2 == 0) {
            return (ans[center - 1] + ans[center]) * 1.0 / 2;
        } else {
            return ans[center];
        }
    }
}
