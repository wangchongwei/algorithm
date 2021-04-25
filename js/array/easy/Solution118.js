/**
 * 118. 杨辉三角
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。



在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
var generate = function(numRows) {
    if(numRows == 0) return [];
    if(numRows == 1) return [[1]];
    if(numRows == 2) return [[1], [1,1]];
    var result = [];
    for(let i = 0; i < numRows; i ++) {
        var row = [];
        for(let j = 0; j <= i; j++) {
            console.log('i = ' + i, " j = " + j);
            if(j == 0 || j == i) {
                row.push(1);
            } else {
                row.push(result[i - 1][j - 1] + result[i - 1][j]);
            }
        }
        result.push(row);
    }
    console.log('result:', result);
    return result;
};

generate(10);