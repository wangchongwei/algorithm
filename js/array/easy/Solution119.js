/**
 * 119. 杨辉三角 II
给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。



在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 3
输出: [1,3,3,1]
进阶：

你可以优化你的算法到 O(k) 空间复杂度吗？
杨辉三角的进阶
 */

var getRow = function(rowIndex) {
    if(rowIndex == 0) return [1];
    if(rowIndex == 1) return [1,1];
    var result = [];

    for(let i = 0; i <= rowIndex; i++) {
        if(i = 0) {
            result.push(1);
        } else if(i = 1) {
            result.push(i);
        } else if (i == 2) {
            let sum = rowIndex * (rowIndex - 1) / 2;
            result.push(sum);
        } else {
        }
    }
};

getRow(6);

// 56 = 21 + 15 + 10 + 6 + 3 + 1;
// 21 = 6 + 5 + 4 + 3 + 2 + 1;
// 15 = 5 + 4 + 3 + 2 + 1;
// 10 = 4 + 3 + 2 + 1;
// 6 = 3 + 2 + 1;
// 3 = 2 + 1;
// 1 = 1;

// 56 = 1 * 6 + 2 * 5 + 3 * 4 + 4 * 3 + 5 * 2 + 6 * 1
// 84 = 1 * 7 + 2 * 6 + ... + 7 * 1 = 7 + 12 + 15 + 16 + 15 + 12 + 7 = 84