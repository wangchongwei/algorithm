/**
 * 566. 重塑矩阵
在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。

给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。

重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。

如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。

示例 1:

输入: 
nums = 
[[1,2],
 [3,4]]
r = 1, c = 4
输出: 
[[1,2,3,4]]
解释:
行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
示例 2:

输入: 
nums = 
[[1,2],
 [3,4]]
r = 2, c = 4
输出: 
[[1,2],
 [3,4]]
解释:
没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
注意：

给定矩阵的宽和高范围在 [1, 100]。
给定的 r 和 c 都是正数。
 */

/**
 * @param {number[][]} nums
 * @param {number} r
 * @param {number} c
 * @return {number[][]}
 */
var matrixReshape = function(nums, r, c) {
    var rows = nums.length;
    var columns = nums[0].length;
    if(columns * rows != r * c) return nums;
    var i = 0, j = 0;
    var newArr = [[]];
    var count = 0;
    console.log('rows', rows, 'colums', columns);
    while((i+1) *(j +1) <= r * c) {
        var index =  j + count;
        var nr = Math.floor(index/columns);
        var nc = (index) % columns;
        console.log('i', i, 'j', j, 'index', index, 'nr', nr, 'nc', nc);
        var currentR = nums[nr];
        var oldValue = currentR[nc];
        newArr[i].push(oldValue);
        if(j == c - 1) {
            if(i == r - 1) {
                break;
            }
            // 填满了一行
            i ++;
            j = -1;
            newArr[i] = [];
            count = i * c
        }
        j ++;
    }
    return newArr;
};

var arr =[[1,2], [3,4]]
console.log('result:', matrixReshape(arr, 1, 4));


// console.log('value', arr[0][1]);
