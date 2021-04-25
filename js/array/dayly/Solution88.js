/**
 * 88. 合并两个有序数组
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。

 

示例 1：

输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]
示例 2：

输入：nums1 = [1], m = 1, nums2 = [], n = 0
输出：[1]
 

提示：

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[i] <= 109
 * 
 * 
 */

var merge = function(nums1, m, nums2, n) {
    if(n == 0) return nums1;
    // num2 整体比num1[m - 1] 大，则排在num1[m - 1]后
    if(nums2 [0] >= nums1[m - 1]) {
        for(let i = 0; i < n; i ++) {
            nums1[m + i] = nums2[i];
        }
    } else if (nums2[n - 1] <= nums1[0]) {
        // num2 整体比num1[m - 1] 小，则排在num1[m - 1]前
        for(let i = m + n - 1; i >= 0; i --) {
            if(i >= n) {
                nums1[i] = nums1[i - n];
            } else {
                nums1[i] = nums2[i];
            }
        }
    } else {
        // 两个数组的数字区间存在交集
        for(let i = m; i < m + n ; i ++) {
            nums1 [i] = nums2[i - m];
        }
        nums1.sort((a, b) => a - b)
    }
    console.log('num1:', nums1);
    return nums1;
};

var arr1 = [1,2,3,4,5,6,0,0,0];
var arr2 = [7, 8, 9];
var arr3 = [-2, -1, 0];
var arr4 = [-1, 4, 5];

// merge(arr1, 6, arr4, 3);
merge([0], 0, [1], 1);

/**
 * 因为两个数组为有序数组，
 * 将两个数组的第一位到最后一位数字，视为一段区间，存在三种情况，
 * 1：arr2处于arr1左边
 * 2：arr2处于arr1右边
 * 3、arr2与arr1存在交集
 */

/**
 * 
 * @param {*} arr1 
 * @param {*} m 
 * @param {*} arr2 
 * @param {*} n 
 * 双指针法
 */
function merge2 (arr1, m, arr2, n) {
    let p1 = 0, p2 = 0;
    let current;
    let arr_result = new Array(m + n).fill(0);
    while(p1 < m || p2 < n) {
        if(p1 == m) {
            current = arr2[p2++];
        } else if (p2 == n) {
            current = arr1[p1++];
        } else if (arr1[p1] <= arr2[p2]) {
            current = arr1[p1++];
        } else {
            current = arr2[p2++];
        }
        arr_result[p1 + p2 - 1] = current;
    }
    arr1 = arr_result;
    console.log(arr1);
}
merge2(arr1, 6, arr4, 3);
