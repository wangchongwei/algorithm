/**
 * 合并区间
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。

 

示例 1：

输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2：

输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 

提示：

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
相关标签
排序
数组

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/array-and-string/c5tv3/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function (intervals) {
    let len = intervals.length;
    if (len == 1) return intervals;
    let result = [];
    let first = 0;
    intervals.sort((a, b) => a[0] - b[0]);
    while (first < len - 1) {
        let arr = mergeTwoArray(intervals[first], intervals[first + 1]);
        intervals[++first] = arr[arr.length - 1];
        console.log('arr', arr);
        if (arr.length == 1 && first == len - 1) {
            result.push(arr[0]);
        } else if (arr.length == 2) {
            result.push(arr[0]);
            if (first == len - 1) {
                result.push(arr[1]);
            }
        }
        if (first == len - 1) {
            console.log('arr[arr.length - 1]', arr[arr.length - 1]);
        }
    }
    console.log('result', result);
    return result;
};

/**
 * 合并两个数组
 * @param {number[]} arr1 
 * @param {number[]} arr2 
 */
var mergeTwoArray = function (arr1, arr2) {
    if (arr1[0] < arr2[0]) {
        // arr1 左边界小于arr2 左边界
        if (arr1[1] < arr2[0]) {
            return [arr1, arr2];
        } else {
            return [[arr1[0], Math.max(arr1[1], arr2[1])]];
        }
    } else {
        if (arr1[0] <= arr2[1]) {
            return [[arr2[0], Math.max(arr1[1], arr2[1])]];
        } else {
            return [arr2, arr1];
        }
    }
}

const intervals = [[2, 3], [4, 5], [6, 7], [8, 9], [1, 10]]

merge(intervals);